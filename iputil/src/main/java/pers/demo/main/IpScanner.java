package pers.demo.main;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author JustEP
 * @version 1.0
 * @classname ScannerIP
 * @description TODO
 * @createtime 2019/10/11 21:56:00
 */
public class IpScanner {
    private static void scan(){
        try {
            String prefix = "192.168.2.";
            int end = 256;
            //注意不能太小,至少是1s
            int timeOut = 1000;
            for (int i = 100; i < end; i++) {
                String ip = prefix+i;
                boolean status = InetAddress.getByName(ip).isReachable(timeOut);
                String hostName = InetAddress.getByName(ip).getHostName();
                System.out.println(ip);
                if (status) {
                    System.out.println("success:"+ip);
                    System.out.println("hostName:"+hostName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        scan();
    }
}
