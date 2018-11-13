package com.ttyc.consul.producer;

import com.ttyc.consul.producer.config.MyConsulAutoConfig;
import org.junit.Test;

public class ConsulProducerApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("87526097f2712e73b33981c57d9c9dd3".length());
	}

	@Test
	public void testGetIp() {
		System.out.println(MyConsulAutoConfig.getLinuxLocalIp());
	}
}
