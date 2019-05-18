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
    public static void execute(){
        String mac = GenerateMac.randomMacUsable();
        String pcName = GeneratePCName.getRandomPCName(1);

    }
}
