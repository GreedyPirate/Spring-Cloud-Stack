package com.ttyc.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    @Test
    public void testRead() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(new File("/Users/admin/IdeaProjects/Spring-Cloud-Stack/java8/src/main/resources/temp/app.txt"));
        ByteBuffer buffer = ByteBuffer.allocate(32);
        FileChannel channel = inputStream.getChannel();

    }
}
