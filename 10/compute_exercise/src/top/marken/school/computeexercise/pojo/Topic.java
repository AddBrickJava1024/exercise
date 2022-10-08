package top.marken.school.computeexercise.pojo;

import java.util.Objects;

/**
 * @author makun
 * @project test01
 * @description 题目实体类
 * @date 2022/09/19 20:41:46
 * version 1.0
 */
public class Topic {
    private Integer num1;
    private Integer num2;
    private Integer answer;
    private Character operator;

    public Topic() {
        super();
    }

    public Topic(Integer num1, Integer num2, Integer answer, Character operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.answer = answer;
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(num1, topic.num1) && Objects.equals(num2, topic.num2) && Objects.equals(answer, topic.answer) && Objects.equals(operator, topic.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, answer, operator);
    }

    @Override
    public String toString() {
        return num1.toString() + "\t" + operator.toString() + "\t" + num2.toString() + "\t" + "=" + "\t" + answer;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Character getOperator() {
        return operator;
    }

    public void setOperator(Character operator) {
        this.operator = operator;
    }
}
