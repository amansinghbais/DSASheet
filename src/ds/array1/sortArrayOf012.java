package ds.array1;
//Problem Statement
//Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt
//sort functions. ( Expected: Single pass-O(N) and constant space)

public class sortArrayOf012 {

//   Method-1: Keeping count of values
//   Since in this case there are only 3 distinct values in the array so it’s easy to maintain the count of all, Like
//   the count of 0, 1, and 2. This can be followed by overwriting the array based on the frequency(count) of the values
//   Time Complexity - O(n) + O(n) = O(n)
//   Space Complexity - O(1)
    static void method1(int[] arr){
        int count0 = 0 , count1 = 0 , count2 = 0;
        //Traversing through the array to count the no. of 0 , 1 and 2s in the array.
        for(int i : arr){
            if(i == 0) count0++;
            if(i == 1) count1++;
            if(i == 2) count2++;
        }
        //Again Traversing and making first count0 element 0 then count1 elements 1 and at last count2 elements 2.
        for(int i = 0 ; i < arr.length ; i++){
            if(count0 > 0){
                arr[i] = 0;
                count0--;
            }else if(count1 > 0){
                arr[i] = 1;
                count1--;
            }else{
                arr[i] = 2;
                count2--;
            }
        }
    }


//  Method2 : Variation of Dutch National Flag Algorithm
//  In this approach, we will be using 3 pointers named low, mid, and high. We will be using these 3 pointers to move
//  around the values. The primary goal here is to move 0s to the left and 2s to the right of the array and at the same
//  time all the 1s shall be in the middle region of the array and hence the array will be sorted.
//  Time Complexity - O(n)
//  Space Complexity - O(1)
    static void method2(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        //Traversing through array and swapping such that 0 goes to low , 1 goes to mid and 2 goes to high
        while(mid <= high){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else if(arr[mid] == 2){
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};

//        method1(arr);
        method2(arr);
        printArray(arr);
    }

    //Function to print sorted array
    static void printArray(int[] arr){
        for(int element : arr){
            System.out.print(element + " ");
        }
    }
}
