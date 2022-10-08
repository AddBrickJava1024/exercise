package cn.cdtu.proxy;

import cn.cdtu.pojo.Equation;
import cn.cdtu.pojo.Exercise;
import cn.cdtu.service.ExerciseService;
import cn.cdtu.service.impl.ExerciseServiceImpl;
import cn.cdtu.util.ExerciseType;
import cn.cdtu.util.OperatorType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author makun
 * @project 16
 * @description 试卷代理
 * @date 2022/09/29 22:14:01
 * version 1.0
 */
public class ExerciseProxy {
    private Long min = 1L;
    private Long max = 100L;
    private Integer operandAmount = 2;
    private ExerciseType type = ExerciseType.ADD;
    private ExerciseService service = new ExerciseServiceImpl();

    public ExerciseProxy() {
    }

    public ExerciseProxy(Long min, Long max, ExerciseType type) {
        this.min = min;
        this.max = max;
        this.type = type;
    }

    /**
     * 生成试卷字符串
     * @param exercise 试卷
     * @param column 每行几个题目
     * @param isAnswer 是否需要答案
     * @return 试卷字符串
     */
    public String generatePaper(Exercise exercise,int column,boolean isAnswer) {
        if (exercise == null || exercise.getEquations() == null) return null;

        HashSet<Equation> equations = exercise.getEquations();
        StringBuilder sb = new StringBuilder();

        Iterator<Equation> iterator = equations.iterator();
        int round = 1,index = 1;
        Equation equation = null;
        ArrayList<Long> operands = null;
        ArrayList<OperatorType> operatorTypes = null;

        while (iterator.hasNext()) {
            equation = iterator.next();
            operands = equation.getOperands();
            operatorTypes = equation.getOperators();

            sb.append(String.format("%4d",index));
            sb.append("、");
            int i = 0;
            for (; i < operands.size()-1; i++) {
                long operand = operands.get(i);
                if (operand < 0 && i != 0) {
                    sb.append(String.format("%6s","(" + operand + ")"));
                } else {
                    sb.append(String.format("%6d",operand));
                }

                switch (operatorTypes.get(i)) {
                    case ADD:
                        sb.append(String.format("%3c",'+'));
                        break;
                    case SUB:
                        sb.append(String.format("%3c",'-'));
                        break;
                }
            }
            long operand = operands.get(i);
            if (operand < 0) {
                sb.append(String.format("%6s","(" + operand + ")"));
            } else {
                sb.append(String.format("%6d",operand));
            }
            sb.append(String.format("%3c",'='));
            if (isAnswer) {
                sb.append(String.format("%6d",equation.getValue()));
            } else {
                sb.append("\t");
            }
            if (round < column) {
                sb.append("\t");
                round++;
            } else {
                sb.append("\n");
                round = 1;
            }
            index++;
        }

        return sb.toString();
    }

    /**
     * 生成试题
     * @param amount 试题数量
     * @return 试题
     */
    public Exercise generateExercise(int amount) {
        return service.generateExercise(type,min,max,operandAmount,amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("最小值：");
        sb.append(min);
        sb.append(" 最大值：");
        sb.append(max);
        sb.append(" 操作数数量：");
        sb.append(operandAmount);

        String tp = "未知";
        switch (type) {
            case ADD:
                tp = "全加";
                break;
            case ADD_OR_SUB:
                tp = "加或减";
                break;
            case SUB:
                tp = "全减";
                break;
        }

        sb.append(" 试题类型：");
        sb.append(tp);

        return sb.toString();
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    public ExerciseService getService() {
        return service;
    }

    public void setService(ExerciseService service) {
        this.service = service;
    }

    public Integer getOperandAmount() {
        return operandAmount;
    }

    public void setOperandAmount(Integer operandAmount) {
        this.operandAmount = operandAmount;
    }
}
