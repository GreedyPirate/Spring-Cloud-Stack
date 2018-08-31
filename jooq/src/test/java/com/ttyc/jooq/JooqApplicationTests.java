package com.ttyc.jooq;

import com.example.domain.jooq.tables.pojos.User;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@JooqTest
public class JooqApplicationTests {

	@Autowired
	private DSLContext create;

	// 表别名
	com.example.domain.jooq.tables.User user = com.example.domain.jooq.tables.User.USER.as("u");

	@Test
	public void contextLoads() {
		List<User> users = create.select().from(user).where(user.ID.eq(UInteger.valueOf(4))).fetchInto(User.class);
		users.forEach(System.out::println);
	}


}
