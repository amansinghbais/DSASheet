package ds.array1;
//Problem Statement
//Given an integer array arr, find the contiguous subarray (containing at least one number) which has the largest sum
//and return its sum and print the subarray.



public class maximumSumSubArray {

//    Method-1 : NaiveApproach
//    Using Three for loop , two for find subarray and one for calculating the sum and keep storing maxSum , startInd and
//    endIndex of the max sum subArray.
//    Time Complexity - O(n^3)
//    Space Complexity - O(1)
    static void naiveApproach(int[] arr){
        int maxSum = Integer.MIN_VALUE , start = 0 , end = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i + 1 ; j < arr.length ;j++){
                int sum = 0;
                // Calculating sum of the subarray from i to j.
                for(int k = i ; k <= j ; k++){
                    sum+= arr[k];
                }
                //If currSum is maximum then update maxSum variable and start & end index variable
                if(sum > maxSum){
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }
        }
        //Printing the result
        System.out.println("The max sum of a SubArray: " + maxSum);
        System.out.print("The subarray with max sum: ");
        for(int i = start ; i <= end ; i++){
            System.out.print(arr[i] + " ");
        }
    }

//   Method - 2: Better Approach
//   Here instead of three we use two for loop and we keep calculating the sum so far and update it with maxSum.
//   Time complexity - O(n^2)
//   Space Complexity - O(1)
    static void betterApproach(int[] arr){
        int maxSum = Integer.MIN_VALUE , start = 0 , end = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int currsum = 0;
            for(int j = i ; j < arr.length ; j++){
                // Continuously adding the element in currSum.
                currsum += arr[j];
                // Checking whether the sum till now is maximum or not if it is max then update some variables
                if(currsum > maxSum){
                    maxSum = currsum;
                    start = i;
                    end = j;
                }
            }
        }
        //Printing the result
        System.out.println("The max sum of a SubArray: " + maxSum);
        System.out.print("The subarray with max sum: ");
        for(int i = start ; i <= end ; i++){
            System.out.print(arr[i] + " ");
        }
    }

//  Method-3 : Optimal Solution(Kadane's Algorithm)
//  Continuously calculating sum while we traverse in the array and compare it with the maxSum.
//  Time Complexity - O(n)
//  Space Complexity - O(1)
    static void optimalSolution(int[] arr){
        int currSum = 0 , maxSum = Integer.MIN_VALUE;
        int start = 0 , end = 0 , maxStart = 0 , maxEnd = 0;
        for(int i = 0 ; i < arr.length ; i++){
            currSum += arr[i];
            // Check if the sumSoFar is greater than the maximum sum and if it is , then update the maxSum variable and
            // and the maxStart and maxEnd Indexes to keep track of the subarray.
            if(currSum > maxSum){
                maxSum = currSum;
                end = i;
                maxEnd = end;
                maxStart = start;
            }
            // If the sum calculated so far goes below then 0 then reset the sum = 0 and index to i+1 and again start
            // find new subArray.
            if(currSum < 0){
                currSum = 0;
                start = i+ 1;
            }
        }
        //Printing the result
        System.out.println("The max sum of a SubArray: " + maxSum);
        System.out.print("The subarray with max sum: ");
        for(int i = maxStart ; i <= maxEnd ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

//        naiveApproach(arr);
//        betterApproach(arr);
        optimalSolution(arr);
    }
}
