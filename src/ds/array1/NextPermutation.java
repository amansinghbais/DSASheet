package ds.array1;

// Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater
// permutation of numbers.If such an arrangement is not possible, it must rearrange it as the lowest possible order
// (i.e., sorted in ascending order).

public class NextPermutation {
/*
    Algo---
    Step 1: Linearly traverse array from backward such that ith index value of the array is less than (i+1)th index value.
            Store that index in a variable.
    Step 2: If the index value received from step 1 is less than 0. This means the given input array is the largest
            lexicographical permutation. Hence, we will reverse the input array to get the minimum or starting permutation.
            Linearly traverse array from backward. Find an index that has a value greater than the previously found index.
            Store index another variable.
    Step 3: Swap values present in indices found in the above two steps.
    Step 4: Reverse array from index+1 where the index is found at step 1 till the end of the array.

    Time Complexity - O(n)
*/
    public static void nextPermutation(int[] arr){
        // If the array contains 0 or 1 element there is no next permutation possible so we return from the function.
        if(arr == null || arr.length <= 1) return;
        // Pointer i starting from second last element to find the index where the element is less then next element
        int i = arr.length - 2;
        while(i >= 0 && arr[i] >= arr[i+1]) i--;
        if(i >= 0){
            int j = arr.length - 1;
            //Using pointer j to find element just greater than the ith element
            while(arr[j] <= arr[i]) j--;
            swap(arr , i , j);
        }
        reverse(arr , i + 1 , arr.length - 1);
    }

    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr , int i , int j){
        while(i < j){
            swap(arr , i++ , j--);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};

        nextPermutation(arr);

        printArray(arr);
    }
    //Function to print all the elements of an array
    public static void printArray(int[] arr){
        for(int el  : arr){
            System.out.print(el + " ");
        }
    }

}
