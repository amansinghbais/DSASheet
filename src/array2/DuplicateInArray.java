package array2;


import java.util.Arrays;

public class DuplicateInArray {
    /*
        Method-1 : Using Sorting
        Algo-
            Sort the array in increasing order
            Traverse through array and check whether two adjacent element of array are equal or not
            If two adjacent element are equal return the element else return -1.
        Time Complexiy - O(nlogn + n) = O(nlogn)
        Space Complexity - O(1)
    */
    public static int method1UsingSorting(int[] arr){
        int n = arr.length;
        //Sort the array
        Arrays.sort(arr);
        //Traverse through the array
        for(int i = 0 ;i < n - 1 ; i++){
            //Checking if adjacent element are equal.
            if(arr[i] == arr[i+1]){
                return arr[i];
            }
        }
        //Return -1 because no duplicate element is found.
        return -1;
    }

    /*
        Method-2: Using Frequency Array
        Create another array for storing frequency of all the element.
        Time Complexity - O(n)
        Space Complexity - O(n)
    */
    public static int method2UsingFrequencyArray(int[] arr){
        int n = arr.length;
        int[] freq = new int[n + 1];
        //Updating the count of each element occurring while traversing the arr.
        for(int i = 0 ; i < n ; i++){
            freq[arr[i]]++;
        }
        //Checking the whole freq array whether a element has frequecny of 2.
        for(int i = 0 ;i < n + 1; i++){
            if(freq[i] >= 2){
                return i;
            }
        }
        return -1;
    }

    /*
        Method - 3 : Using Linked List Cycle Approach
        Since there is a duplicate number, we can always say that cycle will be formed.
        -Take two pointer and place both at the start of the array.
        -The slow pointer moves by one step and the fast pointer moves by 2 steps and there exists a cycle so the first
         collision is bound to happen.
        -Let the slow and fast pointers meet at some index. Now take the fast pointer and place it at the first element
         i.e 2 and move the fast and slow pointer both by 1 step.
        -The point where they collide will be the duplicate number.
        Time Coplexity - O(n)
        Space Complexity - O(1)
    */
    public static int optimalSolutionUsingCycle(int[] arr){
        int n = arr.length;
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while (slow != fast);
        fast = arr[0];
        while(slow != fast){
            fast = arr[fast];
            slow = arr[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,6,2,4,7,8,5};

//        int res = method1UsingSorting(arr);
//        int res = method2UsingFrequencyArray(arr);
        int res = optimalSolutionUsingCycle(arr);

        //Printing the result
        if(res == -1){
            System.out.println("No Duplicate Found");
        }else{
            System.out.println("The " + res + " is the duplicate in the array.");
        }
    }
}
