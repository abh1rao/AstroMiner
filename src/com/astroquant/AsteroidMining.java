package com.company;

import java.util.Random;

public class AsteroidMining {

    public static void asteroidMining(String[] args) {
        int N = Integer.parseInt(args[0]);   // number of asteroids
        int W = Integer.parseInt(args[1]);   // maximum available budget to mine asteroids

        int[] profit = new int[N+1];
        int[] weight = new int[N+1];

        Random rand = new Random();

        // generate random instance, items 1..N
        for (int n = 1; n <= N; n++) {
            profit[n] = rand.nextInt(1000);
            weight[n] = rand.nextInt(W);
        }

        // opt[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) option2 = profit[n] + opt[n-1][w-weight[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);


            }
        }
        int totalValue = 0;

        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) {
                take[n] = true;
                w = w - weight[n];
                totalValue += profit[n];
            }
            else {
                take[n] = false;
            }
        }
        System.out.println("Number of asteroids = " + N );
        System.out.println("Maximum budget for mining asteroids = $" + W);
        System.out.println("Total Estimated Value = $" + totalValue );
        // print results
        System.out.println("asteroid #" + "\t" + "value" + "\t" + "cost" + "\t" + "harvest");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t\t\t" + profit[n] + "\t\t" + weight[n] + "\t\t" + take[n]);
        }
    }
}
