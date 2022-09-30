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
    // 试卷包含的题目
    private HashSet<Equation> equations;
    // 试卷类型
    private ExerciseType type;

    public Exercise(HashSet<Equation> equations, ExerciseType type) {
        this.equations = equations;
        this.type = type;
    }

    public Exercise() {
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "equations=" + equations +
                ", type=" + type +
                '}';
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
