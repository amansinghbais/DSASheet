package ds.array1;
import java.util.ArrayList;
import java.util.Scanner;

//In Pascal’s triangle, each number is the sum of the two numbers directly above it.

public class pascalTriangle {
    /*
        Solution:
        In this we first create a main ArrayList having type of ArrayList<Integer> and then we iterate over this list
        and do following operations:
            1. Create an ArrayList of Integer and run a for loop on it from 0 to i.
            2. If the element is at the either end of list then add 1.
            3. Else we add the sum of elements at currIndex -1 and currIndex position in last row list.
            4. add the current row in final list
            5. Update prev list with current row.

        Time Complexity - O(n^2)
        Space Complexity - O(n^2)
    */
    public static ArrayList<ArrayList<Integer>> solution(int n){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> row , pre = null;
        for(int i = 0 ; i < n ; i++){
            row = new ArrayList<Integer>();
            for(int j = 0 ; j <= i ; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = row;
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ArrayList<ArrayList<Integer>> result = solution(n);

        printList(result);
    }

    //Functions to print whole ArrayList.
    public static void printList(ArrayList<ArrayList<Integer>> result){
        int row = result.size();
        // For loop to iterate over result's rows
        for(int i = 0 ; i < row ; i++){
            int col = result.get(i).size();
            //Loop to create space before printing all element of each row to make it look pyramid.
            for(int space = 0 ; space < row - col ; space++){
                System.out.print("  ");
            }
            // Loop for printing all element in list at each row.
            for(int j = 0 ; j < col ; j++){
                System.out.print(result.get(i).get(j) + "   ");
            }
            System.out.println();
        }
    }
}
