package pers.mac.main;

import java.util.Random;
import java.util.UUID;

/**
 * @author JustEP
 * @version 1.0
 * @classname GeneratePCName
 * @description 生成不同的计算机名
 * @createtime 2019/05/18 21:56:00
 */
public class GeneratePCName {
    /**
     * @description 根据输入的类型编号生成对应的计算机名
     * @param nameType 计算机名类型
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:07
     */
    public static String getRandomPCName(int nameType){
        String result = "";
        int uuidBound = 7;
        int bound = 10;
        switch (nameType){
            case 1 :
                //DESKTOP-随机字母与数字
                result = "DESKTOP-"+getUUIDRandom(uuidBound);
                break;
            case 2:
                //PC随机数字
                result = "PC"+getRandom(bound);
                break;
            case 3:
                //lenovo_随机数字与字母
                result = "lenovo"+getRandom(bound);
                break;
            case 4:
                result = "Apple";
                break;
        }
        return "PC"+result;
    }
    /**
     * @description 基于随机数生成若干随机数字
     * @param bound 生成位数
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:22
     */
    private static String getRandom(int bound){
        Random rm = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bound; i++) {
            sb.append(rm.nextInt(10));
        }
        return sb.toString();
    }
    /**
     * @description 基于UUID生成若干随机数字字母
     * @param bound 生成位数
     * @return java.lang.String
     * @author JustEP
     * @date 2019/5/16 23:43
     */
    private static String getUUIDRandom(int bound){
        String random = UUID.randomUUID().toString();
        random = random.replace("-", "");
        random = random.toUpperCase();
        random = random.substring(0,bound);
        return random;
    }
}
