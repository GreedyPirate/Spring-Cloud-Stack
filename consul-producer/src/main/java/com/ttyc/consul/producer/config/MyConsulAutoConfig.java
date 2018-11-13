package com.ttyc.consul.producer.config;

import com.ecwid.consul.v1.agent.model.NewService;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistrationCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.PropertyResolver;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * 重写instance-id
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/11/9
 */
public class MyConsulAutoConfig extends ConsulAutoRegistration {

    public MyConsulAutoConfig(NewService service, AutoServiceRegistrationProperties autoServiceRegistrationProperties, ConsulDiscoveryProperties properties, ApplicationContext context, HeartbeatProperties heartbeatProperties) {
        super(service, autoServiceRegistrationProperties, properties, context, heartbeatProperties);
    }

    public static ConsulAutoRegistration registration(AutoServiceRegistrationProperties autoServiceRegistrationProperties,
                                                      ConsulDiscoveryProperties properties, ApplicationContext context,
                                                      List<ConsulRegistrationCustomizer> registrationCustomizers,
                                                      HeartbeatProperties heartbeatProperties) {

        NewService service = new NewService();
        String appName = getAppName(properties, context.getEnvironment());
        service.setId(getInstanceId(properties, context));
        if(!properties.isPreferAgentAddress()) {
            service.setAddress(properties.getHostname());
        }
        service.setName(normalizeForDns(appName));
        service.setTags(createTags(properties));

        if (properties.getPort() != null) {
            service.setPort(properties.getPort());
            // we know the port and can set the check
            setCheck(service, autoServiceRegistrationProperties, properties, context, heartbeatProperties);
        }

        ConsulAutoRegistration registration = new ConsulAutoRegistration(service, autoServiceRegistrationProperties,
                properties, context, heartbeatProperties);
        customize(registrationCustomizers, registration);
        return registration;
    }

    public static String getInstanceId(ConsulDiscoveryProperties properties, ApplicationContext context) {
        if (!StringUtils.hasText(properties.getInstanceId())) {
            return normalizeForDns(getDefaultInstanceId(context.getEnvironment(), true));
        } else {
            return normalizeForDns(properties.getInstanceId());
        }
    }

    public static String getDefaultInstanceId(PropertyResolver resolver, boolean includeHostname) {
        String vcapInstanceId = resolver.getProperty("vcap.application.instance_id");
        if (StringUtils.hasText(vcapInstanceId)) {
            return vcapInstanceId;
        }

        String hostname = null;
        if (includeHostname) {
            hostname = resolver.getProperty("spring.cloud.client.hostname");
        }
        String appName = resolver.getProperty("spring.application.name");

        String namePart = combineParts(appName, SEPARATOR, getLinuxLocalIp());

        String indexPart = resolver.getProperty("spring.application.instance_id",
                resolver.getProperty("server.port"));

        return combineParts(namePart, SEPARATOR, indexPart);
    }

    public static String combineParts(String firstPart, char separator, String secondPart) {
        String combined = null;
        if (firstPart != null && secondPart != null) {
            combined = firstPart + separator + secondPart;
        } else if (firstPart != null) {
            combined = firstPart;
        } else if (secondPart != null) {
            combined = secondPart;
        }
        return combined;
    }

    public static String getLinuxLocalIp(){
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ip = "unknown";
        }
        return ip;
    }
}
