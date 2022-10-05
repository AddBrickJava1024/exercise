package cn.cdtu;

import cn.cdtu.pojo.Exercise;
import cn.cdtu.proxy.ExerciseProxy;
import cn.cdtu.util.ExerciseType;
import cn.cdtu.util.MyUtils;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AppTest extends TestCase {
    ExerciseProxy proxy = new ExerciseProxy(1L,100L, ExerciseType.ADD);

    /**
     * 1， 产生50道【0-200】的加法或减法的二元运算
     * 2， 产生50道【-100，100】的加法或减法的二元运算（有未知问题）
     */
    public void test16() {
        ExerciseProxy proxy = new ExerciseProxy(0L,200L, ExerciseType.ADD_OR_SUB);
        String paper = proxy.generatePaper(proxy.generateExercise(50),5,true);
        System.out.println(paper);
        System.out.println("***********************************");
        // 范围在此修改
        proxy.setMin(-100L);
        proxy.setMax(100L);
        paper = proxy.generatePaper(proxy.generateExercise(50),5,true);
        System.out.println(paper);
    }

    /**
     * 可以产生最多3个数值的【0-100】的二元算式
     * 整齐打印输出5列算式
     * 算式题数10，11，19，50，55，59，61，100，101，119，120
     */
    public void test17() {
        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD);
        proxy.setOperandAmount(3);
        // 题数在此修改
        Exercise exercise = proxy.generateExercise(120);
        String paper = proxy.generatePaper(exercise,5,true);
        System.out.println(paper);
    }

    /**
     * 产生n个数值的整数加减法算式（太大有问题，有时间修复）
     */
    public void test18() {
        int n = 4;
        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD_OR_SUB);
        proxy.setOperandAmount(n);
        Exercise exercise = proxy.generateExercise(20);
        String paper = proxy.generatePaper(exercise, 5, true);
        System.out.println(paper);
    }

    /**
     * 输出任意列数的习题（列数是正的就没问题，如果运算的数字太大就无了）
     */
    public void test19() {
        int n = 4;
        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD_OR_SUB);
        Exercise exercise = proxy.generateExercise(20);
        String paper = proxy.generatePaper(exercise, n, true);
        System.out.println(paper);
    }

    /**
     * 不是随机产生吗？怎么会有输入
     */
    public void test20() {
        assertTrue( true );
    }

    /**
     * 整齐打印每行5列算式（打印问题不大，如果运算的数字太大就无了）
     * 题数：10，11，19，50，55，59，61，100，101，119，120
     */
    public void test21() {
        int n = 10;
        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD_OR_SUB);
        Exercise exercise = proxy.generateExercise(n);
        String paper = proxy.generatePaper(exercise, 5, true);
        System.out.println(paper);
    }

    /**
     * 整齐打印每行4列
     * 题数：5，7，8，19，20，21，39，40，41，99，100
     */
    public void test22() {
        int n = 5;
        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD_OR_SUB);
        Exercise exercise = proxy.generateExercise(n);
        String paper = proxy.generatePaper(exercise, 4, true);
        System.out.println(paper);
    }

    /**
     * 整齐打印每行6列算式
     * 题数：5，6，7，23，24，25，59，60，61，119，120
     */
    public void test23() {
        int n = 120;
        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD_OR_SUB);
        Exercise exercise = proxy.generateExercise(10);
        String paper = proxy.generatePaper(exercise, 6, true);
        System.out.println(paper);
    }

    /**
     * 测试将字符串打印到文件的功能
     */
    public void testDiy01() {
        String path = "C:\\Users\\makun\\Desktop";
        String fileName = "exercise";

        ExerciseProxy proxy = new ExerciseProxy(0L,100L, ExerciseType.ADD);
        proxy.setOperandAmount(3);
        Exercise exercise = proxy.generateExercise(120);
        String paper = proxy.generatePaper(exercise,5,true);
        Assert.assertEquals(true, MyUtils.printToFile(paper,path,fileName,false));
    }
}
