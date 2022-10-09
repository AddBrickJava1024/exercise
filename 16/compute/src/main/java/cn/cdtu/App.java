package cn.cdtu;

import cn.cdtu.util.ProgramEntry;

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

        final ProgramEntry programEntry = new ProgramEntry();

        //appRun == false时程序结束；反之运行
        Boolean appRun = true;
        while (appRun) {
            System.out.println("******************** 请选择您所常用的试题生成方式 ********************");
            System.out.println("********** 1.分部输入参数获取试题 ***** 2.直接语法输入获取试题 **********");
            System.out.println("*************************** 0.退出系统  ***************************");

            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            switch (str) {
                case "1":
                    programEntry.branchMode();
                    break;
                case "2":
                    programEntry.grammarMode();
                    break;
                case "0":
                    appRun = false;
                    break;
                default:
                    System.out.println("请输入正确字符串！");
                    break;
            }
        }


    }
}
