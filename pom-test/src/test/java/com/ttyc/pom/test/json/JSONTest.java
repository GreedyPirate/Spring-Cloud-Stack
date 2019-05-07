package com.ttyc.pom.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;

import java.util.Date;

public class JSONTest {

    @Test
    public void testSer(){

        System.out.println();
        System.out.println(new Date().getTime());
    }

    @Test
    public void testParse() {
        User user = new User();
        user.setName("xx");
        user.setAge(18);
        user.setBirthday(new Date());
        String text = JSON.toJSONString(user);

        ParserConfig config = ParserConfig.getGlobalInstance();
        config.putDeserializer(User.class, new ThirdRestDeserializer());
        User o = JSON.parseObject(text, new TypeReference<User>() {});
    }
}
