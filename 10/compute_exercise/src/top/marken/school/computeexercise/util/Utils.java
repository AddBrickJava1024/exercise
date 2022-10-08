package top.marken.school.computeexercise.util;

import top.marken.school.computeexercise.pojo.Topic;

import java.util.HashSet;

/**
 * @author makun
 * @project test01
 * @description 工具类
 * @date 2022/09/19 20:45:17
 * version 1.0
 */
public class Utils {

    private Utils() {
        super();
    }

    /**
     * 打印头部
     * @param tips 提示语
     */
    public static void printHead(String tips) {

        System.out.println("---------------------------------------------");
        System.out.println(tips);
        System.out.println("---------------------------------------------");
    }

    /**
     * 不带答案打印
     * @param topics 题目
     */
    public static void printTopicsNoAnswer(HashSet<Topic> topics) {
        if (topics == null || topics.size() == 0) {
            System.out.println("什么也没有！");
            return;
        }

        StringBuilder sb;
        int cnt = 1;
        for (Topic topic : topics) {
            System.out.print(String.format("%02d",cnt));
            sb = new StringBuilder();
            sb.append("、");
            sb.append("\t");
            sb.append(topic.getNum1());
            sb.append("\t");
            sb.append(topic.getOperator());
            sb.append("\t");
            sb.append(topic.getNum2());
            sb.append("\t");
            sb.append("=");
            sb.append("\t");
            sb.append("\t");

            if (cnt % 2 == 1) {
                System.out.print(sb);
            } else {
                System.out.println(sb);
            }
            cnt++;
        }
    }

    /**
     * 带答案打印
     * @param topics 题目
     */
    public static void printTopicsAnswer(HashSet<Topic> topics) {
        if (topics == null || topics.size() == 0) {
            System.out.println("什么也没有！");
            return;
        }

        StringBuilder sb;
        int cnt = 1;
        for (Topic topic : topics) {
            System.out.print(String.format("%02d",cnt));
            sb = new StringBuilder();
            sb.append("、");
            sb.append("\t");
            sb.append(topic.getNum1());
            sb.append("\t");
            sb.append(topic.getOperator());
            sb.append("\t");
            sb.append(topic.getNum2());
            sb.append("\t");
            sb.append("=");
            sb.append("\t");
            sb.append(topic.getAnswer());
            sb.append("\t");
            sb.append("\t");

            if (cnt % 2 == 1) {
                System.out.print(sb);
            } else {
                System.out.println(sb);
            }
            cnt++;
        }
    }

    /**
     * 生成指定数量的加减法算术题
     * @param quantity 指定数量
     * @return 所有算术题
     */
    public static HashSet<Topic> generateTopicsRandomPlus(int quantity) {
        HashSet<Topic> topics = new HashSet<>(quantity);

        while (topics.size() != quantity) {
            if (randomArea(0,1) == 1) {
                topics.addAll(generateTopicsSum(1));
            } else {
                topics.addAll(generateTopicsSub(1));
            }
        }

        return topics;
    }

    /**
     * 生成指定数量的加法和指定数量的减法题
     * @param quantitySum 加法题数量
     * @param quantitySub 减法题数量
     * @return
     */
    public static HashSet<Topic> generateTopicsRandom(int quantitySum, int quantitySub) {
        HashSet<Topic> topics = new HashSet<>(quantitySum + quantitySub);
        topics.addAll(generateTopicsSum(quantitySum));
        topics.addAll(generateTopicsSub(quantitySub));

        return topics;
    }

    /**
     * 生成指定数量的加法题
     * @param quantity
     * @return
     */
    public static HashSet<Topic> generateTopicsSum(int quantity) {
        HashSet<Topic> topics = new HashSet<>(quantity);

        int num1,num2;
        while (topics.size() != quantity) {
            num1 = randomArea(1,99);
            num2 = randomNumBSum(num1,100);
            topics.add(new Topic(num1,num2,num1 + num2,'+'));
        }

        return topics;
    }

    /**
     * 生成指定数量的减法题
     * @param quantity
     * @return
     */
    public static HashSet<Topic> generateTopicsSub(int quantity) {
        HashSet<Topic> topics = new HashSet<>(quantity);

        int num1,num2;
        while (topics.size() != quantity) {
            num1 = randomArea(1,99);
            num2 = randomNumBSub(num1,0);
            topics.add(new Topic(num1,num2,num1 - num2,'-'));
        }

        return topics;
    }

    /**
     * 生成指定范围随机数
     * @param start 开始（包含）
     * @param end 结束 （包含）
     * @return
     */
    public static int randomArea(int start, int end) {
        if (end > start) {
            return (int) Math.round(Math.random() * (end - start)) + start;
        } else {
            return -1;
        }
    }

    /**
     * 根据被减数与最小数值得到符合范围的减数
     * @param numA 被减数
     * @param min 最小值
     * @return 随机减数
     */
    public static int randomNumBSub(int numA, int min) {
        return randomArea(1 , numA - min);
    }

    /**
     * 根据被加数与最大数值得到符合范围的加数
     * @param numA 被加数
     * @param max 最大值
     * @return 随机加数
     */
    public static int randomNumBSum(int numA, int max) {
        return randomArea(1, max - numA);
    }
}
