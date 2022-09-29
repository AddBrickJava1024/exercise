package cn.cdtu.service.impl;

import cn.cdtu.pojo.Equation;
import cn.cdtu.pojo.Exercise;
import cn.cdtu.service.ExerciseService;
import cn.cdtu.util.EquationType;
import cn.cdtu.util.ExerciseType;
import cn.cdtu.util.MyUtils;
import cn.cdtu.util.OperatorType;
import javafx.beans.binding.LongExpression;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

 /**
 * @author makun
 * @project 16
 * @description 组成试卷的服务的实现类
 * @date 2022/09/28 15:05:24
 * version 1.0
 */
public class ExerciseServiceImpl implements ExerciseService {
     @Override
     public Equation generateEquation(EquationType type, long minOperand, long maxOperand, int amount) {
         return null;
     }

     @Override
     public HashSet<Equation> generateEquations(ExerciseType exerciseType, EquationType equationType, long min, long max, int amount) {
         return null;
     }

     /**
      * 生成加减混合的算式
      * @param min 操作数以及结果最小值
      * @param max 操作数以及结果最大值
      * @param amount 操作数多少
      * @return 题目
      */
    public Equation generateAddSub(long min, long max, int amount) {
        return null;
    }

     /**
      * 生成全减的算式
      * @param min 操作数以及结果最小值
      * @param max 操作数以及结果最大值
      * @param amount 操作数多少
      * @return 题目
      */
     public Equation generateSub(long min, long max, int amount) {
         ArrayList<Long> operands = new ArrayList<>(amount);
         long temp;

         if (min >= 0) {
             temp = MyUtils.random(min*amount,max);
             operands.add(temp);
             for (int i = 1; i < amount; i++) {
                 operands.add(MyUtils.random(min,temp-min*(amount-i-1)));
                 temp -= operands.get(i);
             }
         } else if (max <= 0) {
             temp = MyUtils.random(min,max);
             ArrayList<Long> opTemp = generateOperandsAdd(-temp, -max, -min, amount);
             for (int i = 0; i < amount; i++) {
                 opTemp.set(i,-opTemp.get(i));
             }
             operands.addAll(opTemp);
         } else {
             long more = -min;
             long maxChange = max + more;
             temp = MyUtils.random(more*(amount-1),more*amount+max);

             operands = generateOperandsAdd(temp, 0, maxChange, amount);

             for (int i = 0; i < amount; i++) {
                 operands.set(i,operands.get(i)-more);
             }
         }

         ArrayList<OperatorType> operatorTypes = new ArrayList<>(amount-1);
         for (int i = 0; i < amount-1; i++) {
             operatorTypes.add(OperatorType.SUB);
         }

         return new Equation(operands,operatorTypes,EquationType.SUB);
     }

    /**
     * 生成全加的算式
     * @param min 操作数以及结果最小值
     * @param max 操作数以及结果最大值
     * @param amount 操作数多少
     * @return 题目
     */
    public Equation generateAdd(long min, long max, int amount) {
        ArrayList<Long> operands = new ArrayList<>(amount);
        long temp;

        if (min >= 0) {
            temp = MyUtils.random(min*amount,max);
            for (int i = 0; i < amount; i++) {
                operands.add(MyUtils.random(min,temp-min*(amount-i-1)));
                temp -= operands.get(i);
            }
        } else if (max <= 0) {
            temp = MyUtils.random(min,max*amount);
            ArrayList<Long> opTemp = generateOperandsAdd(-temp, -max, -min, amount);
            for (int i = 0; i < amount; i++) {
                opTemp.set(i,-opTemp.get(i));
            }
            operands.addAll(opTemp);
        } else {
            long more = -min;
            long maxChange = max + more;
            temp = MyUtils.random(more*(amount-1),more*amount+max);

            operands = generateOperandsAdd(temp, 0, maxChange, amount);

            for (int i = 0; i < amount; i++) {
                operands.set(i,operands.get(i)-more);
            }
        }

        ArrayList<OperatorType> operatorTypes = new ArrayList<>(amount-1);
        for (int i = 0; i < amount-1; i++) {
            operatorTypes.add(OperatorType.ADD);
        }

        return new Equation(operands,operatorTypes,EquationType.ADD);
    }

     /**
      * 根据数值，产生范围内的操作数，全非负整数操作
      * @param value 总值
      * @param min 操作数最小值
      * @param max 操作数最大值
      * @param amount 操作数个数
      * @return
      */
    public ArrayList<Long> generateOperandsAdd(long value, long min,long max,int amount) {
        if (value > max*amount || value < min*amount || amount == 0) return null;
        long more = max * amount - value;

        ArrayList<Long> operands = null;
        int flag = 0;

        while (flag == 0) {
            operands = new ArrayList<>(amount);
            for (int i = 0; i < amount; i++) {
                operands.add(max);
            }

            while (more > 0) {
                int index = (int) MyUtils.random(0,amount-1);
                operands.set(index,operands.get(index)-1);
                more--;
            }

            for (int i = 0; i < amount; i++) {
                long operand = operands.get(i);
                if (!(operand < min || operand > max)) {
                    flag = 1;
                    break;
                }
            }
        }

        return  operands;
    }
}
