package com.mivanzhang.leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by zhangmeng on 17/3/20.
 */
public class ReverseInteger {
    public int reverse2(int x) {
        long result = 0;
        while (x / 10 != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = result * 10 + x % 10;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result % 10 != x % 10)
                return 0;
            x = x / 10;
        }
        return result;
    }

    public void zipIt(String zipFile) {

        byte[] buffer = new byte[1024];
        String SOURCE_FOLDER = "/Users/zhangmeng/Desktop/temparoy/com/meituan/sample";
        try {

            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);

            System.out.println("Output to Zip : " + zipFile);

            for (File file : new File(SOURCE_FOLDER).listFiles()) {

                System.out.println("File Added : " + file.getAbsolutePath());
                ZipEntry ze = new ZipEntry(file.getAbsolutePath());
                zos.putNextEntry(ze);

                FileInputStream in =
                        new FileInputStream(file.getAbsolutePath());

                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }

                in.close();
            }

            zos.closeEntry();
            //remember close it
            zos.close();

            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
//        System.out.println("  reverse result is " + reverseInteger.reverse(123445));
//        System.out.println("  reverse result is " + reverseInteger.reverse(865431210));
//        System.out.println("  reverse result is " + reverseInteger.reverse(1131456789));
//        System.out.println("  reverse result is " + reverseInteger.reverse(128606719));
//        System.out.println("  reverse result is " + reverseInteger.reverse(1286606719));
//        System.out.println("  reverse result is " + reverseInteger.reverse(1));
//        System.out.println("  reverse result is " + reverseInteger.reverse(22));
//        System.out.println("  reverse result is " + reverseInteger.reverse(-2147483648));
//        System.out.println("  reverse result is " + reverseInteger.reverse(Integer.MAX_VALUE));


        reverseInteger.zipIt("/Users/zhangmeng/Desktop/temparoy/test.zip");
    }
}
