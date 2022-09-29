package cn.cdtu.pojo;

import cn.cdtu.util.EquationType;
import cn.cdtu.util.OperatorType;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author makun
 * @project 16
 * @description 试题实体类
 * @date 2022/09/28 15:10:52
 * version 1.0
 */
public class Equation {
    // 试题包含的操作数
    private ArrayList<Long> operands;
    // 试题包含的操作符
    private ArrayList<OperatorType> operators;
    // 试题的类型
    private EquationType type;

    public Equation(ArrayList<Long> operands, ArrayList<OperatorType> operators, EquationType type) {
        this.operands = operands;
        this.operators = operators;
        this.type = type;
    }

    /**
     * 获取此试题的计算结果
     * @return 计算结果
     */
    public Long getValue() {
        if (operands == null || operands.size() == 0) {
            return null;
        }
        Long value = operands.get(0);

        for (int i = 1; i < operands.size(); i++) {
            switch (operators.get(i-1)) {
                case ADD:
                    value = value + operands.get(i);
                    break;
                case SUB:
                    value = value - operands.get(i);
            }
        }

        return value;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "operands=" + operands +
                ", operators=" + operators +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation = (Equation) o;
        return operands.equals(equation.operands) && operators.equals(equation.operators) && type == equation.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands, operators, type);
    }

    public Equation() {
    }

    public ArrayList<Long> getOperands() {
        return operands;
    }

    public void setOperands(ArrayList<Long> operands) {
        this.operands = operands;
    }

    public ArrayList<OperatorType> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<OperatorType> operators) {
        this.operators = operators;
    }

    public EquationType getType() {
        return type;
    }

    public void setType(EquationType type) {
        this.type = type;
    }
}
