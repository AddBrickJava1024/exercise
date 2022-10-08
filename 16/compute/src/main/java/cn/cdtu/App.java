package cn.cdtu;

import cn.cdtu.proxy.ExerciseProxy;
import cn.cdtu.util.ExerciseType;
import cn.cdtu.util.HandleContent;

import java.lang.String;
import java.util.Scanner;

/**
 * 每个算式需要答案
 * 加法算式的和不超过100
 * 减法算式的差不能小于0
 * 每行整齐地多显示几个题
 * 加法减法加减法各两套题
 */
public class App {
    public static void main(String[] args) {

        //appRun == false时程序结束；反之运行
        Boolean appRun = true;
        while (appRun) {

            System.out.println("请输入您需要的试题：(格式为：加法、减法、加减法或50道一行5列的[1,200]加法试题，\n其中50、5和[]中的数字可以任意变更。\n请务必按照正确格式输入)\n输入”退出“即可退出程序");

            HandleContent handleContent = new HandleContent();
            Scanner input = new Scanner(System.in);
            //接收控制台输入的文字
            String str = input.next();
            if (!str.equals("退出")){
                String[] questionsScope = handleContent.TestQuestionsScope(str);

                //判断使用什么基本运算
                ExerciseType exerciseType = null;
                if (questionsScope[4] == "ExerciseType.ADD") {
                    exerciseType = ExerciseType.ADD;
                } else if (questionsScope[4] == "ExerciseType.SUB") {
                    exerciseType = ExerciseType.SUB;
                } else {
                    exerciseType = ExerciseType.ADD_OR_SUB;
                }

                ExerciseProxy proxy = new ExerciseProxy(Long.valueOf(questionsScope[2]), Long.valueOf(questionsScope[3]), exerciseType);
                String paper = proxy.generatePaper(proxy.generateExercise(Integer.parseInt(questionsScope[0])), Integer.parseInt(questionsScope[1]), true);

                System.out.println(paper);

            }else {
                appRun=false;
            }
        }

    }
}
