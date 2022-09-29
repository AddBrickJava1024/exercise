package cn.cdtu.service.impl;

import cn.cdtu.pojo.Equation;
import cn.cdtu.pojo.Exercise;
import cn.cdtu.util.EquationType;
import cn.cdtu.util.ExerciseType;
import junit.framework.TestCase;
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

    // 是否完成凑数字的方法
    public void testGenerateOperandsAdd() {
       for (int i = 0; i < 50; i++) {
           ArrayList<Long> operands = service.generateOperandsAdd(20, 3, 10, 5);
           System.out.println(operands);
       }
    }

    // 是否完成产生加法的方法
    public void testGenerateAdd() {
        for (int i = 0; i < 10; i++) {
            Equation equation = service.generateAdd(-100, -10, 3);
            System.out.print(equation);
            System.out.println(equation.getValue());
        }

    }

    public void testGenerateSub() {
        for (int i = 0; i < 100; i++) {
            Equation equation = service.generateSub(-100, 100, 3);
            System.out.print(equation);
            System.out.println(equation.getValue());
        }
    }

    public void testGenerateEquation() {
        Equation equation = null;
        for (int i = 0; i < 100; i++) {
            equation = service.generateEquation(EquationType.SUB, -100, 100, 3);
            System.out.print(equation);
            System.out.println(equation.getValue());
        }
    }

    public void testGenerateExercise() {
        Exercise exercise = service.generateExercise(ExerciseType.ADD_OR_SUB, -100, 100, 3, 10);
        for (Equation equation : exercise.getEquations()) {
            System.out.print(equation);
            System.out.println(equation.getValue());
        }
    }
}