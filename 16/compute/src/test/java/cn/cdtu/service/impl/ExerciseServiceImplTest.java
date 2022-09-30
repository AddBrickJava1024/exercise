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

    // 是否完成产生加法的方法
    public void testGenerateAdd() {
        for (int i = 0; i < 10; i++) {
            Equation equation = service.generateAdd(-40, -2, 3);
            System.out.print(equation);
            System.out.println(equation.getValue());
        }

    }
}