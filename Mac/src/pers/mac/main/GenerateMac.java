package pers.mac.main;

import java.util.Random;

/**
 * @author JustEP
 * @version 1.0
 * @classname GenerateMac
 * @description TODO
 * @createtime 2019/05/18 21:56:00
 */
public class GenerateMac {
    /**
     * @description 经验证的随机生成的可用MAC地址
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:06
     */
    public static String randomMacUsable() {
        Random random = new Random();
        int[] prefix = {0x02,0x06,0x0a,0x0e};
        int index = random.nextInt(4);
        String[] mac = {
                String.format("%02x", prefix[index]),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join("", mac);
    }
}
