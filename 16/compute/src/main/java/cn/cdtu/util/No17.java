package cn.cdtu.util;


import cn.cdtu.pojo.Equation;
import cn.cdtu.service.impl.ExerciseServiceImpl;

//需求17:产生3个数值的二元运算
public class No17 {

    ExerciseServiceImpl service = new ExerciseServiceImpl();
    //加减混合输出
    public void generateAddAndSUB(int total,int numCol) {
        for (int i = 1; i <= total; i++) {
            Equation equation;
            Object[] objects;
            if(i < (total/2)){
                equation = service.generateAdd(0, 100, 3);
                objects = equation.operands.toArray();
                String num1 = objects[0].toString();
                String num2 = objects[1].toString();
                String num3 = objects[2].toString();

                if (i % numCol ==0){
                    System.out.print("\t" + num1 + "+" + num2 + "+" + num3 + "=" + equation.getValue()+"\n");
                }else {
                    System.out.print("\t" + num1 + "+" + num2 + "+" + num3 + "=" + equation.getValue()+"\t");
                }
            }else {
                equation = service.generateSub(0, 100, 3);
                objects = equation.operands.toArray();
                String num1 = objects[0].toString();
                String num2 = objects[1].toString();
                String num3 = objects[2].toString();

                if (i % numCol ==0){
                    System.out.print("\t" + num1 + "-" + num2 + "-" + num3 + "=" + equation.getValue()+"\n");
                }else {
                    System.out.print("\t" + num1 + "-" + num2 + "-" + num3 + "=" + equation.getValue()+"\t");
                }
            }


        }

    }
}
