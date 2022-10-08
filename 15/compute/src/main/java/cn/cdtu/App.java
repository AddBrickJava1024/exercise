package cn.cdtu;

import java.util.Objects;

/**
 * 每个算式需要答案
 * 加法算式的和不超过100
 * 减法算式的差不能小于0
 * 每行整齐地多显示几个题
 * 加法减法加减法各两套题
 */
public class App {



    public static void main(String[] args) {
        // 加法题x2
        ExerciseUtil.Exercise exercise1 = ExerciseUtil.generateExercise(100,ExerciseUtil.TYPE.SUM);
        ExerciseUtil.Exercise exercise2 = ExerciseUtil.generateExercise(100,ExerciseUtil.TYPE.SUM);
        // 减法题x2
        ExerciseUtil.Exercise exercise3 = ExerciseUtil.generateExercise(100,ExerciseUtil.TYPE.SUB);
        ExerciseUtil.Exercise exercise4 = ExerciseUtil.generateExercise(100,ExerciseUtil.TYPE.SUB);
        // 组合题x2
        ExerciseUtil.Exercise exercise5 = ExerciseUtil.generateExercise(100,ExerciseUtil.TYPE.ALL);
        ExerciseUtil.Exercise exercise6 = ExerciseUtil.generateExercise(100,ExerciseUtil.TYPE.ALL);
        // 生成试题
        String paper1 = ExerciseUtil.generatePaper(exercise1,5,true);
        String paper2 = ExerciseUtil.generatePaper(exercise2,5,true);
        String paper3 = ExerciseUtil.generatePaper(exercise3,5,true);
        String paper4 = ExerciseUtil.generatePaper(exercise4,5,true);
        String paper5 = ExerciseUtil.generatePaper(exercise5,5,true);
        String paper6 = ExerciseUtil.generatePaper(exercise6,5,true);

        // 打印试卷
        System.out.println(paper1);
        System.out.println("*******************************************************************************");
        System.out.println(paper2);
        System.out.println("*******************************************************************************");
        System.out.println(paper3);
        System.out.println("*******************************************************************************");
        System.out.println(paper4);
        System.out.println("*******************************************************************************");
        System.out.println(paper5);
        System.out.println("*******************************************************************************");
        System.out.println(paper6);
    }

}
