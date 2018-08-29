package com.ttyc.lombok;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.IOException;

public class CloseStream {
    public static void main(String[] args) throws IOException {
        @Cleanup FileInputStream inputStream = new FileInputStream("java8/src/main/resources/temp/app.txt");
        int i;
        while ((i = inputStream.read()) != -1){
            System.out.println((char) i);
        }
    }
}
