package com.ttyc.admin.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@EnableScheduling
/**
 *
 * This is a quite normal. The browser does some long polling and keeps the tcp connection open. If the browser window is closed the tcp connection is aborted and on the next write the exception is thrown. there is nothing to do about this, except changing the loglevel.
 * 这是很正常的。浏览器执行一些长轮询并保持TCP连接打开。如果浏览器窗口关闭，则中止TCP连接，并在下一次写入时抛出异常。除了更改日志级别之外，这没有什么可做的。
 * @author yangjie
 * @since 1.0.0
 * @createTime 2018/9/7
 */
public class AdminClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminClientApplication.class, args);
	}

	@GetMapping
	public String info(){
		log.debug("测试日志级别");
		return "ok";
	}
}
