package top.marken.school.computeexercise;

import top.marken.school.computeexercise.pojo.Topic;
import top.marken.school.computeexercise.util.Utils;

import java.util.HashSet;

/**
 * @author makun
 * @project test01
 * @description 生成50道100以内加减法，此实现有较大的性能损耗，而且逻辑小乱
 * @date 2022/09/19 20:39:42
 * version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 打印提示头部
        Utils.printHead("50道100以内的加减法");
        // 生成50道100以内加减法
        HashSet<Topic> topics = Utils.generateTopicsRandomPlus(50);
        // 打印算术题
        Utils.printTopicsNoAnswer(topics);
    }
}
