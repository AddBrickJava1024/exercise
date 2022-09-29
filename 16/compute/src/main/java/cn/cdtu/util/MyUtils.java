package cn.cdtu.util;

import java.math.BigDecimal;

/**
 * @author makun
 * @project 16
 * @description 自定义工具
 * @date 2022/09/28 16:25:57
 * version 1.0
 */
public class MyUtils {
    private MyUtils() {}

    /**
     * 产生符合要求的随机数
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static long random(long min, long max) {
        if (min > max) {
            return Long.MIN_VALUE;
        }
        if (min >= 0) {
            return Math.round(Math.random()*(max-min) + min);
        } else if (max <= 0) {
            return -random(-max,-min);
        } else {
            if (random(0,1) == 0) {
                return -random(0,-min);
            } else {
                return random(0,max);
            }
        }
    }
}
