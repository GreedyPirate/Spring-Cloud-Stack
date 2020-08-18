package com.ttyc.nio.book;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.Date;

public class ByteBufferDemo {

    @Test
    public void testApi() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.putInt(1);
        buffer.putInt(2);

        int offset = buffer.arrayOffset();
        System.out.println("offset = " + offset);

        // 将ByteBuffer里的数据批量读取到字节数组里
        buffer.flip();

        while (buffer.hasRemaining()) {
            byte[] dst = new byte[4];
            buffer.get(dst); // get方法内部会移动position指针

            int number = byteArrayToInt(dst);
            System.out.println("number = " + number);
        }
    }

    @Test
    public void testView() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.putInt(1);
        buffer.putInt(2);

        /**
         * 相比于上面的byte转int，先转成IntBuffer更方便
         */
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println("i = " + i);
        }
    }

    @Test
    public void testIntBuffer() {
        // 16/4 = 4，表示IntBuffer的容量
        ByteBuffer buffer = ByteBuffer.allocate(16);
        IntBuffer intBuffer = buffer.asIntBuffer();

        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);
        intBuffer.put(4);

        printBuffer(intBuffer);
    }

    @Test
    public void testCreateTime() {
        long start = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(1000000);
        for (int i = 0; i < 100000; i++) {
            buffer.putInt(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println("buffer = " + (end - start));

        start = System.currentTimeMillis();
        ByteBuffer direct = ByteBuffer.allocateDirect(1000000);
        for (int i = 0; i < 100000; i++) {
            direct.putInt(i);
        }
        end = System.currentTimeMillis();
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println("direct = " + (end - start));
    }

    @Test
    public void testDirectBuffer() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        buffer.putInt(1);
        buffer.putInt(2);

        forceClose(buffer);
    }

    @Test
    public void testWrap() {
        byte[] array = {1,2,3,4,5,6,7,127};
        ByteBuffer buffer = ByteBuffer.wrap(array, 2, array.length-3);
        printBuffer(buffer);
    }

    @Test
    public void testAbsolutePosition() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.putInt(3, 1); // position不变
        printBuffer(buffer);

        int anInt = buffer.getInt(3);
        System.out.println("anInt = " + anInt);
    }

    @Test
    public void testAddAll() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.putInt(1);
        buffer.putInt(2);

        ByteBuffer newBuffer = ByteBuffer.allocate(10);
        newBuffer.put(buffer);
        printBuffer(newBuffer);

        ByteOrder order = buffer.order();
        System.out.println("order = " + order.toString());
    }

    @Test
    public void testSlice() {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        buffer.putInt(1);
        buffer.putInt(2);

        ByteBuffer newBuffer = buffer.slice();
        printBuffer(newBuffer);

    }

    @Test
    public void testOrder() {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(0x0102030405060708L);

        buffer.flip();
        byte b = buffer.get();
        System.out.println(b == 0x01);
        System.out.println(b == 0x08);
    }

    @Deprecated
    @Test
    public void testFileChannel() throws URISyntaxException, IOException {
        ByteBuffer buffer = ByteBuffer.allocate(32);

        FileChannel channel = FileChannel.open(Paths.get(new URI("file:///Users/admin/private/Spring-Cloud-Stack/java8/src/main/resources/temp/app.txt")));


        long currentPosition = buffer.position();
        int bytesRead;
        do {
            bytesRead = channel.read(buffer, currentPosition);
            currentPosition += bytesRead;
        } while (bytesRead != -1 && buffer.hasRemaining());

        int i = 0;
        buffer.flip();
        while ((i = channel.read(buffer)) != -1 && buffer.hasRemaining()) {
            char b = (char) buffer.get();
            if(b == '\n') {
                System.out.println();
            }else {
                System.out.print(b);
            }
        }
        buffer.clear();
    }

    private void forceClose(ByteBuffer buffer) {
        if(buffer instanceof DirectBuffer) {
            DirectBuffer directBuffer = (DirectBuffer) buffer;
            Cleaner cleaner = directBuffer.cleaner();
            cleaner.clean();
        }
    }

    private int byteArrayToInt(byte[] bytes) {
        int value=0;
        for(int i = 0; i < 4; i++) {
            int shift= (3-i) * 8;
            value +=(bytes[i] & 0xFF) << shift;
        }
        return value;
    }

    public void printBuffer(Buffer buffer) {
        System.out.println("position :" + buffer.position() + ",limit :" + buffer.limit() + ",capacity" + buffer.capacity());
    }
}
