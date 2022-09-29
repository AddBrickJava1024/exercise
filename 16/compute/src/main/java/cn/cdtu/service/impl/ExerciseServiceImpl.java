package cn.cdtu.service.impl;

import cn.cdtu.pojo.Equation;
import cn.cdtu.pojo.Exercise;
import cn.cdtu.service.ExerciseService;
import cn.cdtu.util.EquationType;
import cn.cdtu.util.ExerciseType;
import cn.cdtu.util.MyUtils;
import cn.cdtu.util.OperatorType;
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
         switch (type) {
             case ADD:
                 return generateAdd(minOperand,maxOperand,amount);
             case SUB:
                 return generateSub(minOperand,maxOperand,amount);
         }

         return null;
     }

     @Override
     public Exercise generateExercise(ExerciseType exerciseType, long min, long max, int operandAmount, int amount) {
         HashSet<Equation> equations = new HashSet<>(amount);

         while (equations.size() < amount) {
             switch (exerciseType) {
                 case ADD:
                     equations.add(generateEquation(EquationType.ADD,min,max,operandAmount));
                     break;
                 case SUB:
                     equations.add(generateEquation(EquationType.SUB,min,max,operandAmount));
                     break;
                 case ADD_OR_SUB:
                     if (MyUtils.random(0,1) == 1) {
                         equations.add(generateEquation(EquationType.ADD,min,max,operandAmount));
                     } else {
                         equations.add(generateEquation(EquationType.SUB,min,max,operandAmount));
                     }
                     break;
             }
         }

         return new Exercise(equations,exerciseType);
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
                 operands.add(MyUtils.random(min,temp-min*(amount-i)));
                 temp -= operands.get(i);
             }
         } else if (max <= 0) {
             long minTmp = -max;
             long maxTmp = -min;
             temp = MyUtils.random(minTmp*amount,maxTmp);
             operands.add(temp);
             for (int i = 1; i < amount; i++) {
                 operands.add(MyUtils.random(minTmp,temp-minTmp*(amount-i)));
                 temp -= operands.get(i);
             }

             for (int i = 0; i < amount; i++) {
                 operands.set(i,-operands.get(i));
             }
         } else {
             long more = -min;
             long maxChange = max + more;
             temp = MyUtils.random(more*(amount-1),more*amount+max);

             operands.add(temp-amount*more);
             ArrayList<Long> operandsTmp = generateOperandsAdd(temp, 0, maxChange, amount);

             for (int i = 0; i < amount-1; i++) {
                 operands.add(operandsTmp.get(i)-more);
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
            long minTmp = -max;
            long maxTmp = -min;
            temp = MyUtils.random(minTmp*amount,maxTmp);
            for (int i = 0; i < amount; i++) {
                operands.add(MyUtils.random(minTmp,temp-minTmp*(amount-i-1)));
                temp -= operands.get(i);
            }
            for (int i = 0; i < amount; i++) {
                operands.set(i,-operands.get(i));
            }
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
      * 生成能够凑成某个数的 指定数量并且符合范围的数字（所有参数均为非付整数）
      * @param value 被凑的数
      * @param min 凑数的最小值
      * @param max 凑数最大值
      * @param amount 凑数个数
      * @return 凑数集合
      */
    public ArrayList<Long> generateOperandsAdd(long value, long min,long max,int amount) {
        if (value > max*amount || value < min*amount || amount == 0) return null;

        ArrayList<Long> operands = null;
        int flag = 0;

        while (flag == 0) {
            long more = max * amount - value;
            operands = new ArrayList<>(amount);
            for (int i = 0; i < amount; i++) {
                operands.add(max);
            }

            while (more > 0) {
                int index = (int) MyUtils.random(0,amount-1);
                operands.set(index,operands.get(index)-1);
                more--;
            }

            int flagTmp = 1;
            for (int i = 0; i < amount; i++) {
                long operand = operands.get(i);
                if (operand < min) {
                    flagTmp = 0;
                    break;
                }
            }

            flag = flagTmp;
        }

        return  operands;
    }
}
