package com.example.exercise;

/**
 * @author makun
 * @project compute
 * @description 程序入口
 * @date 2022/09/28 00:45:00
 * version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 产生题目
        int[][] exercise = generateExercise(50);
        // 生成试卷字符串
        StringBuilder sb = generateExercise(exercise,true);
        // 打印试卷在控制台
        System.out.println(sb);
    }

    /**
     * 产生试卷字符串
     * @param exercise 试卷数组
     * @param isAnswer 是否打印答案
     * @return 试卷字符串
     */
    public static StringBuilder generateExercise(int[][] exercise,boolean isAnswer) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < exercise.length; i++) {
            sb.append(String.format("%02d",i));
            sb.append("、 ");
            sb.append(String.format("%-3d",exercise[i][0]));
            if (exercise[i][2] == 1) {
                sb.append("+");
            } else {
                sb.append("-");
            }
            sb.append(String.format("%3d",exercise[i][1]));
            sb.append(" = ");
            if (isAnswer) {
                sb.append(String.format("%-3d",calculate(exercise[i])));
            }
            if (i % 2 == 0) {
                sb.append("\t");
            } else {
                sb.append("\n");
            }
        }

        return sb;
    }

    /**
     * 计算算式的结果
     * @param equation 算式
     * @return 结果
     */
    public static int calculate(int[] equation) {
        if (equation[2] == 1) {
            return equation[0] + equation[1];
        } else {
            return equation[0] - equation[1];
        }
    }

    /**
     * 产生指定题目数量的练习题
     * @param amount 数量
     * @return 行代表第几题，列与产生题目的一维数组对应
     */
    public static int[][] generateExercise(int amount) {
        int[][] exercise = new int[amount][3];
        int[] equation;
        int cnt = 0;
        int flag = 0;

        while (cnt < amount) {
            flag = 0;
            if (random(0,1) == 1) {
                equation = generateSum();
            } else {
                equation = generateSub();
            }
            // 加入是否重复验证
            for (int i = 0; i < cnt; i++) {
                if (exercise[i][0] == equation[0] && exercise[i][1] == equation[1] && exercise[i][2] == equation[2]) {
                    // 表示重复了
                    flag = 1;
                    break;
                }
            }
            //如果不重复就加
            if (flag == 0) {
                exercise[cnt][0] = equation[0];
                exercise[cnt][1] = equation[1];
                exercise[cnt][2] = equation[2];
                // 计数器加1
                cnt++;
            }
        }

        return exercise;
    }

    /**
     * 产生一个减法
     * @return 数组表示，[0]左操作数 [1]右操作数 [2]操作符（0减法1加法）
     */
    public static int[] generateSub() {
        int left_op,right_op;
        left_op = random(2,100);
        right_op = random(1,left_op - 1);

        return new int[]{left_op,right_op,0};
    }

    public static int[] generateSum() {
        int left_op,right_op,value;
        value = random(2,100);
        left_op = random(1,value-1);
        right_op = value - left_op;

        return new int[]{left_op,right_op,1};
    }

    /**
     * 随机产生指定范围的随机数
     * @param min 最小
     * @param max 最大
     * @return
     */
    public static int random(int min, int max) {
        return (int) Math.round((max - min) * Math.random()) + min;
    }
}
