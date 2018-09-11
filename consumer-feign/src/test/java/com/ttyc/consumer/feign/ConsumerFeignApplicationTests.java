package com.ttyc.consumer.feign;

import com.netflix.loadbalancer.ServerList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.cloud.netflix.ribbon.eureka.RibbonEurekaAutoConfiguration;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class ConsumerFeignApplicationTests {
	private ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(RibbonEurekaAutoConfiguration.class));


	@Test
	public void testLoadBean(){
		this.contextRunner.run(context -> {
			assertThat(context).hasSingleBean(ServerList.class);
		});
	}

	@Autowired
	private ApplicationContext context;

	@Test
	public void testBeanCreation() {
		ServerList serverList = this.context.getBean(ServerList.class);
		Assert.assertNotNull(serverList);
	}

	@Autowired
	private FeignContext feignContext;

	@Test
	public void testServerList(){
		ServerList serverList = feignContext.getInstance("foo", ServerList.class);
		Assert.assertNotNull(serverList);
	}
}
