package pers.mac.main;

import java.util.Random;
import java.util.UUID;

/**
 * @author JustEP
 * @version 1.0
 * @classname MacEdit
 * @description 生成MAC地址与计算机名
 * @createtime 2019/05/16 22:33:00
 */
public class MacEdit {
    /**
     * @description 经验证的随机生成的可用MAC地址
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:06
     */
    public String randomMacUsable() {
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
    /**
     * @description 根据输入的类型编号生成对应的计算机名
     * @param nameType 计算机名类型
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:07
     */
    public String getRandomPCName(int nameType){
        String result = "";
        switch (nameType){
            case 1 :
                //DESKTOP-随机字母与数字
                String random = getUUIDRandom(7);
                result = "DESKTOP-"+random;
                break;
            case 2:
                //PC随机数字
                String num = getRandom(7);
                result = "PC"+num;
                break;
            case 3:
                //lenovo_随机数字与字母

                break;
            case 4:
                break;
        }
        String random = UUID.randomUUID().toString();
        random = random.replace("-", "");
        random = random.toUpperCase();
        random = random.substring(0,7);
        return "PC"+random;
    }
    /**
     * @description 基于随机数生成若干随机数字
     * @param bound 生成位数
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:22
     */
    public String getRandom(int bound){
        Random rm = new Random();
        String num = "";
        for (int i = 0; i < bound; i++) {
            num += rm.nextInt(10)+"";
        }
        return num;
    }
    /**
     * @description 基于UUID生成若干随机数字字母
     * @param bound 生成位数
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:43
     */
    public String getUUIDRandom(int bound){
        String random = UUID.randomUUID().toString();
        random = random.replace("-", "");
        random = random.toUpperCase();
        random = random.substring(0,bound);
        return random;
    }
}
