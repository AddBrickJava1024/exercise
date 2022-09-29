package cn.cdtu.service;

import cn.cdtu.pojo.Equation;
import cn.cdtu.util.EquationType;
import cn.cdtu.util.ExerciseType;

import java.math.BigDecimal;
import java.util.HashSet;

/**
 * @author makun
 * @project 16
 * @description 组成试卷的服务接口
 * @date 2022/09/28 15:04:30
 * version 1.0
 */
public interface ExerciseService {
    /**
     * 产生一个试题
     * @param type 试题类型
     * @param minOperand 试题操作数以及运算结果最小值
     * @param maxOperand 试题操作数以及运算结果最大值
     * @param amount 试题操作数数量
     * @return 试题
     */
    Equation generateEquation(EquationType type, long minOperand, long maxOperand, int amount);

    /**
     * 产生一套试卷
     * @param exerciseType 试卷类型
     * @param equationType 试题类型
     * @param min 试题操作数以及运算结果最小值
     * @param max 试题操作数以及运算结果最大值
     * @param amount 试题操作数量
     * @return 试题
     */
    HashSet<Equation> generateEquations(ExerciseType exerciseType, EquationType equationType, long min, long max, int amount);
}
