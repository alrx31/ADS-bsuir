package by.it.group351001.yazikov.lesson08;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: рюкзак с повторами

Первая строка входа содержит целые числа
    1<=W<=100000     вместимость рюкзака
    1<=n<=300        сколько есть вариантов золотых слитков
                     (каждый можно использовать множество раз).
Следующая строка содержит n целых чисел, задающих веса слитков:
  0<=w[1]<=100000 ,..., 0<=w[n]<=100000

Найдите методами динамического программирования
максимальный вес золота, который можно унести в рюкзаке.


Sample Input:
10 3
1 4 8
Sample Output:
10

Sample Input 2:

15 3
2 8 16
Sample Output 2:
14

*/

public class A_Knapsack {

    int getMaxWeight(InputStream stream) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        Scanner scanner = new Scanner(stream);
        int W = scanner.nextInt();
        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int[] dp = new int[W + 1];
        for (int weight = 1; weight <= W; weight++) {
            for (int i = 0; i < n; i++) {
                if (weights[i] <= weight) {
                    dp[weight] = Math.max(dp[weight], dp[weight - weights[i]] + weights[i]);
                }
            }
        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return dp[W];
    }


    public static void main(String[] args) throws FileNotFoundException {
        InputStream stream = by.it.group351001.yazikov.lesson08.A_Knapsack.class.getResourceAsStream("dataA.txt");
        by.it.group351001.yazikov.lesson08.A_Knapsack instance = new by.it.group351001.yazikov.lesson08.A_Knapsack();
        int res=instance.getMaxWeight(stream);
        System.out.println(res);
    }
}