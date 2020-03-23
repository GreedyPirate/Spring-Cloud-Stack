package com.ttyc.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class ByteBufferTest {

    @Test
    public void testCase() {
        // 写：position从0开始，limit=capacity
        ByteBuffer buffer = ByteBuffer.allocate(20);
        // 写入3个int，每个4个字节，共12个字节
        for (int i = 0; i < 3; i++) {
            buffer.putInt(i);
            printBuffer(buffer);
        }

        System.out.println("================================");
        // 读之前要翻转，很巧妙的比喻
        buffer.flip();
        // 读：当然要从0开始读，flip之后，position=0， limit变为当前buffer可读的上限，即现有的12个字节
        while (buffer.hasRemaining()) {
            printBuffer(buffer);
            int anInt = buffer.getInt();
            System.out.println("anInt = " + anInt);
        }

        // 清除状态，回归到写之前的状态position :0,limit :20,capacity20
        buffer.clear();
        printBuffer(buffer);

        System.out.println("==============READ AGAIN=====================");
        // 虽然还是可以读，但是clear之后limit初始化为capacity，最后2个int读出来是0
        while (buffer.hasRemaining()) {
            printBuffer(buffer);
            int anInt = buffer.getInt();
            System.out.println("anInt = " + anInt);
        }

        buffer.clear();
        // 又可以写了
        buffer.put("hello".getBytes());

        System.out.println("==============读取 hello=====================");
        // 读之前flip，调整好position和limit
        buffer.flip();
        int index=0;
        char[] str = new char[5];
        while (buffer.hasRemaining()) {
            printBuffer(buffer);
            char cr = (char)buffer.get();
            str[index] = cr;
            index++;
        }
        System.out.println("str = " + new String(str));

        buffer.rewind();
    }


    public void printBuffer(ByteBuffer buffer) {
        System.out.println("position :" + buffer.position() + ",limit :" + buffer.limit() + ",capacity" + buffer.capacity());
    }

    @Test
    public void testArcticle() {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putInt(1);

        printBuffer(buffer);

        buffer.flip();
        while (buffer.hasRemaining()) {
            int anInt = buffer.getInt();
            System.out.println("anInt = " + anInt);
        }

        System.out.println("-----------");
        buffer.clear();
        while (buffer.hasRemaining()) {
            int anInt = buffer.getInt();
            System.out.println("anInt = " + anInt);
        }
    }
}
