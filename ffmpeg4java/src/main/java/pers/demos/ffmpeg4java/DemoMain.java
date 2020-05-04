package pers.demos.ffmpeg4java;

import java.io.*;
import java.util.Arrays;

/**
 * @author JustEP
 * @version 1.0
 * @classname DemoMain
 * @description ffmpeg
 * @createtime 2020/01/28 16:36:00
 */
public class DemoMain {
    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(args));
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("ffmpeg -version");
            InputStream inputStream = exec.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
