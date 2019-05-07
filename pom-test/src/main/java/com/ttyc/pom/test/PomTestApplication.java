package com.ttyc.pom.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class PomTestApplication {



	public static void main(String[] args) {
	    SpringApplication.run(PomTestApplication.class, args);
    }

    @RestController
    class TestController{

        private AtomicInteger count = new AtomicInteger(1);

	    @GetMapping("add")
	    public void add(){
            for (int i = 0; i < 10; i++) {
                count.getAndIncrement();
            }
            count.compareAndSet(10, 1);
        }

	    @GetMapping("count")
	    public int getCount(){
	        return count.get();
        }

        @GetMapping("broken")
        public String broken() throws InterruptedException {
            TimeUnit.SECONDS.sleep(5);
	        return "info";
        }
    }
}
