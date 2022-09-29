package cn.cdtu.pojo;

import cn.cdtu.util.EquationType;
import cn.cdtu.util.OperatorType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author makun
 * @project 16
 * @description 测试
 * @date 2022/09/28 15:58:02
 * version 1.0
 */
public class EquationTest {
    // 测试试题是否能够自己计算答案
    @Test
    public void test01() {
        ArrayList<Long> operands = new ArrayList<>();
        ArrayList<OperatorType> operators = new ArrayList<>();
        // 操作数1
        operands.add(10L);
        // 操作数2
        operands.add(100L);
        // 操作数3
        operands.add(80L);
        // 运算符1
        operators.add(OperatorType.ADD);
        // 运算符2
        operators.add(OperatorType.ADD);
        Equation equation = new Equation(operands,operators, EquationType.ADD);

        Assert.assertEquals(equation.getValue(),new Long(190));
    }
}
