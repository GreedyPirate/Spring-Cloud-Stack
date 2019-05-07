package com.ttyc.pom.test.json;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;
import java.util.Date;

public class ThirdRestDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        User memo = null;
        if (((Class)type).getName().equals(User.class.getName())) {
            memo = (new JavaBeanDeserializer(parser.getConfig(), User.class)).deserialze(parser, type, fieldName);
            memo.setBirthday(new Date(memo.getBirthday().getTime()*1000));
        }
        return (T) memo;
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LBRACE;
    }
}
