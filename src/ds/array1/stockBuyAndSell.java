package ds.array1;
//Problem Statement
//You are given an array of prices where prices[i] is the price of a given stock on an ith day.You want to maximize your
// profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
public class stockBuyAndSell {
//    Brute Force Approach:
//    We can simply use 2 loops and track every transaction and maintain a variable maxPro to contain the max value
//    among all transactions.
//    Time Complexity - O(n^2)
    static int bruteApproach(int[] arr){
        int maxProfit = Integer.MIN_VALUE;
        //Traversing over array using two for loop such that second loop start from the element next to first loop element.
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1; j < arr.length ; j++){
                int profit = arr[j] - arr[i];
                //Storing profit in maxProfit if profit is greater than maxProfit.
                if(profit > maxProfit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }

//    Optimal Solution:
//    We will linearly travel the array. We can maintain a minimum so far from the starting of the array and compare it
//    with every element of the array, if it is greater than the minimum then take the difference and maintain it in max,
//    otherwise update the minimum.
//    Time Complexity - O(n)
//    Space Complexity - O(1)

    static int optimalApproach(int[] arr){
        int minSoFar = arr[0] , maxProfit = 0;
        for(int i = 0 ; i < arr.length ; i++){
            //Calculating the minimum element till current element.
            minSoFar = Math.min(minSoFar , arr[i]);
            //Calculating the max profit we can earn till the current element.
            maxProfit = Math.max(maxProfit , arr[i] - minSoFar);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};

//        int res = bruteApproach(arr);
        int res = optimalApproach(arr);

        System.out.println("The max Profit we can get: " + res);
    }
}
