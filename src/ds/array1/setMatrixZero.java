package ds.array1;
//Problem Statement
//Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then
// return the matrix.

public class setMatrixZero {
//    Method-1 : Brute Force Approach
//    Traverse through the matrix and if you find the element with value 0 , then change all the element in its row
//    and column to -1 , except when an element is 0.
//    Now Traverse again through the matrix and change all element with value -1 to 0.
//    Time Complexity - O((n * m)*(n+m))
//    Space Complexity - O(1).
    static void setMatrixZeroBrute(int[][] arr){
        int n = arr.length ;
        int m = arr[0].length;
        int i = 0 , j = 0 , k = 0;
        for(i = 0 ; i < n ; i++){
            for(j = 0 ; j < m ; j++){
                // Checking if element is 0 and if found 0 make all element in its row  and col to be -1.
                if(arr[i][j] == 0){
                    for(k = 0 ; k < n ; k++){
                        //Check if the current element is equal to 0 if not 0 the change to -1 else do not change.
                        if(arr[k][j] != 0){
                            arr[k][j] = -1;
                        }
                    }
                    for(k = 0 ; k < m ; k++){
                        if(arr[i][k] != 0){
                            arr[i][k] = -1;
                        }
                    }
                }
            }
        }
        // Making all element with value -1 to value 0.
        for(i = 0 ; i < n ; i++){
            for(j = 0 ; j < m ; j++){
                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                }
            }
        }
    }


//    Method-2 : Using auxiliary Space
//    In this approach , we use dummy arrays to check whether the particular row and column has an element 0 or not,
//    which will improve the time complexity.
//
//    Take Two dummy array one of size of row and other of size of column. Now traverse through the array.If element is
//    found to be 0 then set dummy1[i] = -1 & dummy2[j] = -1.Now traverse through the array again and if dummy1[i] == -1 ||
//    dummy2[j] == -1 then arr[i][j] = 0 , else continue.
//    Time Complexity - O(n*m + n*m).
//    Space Complexity - O(n).
    static void setMatrixZeroUsingSpace(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0 , j = 0;

        //Creating two dummy arrays one of size of row and other of size of col.
        int[] row = new int[n];
        int[] col = new int[m];

        //Traversing through matrix and if element is 0 making dummy arrays curr ind = -1;
        for(i = 0 ; i < n ; i++){
            for (j = 0 ; j < m ; j++){
                if(matrix[i][j] == 0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        // Again traversing and if any row or col array has curr ind val = -1 then updating matrix element with 0.
        for(i = 0 ; i < n ; i++){
            for(j = 0 ; j < m ; j++){
                if(row[i] == -1 || col[j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }


// Method - 3 : Optimal Solution
//    Instead of taking two separate dummy array,take first row and column of the matrix as the array for checking
//    whether the particular column or row has the value 0 or not.Since matrix[0][0] are overlapping.
//    Therefore, take separate variable col0(say) to check if the 0th column has 0 or not and use matrix[0][0] to check
//    if the 0th row has 0 or not.Now traverse from last element to the first element and check if matrix[i][0]==0 ||
//    matrix[0][j]==0 and if true set matrix[i][j]=0,else continue.
//    Time Complexity - O(2 * (N * M))
//    Space Complexity - O(1)

    static void optimalSolution(int[][] matrix){
        int row = matrix.length , col = matrix[0].length , col0 = 1;

        for(int i = 0 ; i < row ; i++){
            //Checking 0 in the first column and if found make col0 = 0.
            if(matrix[i][0] == 0) col0 = 0;

            //Traversing for all col except col 0 since col 0 is decided using col0 variable since it collapse matrix[0][0]
            for(int j = 1 ;j < col ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //Traversing through matrix from reverse and checking 0 in first row and col of matrix.
        for(int i = row - 1 ; i >= 0 ; i--){
            for(int j = col - 1 ; j >= 1 ; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0){
                matrix[i][0] = 0;
            }
        }
    }

//------------------------------Main Function-----------------------------------------------------------------
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        //setMatrixZeroBrute(arr);
        //setMatrixZeroUsingSpace(arr);
        optimalSolution(arr);

        printArray(arr);
    }

//    ---------------------------Print Function---------------------------------------------------------------
    // Function printArray to print the whole matrix
    static void printArray(int[][] arr){
        for(int i = 0 ;i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
