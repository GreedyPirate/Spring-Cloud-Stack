package com.ttyc.mq.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class HostUtils {
    private static Logger logger = LoggerFactory.getLogger(HostUtils.class);

    public static String getHostName() {
        String hostname = "UnknownHost";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname = addr.getHostName().toString();
        } catch (IOException e) {
            logger.error("get hostname by InetAddress failed, try to exec hostname command");
            BufferedReader bis = null;
            try {
                Process process = Runtime.getRuntime().exec("hostname");
                bis = new BufferedReader(new InputStreamReader(process.getInputStream()));
                hostname = bis.readLine();
            } catch (IOException e1) {
                logger.error("get hostname completely failed");
            }finally {
                try {
                    bis.close();
                } catch (IOException e1) {
                    logger.error("close stream failed");
                }
            }
        }
        return hostname;
    }
}
