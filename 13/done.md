## 13题完成情况

### 一、不允许有相同的算式

### 代码2.2
> 此代码实现使用了hashset集合，并且试题的实体类重写了hashcode以及equals方法
> 不存在试题重复的现象
````java
 /**
     * 生成指定数量的加减法算术题
     * @param quantity 指定数量
     * @return 所有算术题
     */
    public static HashSet<Topic> generateTopicsRandomPlus(int quantity) {
        HashSet<Topic> topics = new HashSet<>(quantity);

        while (topics.size() != quantity) {
            if (randomArea(0,1) == 1) {
                topics.addAll(generateTopicsSum(1));
            } else {
                topics.addAll(generateTopicsSub(1));
            }
        }

        return topics;
    }
````

### 2.2.2设计1
> 试题实现使用单链表结构，在添加试题结点时加入验证
````java
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
````

### 2.2.2设计2
> 在试题产生函数中增加是否重复验证
````java
 /**
     * 产生指定题目数量的练习题
     * @param amount 数量
     * @return 行代表第几题，列与产生题目的一维数组对应
     */
    public static int[][] generateExercise(int amount) {
        int[][] exercise = new int[amount][3];
        int[] equation;
        int cnt = 0;
        int flag = 0;

        while (cnt < amount) {
            flag = 0;
            if (random(0,1) == 1) {
                equation = generateSum();
            } else {
                equation = generateSub();
            }
            // 加入是否重复验证
            for (int i = 0; i < cnt; i++) {
                if (exercise[i][0] == equation[0] && exercise[i][1] == equation[1] && exercise[i][2] == equation[2]) {
                    // 表示重复了
                    flag = 1;
                    break;
                }
            }
            //如果不重复就加
            if (flag == 0) {
                exercise[cnt][0] = equation[0];
                exercise[cnt][1] = equation[1];
                exercise[cnt][2] = equation[2];
                // 计数器加1
                cnt++;
            }
        }

        return exercise;
    }
````

### 二、如何确定写出的程序满足不重复的要求呢？
> 我的方法：
> 将随机产生算式的函数设定为固定产生
> 如果产生试卷时程序陷入了死循环则表示满足要求