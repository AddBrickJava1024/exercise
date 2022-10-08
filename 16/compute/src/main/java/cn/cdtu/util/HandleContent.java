package cn.cdtu.util;

import org.apache.commons.lang3.StringUtils;


public class HandleContent {
    //处理用户输入的内容，截取关键值
    //用户输入格式：50道一行5列的[100,200]加法试题
    // scope[0] = amount;打印的试题总数
    // scope[1] = column;打印的一行列数
    // scope[2] = min;范围最小值
    // scope[3] = max;范围最大值
    // scope[4] = exerciseType;算式类型
    public String[] TestQuestionsScope(String str){

        String[] scope =new String[5];

        if (str.equals("加法")){
            scope[0] = "50";
            scope[1] = "5";
            scope[2] = "0";
            scope[3] = "100";
            scope[4] = "ExerciseType.ADD";
        }else if(str.equals("减法")){
            scope[0] = "50";
            scope[1] = "5";
            scope[2] = "0";
            scope[3] = "100";
            scope[4] = "ExerciseType.SUB";
        }else if(str.equals("加减法")){
            scope[0] = "50";
            scope[1] = "5";
            scope[2] = "0";
            scope[3] = "100";
            scope[4] = "ExerciseType.ADD_OR_SUB";
        }else {
            StringUtils stringUtil = new StringUtils();
            String amount = stringUtil.substringBefore(str, "道");
            String column = stringUtil.substringBetween(str, "行", "列");
            String min = stringUtil.substringBetween(str, "[", ",");
            String max = stringUtil.substringBetween(str, ",", "]");
            String exerciseType = stringUtil.substringBetween(str, "]", "试");

            scope[0] = amount;
            scope[1] = column;
            scope[2] = min;
            scope[3] = max;
            if(exerciseType.equals("加法")){
                scope[4] = "ExerciseType.ADD";
            }else if (exerciseType.equals("减法")){
                scope[4] = "ExerciseType.SUB";
            }else {
                scope[4] = "ExerciseType.ADD_OR_SUB";
            }

        }

        return scope;
    }
}
