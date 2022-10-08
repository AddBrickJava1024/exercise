package cn.cdtu;

import cn.cdtu.pojo.Exercise;
import cn.cdtu.proxy.ExerciseProxy;
import cn.cdtu.util.ExerciseType;
import cn.cdtu.util.MyUtils;
import java.util.Scanner;

/**
 * @author makun
 * @project 16
 * @description 备用启动类
 * @date 2022/10/08 22:14:38
 * version 1.0
 */
public class App2 {
    public static void main(String[] args) {
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
            System.out.println("****************************** 0.退出系统 ******************************");
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
