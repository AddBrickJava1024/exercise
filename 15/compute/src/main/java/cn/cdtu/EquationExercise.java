package cn.cdtu;

import java.util.Random;

/**
 * @author hongtea-chr
 *
 *10.完成代码2.2的编写，并输出一套50到100以内的加减法口算习题。
 */
public class EquationExercise {
    public static void main(String[] args) {
        printHeader();
        generateEquations();
//        printExercise();
//        printCalculations();
    }

    public static void printHeader(){
        System.out.println("--------------------------------------------");
        System.out.println("- 程序输出50道100以内的加减法算式的习题 -");
        System.out.println("- 每次运行程序可得到一套50道题的习题和答案 -");
        System.out.println("--------------------------------------------");
    }

    public static void generateEquations(){
        int op,a,b,sum;
        int count = 1;
        int[] sumList = new int[50];
        while(count < 51){
            Random random = new Random();
            op = random.nextInt(2);//产生一个随机的操作符 0代表 ：“-” ； 1代表 ：”+“;
            a = random.nextInt(101);//随机产生两个0~100的数
            b = random.nextInt(101);
            if(op == 1){
                sum = a + b;
                if(sum <= 100){
                    System.out.println(count+":"+ "         " + a + "+" + b + "=");
                    sumList[count-1] = sum;
                    count++;

                }
            }else{
                sum = a - b;
                if(sum >= 0){
                    System.out.println(count+":"+ "         " + a + "-" + b + "=");
                    sumList[count-1] = sum;
                    count++;
                }
            }
        }
        printExercise();
        printCalculations(sumList);
    }

    public static void printExercise(){
        System.out.println("--------------------------------------------");
        System.out.println("- 下面是习题的参考答案 -");
        System.out.println("--------------------------------------------");

    }

    public static void printCalculations(int[] list){
        for (int i = 1; i < 51; i++) {
            System.out.println(i + ":" + "          " + list[i-1]);
        }
    }
}
