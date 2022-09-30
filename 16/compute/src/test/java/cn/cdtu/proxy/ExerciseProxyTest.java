package cn.cdtu.proxy;

import cn.cdtu.pojo.Exercise;
import cn.cdtu.util.ExerciseType;
import junit.framework.TestCase;

/**
 * @author makun
 * @project 16
 * @description
 * @date 2022/09/29 22:50:01
 * version 1.0
 */
public class ExerciseProxyTest extends TestCase {
    ExerciseProxy proxy = new ExerciseProxy(-100L,100L, ExerciseType.ADD);

    // 测试生成试卷字符串是否实现
    public void testGeneratePaper() {
        Exercise exercise = proxy.generateExercise(100);
        String paper = proxy.generatePaper(exercise, 10, false);
        System.out.println(paper);
    }
}