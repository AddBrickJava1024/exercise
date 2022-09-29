package cn.cdtu.pojo;

import cn.cdtu.util.ExerciseType;

import java.util.HashSet;

/**
 * @author makun
 * @project 16
 * @description 试卷实体类
 * @date 2022/09/28 15:12:36
 * version 1.0
 */
public class Exercise {
    // 试卷名
    public String name;
    // 试卷包含的题目
    public HashSet<Equation> equations;
    // 试卷类型
    public ExerciseType type;

    public Exercise(String name, HashSet<Equation> equations, ExerciseType type) {
        this.name = name;
        this.equations = equations;
        this.type = type;
    }

    public Exercise() {
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", equations=" + equations +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Equation> getEquations() {
        return equations;
    }

    public void setEquations(HashSet<Equation> equations) {
        this.equations = equations;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }
}
