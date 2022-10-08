package com.example.exercise;

import java.util.Objects;

/**
 * @author makun
 * @project 11
 * @description 启动类
 * @date 2022/09/28 11:28:07
 * version 1.0
 */
public class Main {
    // 使用内部类模拟c语言结构体，试题结构体
    static class Equation {
        int left_op,right_op;
        char op;
        Equation next_node = null;

        int calculate() {
           if (this.op == '+') {
               return this.left_op + this.right_op;
           } else {
               return this.left_op - this.right_op;
           }
        }

        public Equation() {
        }

        public Equation(int left_op, int right_op, char op, Equation next_node) {
            this.left_op = left_op;
            this.right_op = right_op;
            this.op = op;
            this.next_node = next_node;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Equation equation = (Equation) o;
            return left_op == equation.left_op && right_op == equation.right_op && op == equation.op;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left_op, right_op, op);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-3d",left_op));
            sb.append(op);
            sb.append(String.format("%3d",right_op));
            sb.append(" = ");

            return sb.toString();
        }
    }

    // 使用内部类模拟C语言结构体，试卷结构体
    static class Exercise {
        int length = 0;
        Equation head = new Equation();

        // 在末尾添加结点
        boolean add(Equation equation) {
            Equation current = head;

            for (int i = 0; i < length; i++) {
                current = current.next_node;
                if (current.equals(equation)) {
                    return false;
                }
            }

            current.next_node = equation;
            length++;

            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Equation current = head.next_node;
            for (int i = 1; i <= length; i++) {
                sb.append(String.format("%-2d",i));
                sb.append("、");
                sb.append(current.toString());
                if (i % 2 == 1) {
                    sb.append("\t");
                } else {
                    sb.append("\n");
                }

                current = current.next_node;
            }

            return sb.toString();
        }
    }


    public static void main(String[] args) {
        // 产生试题
        Exercise exercise = generateExercise(10);

        // 打印试题
        System.out.println(exercise);
    }

    /**
     * 产生指定数量，并且试题不重复的试题
     * @param amount 指定数量
     * @return
     */
    public static Exercise generateExercise(int amount) {
        Exercise exercise = new Exercise();

        while (exercise.length < amount) {
            Equation equation;

            if (random(0,1) == 1) {
                equation = generateSum();
            } else {
                equation = generateSub();
            }

            exercise.add(equation);
        }

        return exercise;
    }

    /**
     * 产生一个加法
     * @return
     */
    public static Equation generateSum() {
        int left_op,right_op,value;

        value = random(2,100);
        left_op = random(1,value - 1);
        right_op = value - left_op;

        return new Equation(left_op,right_op,'+',null);
    }

    /**
     * 产生一个减法
     * @return
     */
    public static Equation generateSub() {
        int left_op, right_op;

        left_op = random(2,100);
        right_op = random(1,left_op-1);

        return new Equation(left_op,right_op,'-',null);
    }

    /**
     * 随机产生符合范围的数（包含）
     * @param min
     * @param max
     * @return
     */
    public static int random(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);
    }
}
