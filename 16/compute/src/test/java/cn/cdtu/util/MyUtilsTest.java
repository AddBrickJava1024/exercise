package cn.cdtu.util;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author makun
 * @project 16
 * @description
 * @date 2022/09/28 16:32:54
 * version 1.0
 */
public class MyUtilsTest extends TestCase {

    //需求17，total为试题总数，numCol为输出的每一行的列数
    public void testGenerateAddAndSUB(){
        final No17 no17 = new No17();
        no17.generateAddAndSUB(59,3);
    }

    // 测试一下能否打印到文件
    public void testPrintToFile() {
        String path = "C:\\Users\\makun\\Desktop";
        String fileName = "test.java";
        String content = "这是一段内容";

        boolean b = MyUtils.printToFile(content, path, fileName, true);
        System.out.println(b);
    }

    // 判断数字的位数
    public void testGetDigit() {
        System.out.println(MyUtils.getDigit(1));
    }
}