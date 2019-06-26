package com.ttyc.jdk;

import com.ttyc.jdk.assist.User;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Map.Entry<Long,Short> map
 * getActualTypeArguments : Long, Short
 * ownerType: Map
 *
 * List<String> list
 * getRawType : List
 */
public class ParameterizeApi {

    @Test
    public void testParameterize() {
        List<User> list = new ArrayList<>();

        Type type = list.getClass();
        if(type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            Type[] actualTypeArguments = pType.getActualTypeArguments();
            Type ownerType = pType.getOwnerType();
            Type rawType = pType.getRawType();
            String typeName = pType.getTypeName();

            System.out.println("typeName = " + typeName);
        }
    }
}
