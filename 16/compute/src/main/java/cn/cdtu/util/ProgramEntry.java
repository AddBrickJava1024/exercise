package cn.cdtu.util;

import cn.cdtu.pojo.Exercise;
import cn.cdtu.proxy.ExerciseProxy;
import junit.framework.Assert;


import java.util.Scanner;

public class ProgramEntry {

    //直接输入语法获取试题
    public void grammarMode(){

        System.out.println("******************** 请输入您需要的试题 ********************");
        System.out.println("************************ 使用说明 ************************");
        System.out.println("********** 基础语法格式：直接输入加法 或 减法 或 加减法 **********");
        System.out.println("********** 通用语法格式：50道一行5列的[1,200]加法试题  **********");
        System.out.println("******* 其中通用语法格式中数字50、5和[]中的数字可以任意变更  *******");
        System.out.println("******************* 输入：退出 即可退出此方法 ******************");

        HandleContent handleContent = new HandleContent();
        Scanner input = new Scanner(System.in);
        //接收控制台输入的文字
        String str = input.next();
        if (!str.equals("退出")) {
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
        }
    }

    //分部输入参数获取试题
    public void branchMode(){
        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD_OR_SUB);
        Exercise exercise;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int column = 2;
        int choose = 0;
        while (flag) {
            System.out.print("当前试题生成器状态：每行算式数量：" + column + " ");
            System.out.println(proxy);
            System.out.println("*****************************请输入对应数字选择服务***********************");
            System.out.println("************** 1.修改最小值     ***************** 2.修改最大值   ********");
            System.out.println("************** 3.修改操作数数量  ***************** 4.修改试题类型 ********");
            System.out.println("************** 5.修改列数       ****************** 6.生成试题    ********");
            System.out.println("***************************** 0.退出此方法 *****************************");
            System.out.print("请输入服务对应数字：");
            choose = sc.nextInt();

            switch (choose) {
                case 0:
                    System.out.println("再见~");
                    flag = false;
                    break;
                case 1:
                {
                    System.out.print("请输入需要修改的最小值：");
                    long min = sc.nextLong();
                    proxy.setMin(min);
                    break;
                }
                case 2:
                {
                    System.out.print("请输入需要修改的最大值：");
                    long max = sc.nextLong();
                    proxy.setMax(max);
                    break;
                }
                case 3:
                {
                    System.out.print("请输入需要修改的操作数数量：");
                    int amount = sc.nextInt();
                    proxy.setOperandAmount(amount);
                    break;
                }
                case 4:
                {
                    boolean flagS = true;
                    int chooseS = 0;
                    do {
                        System.out.println("******** 1.全加 2.全减 3.加或减 0.退出修改********");
                        System.out.print("请输入试题类型对应的数字：");
                        chooseS = sc.nextInt();
                        switch (chooseS) {
                            case 0:
                                flagS = false;
                            case 1:
                                proxy.setType(ExerciseType.ADD);
                                flagS = false;
                                break;
                            case 2:
                                proxy.setType(ExerciseType.SUB);
                                flagS = false;
                                break;
                            case 3:
                                proxy.setType(ExerciseType.ADD_OR_SUB);
                                flagS = false;
                                break;
                            default:
                                System.out.println("没有这个选项，请重新输入");
                                break;
                        }
                    } while (flagS);
                    break;
                }
                case 5:
                {
                    System.out.print("请输入试题每行的算式数量：");
                    column = sc.nextInt();
                    break;
                }
                case 6:
                {
                    int amount;
                    String path, fileName;

                    System.out.print("请输入试题算式的个数：");
                    amount = sc.nextInt();
                    exercise = proxy.generateExercise(amount);

                    System.out.print("请选择试题输出的位置：");
                    sc.nextLine();
                    path = sc.nextLine();
                    System.out.print("请确定试题的文件名：");
                    fileName = sc.nextLine();
                    if (MyUtils.printToFile(proxy.generatePaper(exercise,column,false),path,fileName,false) && MyUtils.printToFile(proxy.generatePaper(exercise,column,true),path,fileName+"-answer",false)) {
                        System.out.println("试题生成成功！");
                    } else {
                        System.out.println("试题生成失败！");
                    }
                    break;
                }
                default:
                    System.out.println("没有此服务哦~");
                    break;
            }
        }
    }
}
