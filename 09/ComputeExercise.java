import java.util.Random;

public class ComputeExercise {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0;
        
        Random random = new Random();
        // 输出两套加法
        System.out.println("************1、算术题：加法（50题）**************");
        for (int i = 1; i <= 50; i++) {
            num1 = random.nextInt(101);
            num2 = random.nextInt(101);
            System.out.println(i + ":" + "\t" + num1 + "+" + num2 + "=");
        }
        System.out.println("************2、算术题：加法（50题）**************");
        for (int i = 1; i <= 50; i++) {
            num1 = random.nextInt(101);
            num2 = random.nextInt(101);
            System.out.println(i + ":" + "\t" + num1 + "+" + num2 + "=");
        }

        // 输出两套减法
        System.out.println("************3、算术题：减法（50题）**************");
        for (int i = 1; i <= 50; i++) {
            num1 = random.nextInt(101);
            num2 = random.nextInt(101);
            System.out.println(i + ":" + "\t" + num1 + "-" + num2 + "=");
        }

		System.out.println("************4、算术题：减法（50题）**************");
        for (int i = 1; i <= 50; i++) {
            num1 = random.nextInt(101);
            num2 = random.nextInt(101);
            System.out.println(i + ":" + "\t" + num1 + "-" + num2 + "=");
        }

		// 混合输出
		System.out.println("************5、算术题：加减法（50题）**************");
		for (int i = 1; i <= 50; i++) {
			num1 = random.nextInt(101);
			num2 = random.nextInt(101);
			if (random.nextInt(2) == 1)
			{
				System.out.println(i + ":" + "\t" + num1 + "+" + num2 + "=");
			} else {
				System.out.println(i + ":" + "\t" + num1 + "-" + num2 + "=");
			}	
		}
    }

}