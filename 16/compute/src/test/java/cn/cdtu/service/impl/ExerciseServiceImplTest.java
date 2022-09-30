package cn.cdtu.service.impl;

import cn.cdtu.pojo.Equation;
import cn.cdtu.util.EquationType;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

/**
 * @author makun
 * @project 16
 * @description
 * @date 2022/09/28 17:23:56
 * version 1.0
 */
public class ExerciseServiceImplTest extends TestCase {
    ExerciseServiceImpl service = new ExerciseServiceImpl();

    // 是否凑数字的方法
    public void testGenerateOperandsAdd() {
        ArrayList<Long> operands = service.generateOperandsAdd(20, 3, 10, 5);
        System.out.println(operands);
        long total = 0;
        for (Long operand : operands) {
            total += operand;
        }
        Assert.assertEquals(total,20);
    }

    // 是否完成产生加法的方法----需求16
    public void testGenerateAdd() {
        for (int i = 1; i <= 50; i++) {
            Equation equation = service.generateAdd(0, 100, 4);
            Object[] objects = equation.operands.toArray();
            String num1 = objects[0].toString();
            String num2 = objects[1].toString();
//            格式化输出
//            if (i % 5 ==0){
//                System.out.print("\t" + num1 + "+" + num2 + "=" + equation.getValue()+"\n");
//            }else {
//                System.out.print("\t" + num1 + "+" + num2 + "=" + equation.getValue()+"\t");
//            }

            System.out.print(equation);
            System.out.println(equation.getValue());
        }

    }

    //  是否完成产生减法的方法----需求16
    public void testGenerateSub(){
        for (int i = 1; i <= 10; i++) {
            Equation equation = service.generateSub(-100, 100, 2);
            Object[] objects = equation.operands.toArray();
            String num1 = objects[0].toString();
            String num2 = objects[1].toString();

            //格式化输出
            if (i % 5 ==0){
                System.out.print("\t" + num1 + "-" + num2 + "=" + equation.getValue()+"\n");
            }else {
                System.out.print("\t" + num1 + "-" + num2 + "=" + equation.getValue()+"\t");
            }

//            System.out.print(equation);
//            System.out.println(equation.getValue());
        }
    }

    //  是否完成产生加法和减法的混合试题----需求16
    public void testGenerateAddSub(){
        for (int i = 1; i <= 50; i++) {
            Equation equation;
            //前一半试题为加法，后一半试题为减法
            if(i < (50/2)){

                equation = service.generateAdd(-100, 100, 2);
                Object[] objects = equation.operands.toArray();
                String num1 = objects[0].toString();
                String num2 = objects[1].toString();
                //格式化输出
                if (i%5==0){
                    System.out.print("\t" + num1 + "+" + num2 + "=" + equation.getValue()+"\n");
                }else{
                    System.out.print("\t" + num1 + "+" + num2 + "=" + equation.getValue()+"\t");
                }

            }else {
                equation = service.generateSub(-100, 100, 2);
                Object[] objects = equation.operands.toArray();
                String num1 = objects[0].toString();
                String num2 = objects[1].toString();
                ////格式化输出
                if (i % 5 ==0){
                    System.out.print("\t" + num1 + "-" + num2 + "=" + equation.getValue()+"\n");
                }else{
                    System.out.print("\t" + num1 + "-" + num2 + "=" + equation.getValue()+"\t");
                }
            }

//            System.out.print(equation);
//            System.out.println(equation.getValue());

        }
    }
}