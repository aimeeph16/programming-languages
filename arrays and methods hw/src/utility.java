import java.util.Scanner;

public class utility {
    Scanner sc = new Scanner(System.in);

    //takes the user input as the length of the array
    public int arrayLength(){
        int n;
        System.out.print("Enter the length of the array >> ");
        n = sc.nextInt();
        return n;
    }

    //fills in an empty array according to the user input
    public void inputValues(int[] a, int n){
        for(int i=0; i<n; i++){
            System.out.print("enter integer: ");
            int num = sc.nextInt();
            a[i] = num;
        }
    }

    //finds the index of a given element in an array
    public static int index(int arr[], int t) {
        if (arr == null) {  //to make sure the array is not empty
            return -1;
        }

        int len = arr.length;
        int i = 0;

        while (i < len) {
            if (arr[i] == t) {
                return i;       //will return i, the index, once a match between the given element and the value at i is found
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    //finds the largest element in an array
    public int findLargest(int[] arr, int n) {
        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i]>largest){    //goes through the entire array while replacing the set 'largest number' if a bigger number is found
                largest = arr[i];
            }
        }
        return largest;
    }

    //input the elements in the matrix
    public int[][] inputMatrix(int row, int col){
        int[][] mat = new int[row][col];
        System.out.println("enter values to be in the matrix >> ");
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                mat[i][j] = sc.nextInt();   //fills in the elements by row-column
            }
        }
        return mat;
    }

    //displays the whole matrix
    //also used to display the magic square later on
    public void printMatrix(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }
    }

    //transposes a matrix
    public int[][] transpose(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        int[][] newmat = new int[row][col];     //a new matrix is made to store the transpose
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                newmat[j][i] = mat[i][j];
            }
        }
        return newmat;
    }

    //to check whether the matrix is symmetrical or not, by seeing if it is exactly the same with its transpose
    public boolean isSymmetric(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        int[][] newmat = transpose(mat);
        boolean sym = true;
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (mat[i][j] != newmat[i][j]){     //checks for any difference between the elements
                    sym = false;
                    break;
                }
            }
        }
        if (sym) {
            return true;
        }
        else{
            return false;
        }
    }

    public int[][] MS_odd(int start, int end, int n){
        int[][] ms = new int[n][n];
        int i=0;
        int j=n/2;
        ms[i][j] = start; //the top middle spot will be filled with the starting number

        //continue filling in from there
        for(int num=start+1; num<=end; num++){
            int temp_i=i; //to temporarily keep the current positions of the elements
            int temp_j=j;

            //the proceeding elements will move '1 row up, 1 column to the right' from the previous position
            if ((i-1)<0){
                i=n-1;      //to keep the row numbers within the square borders
            }
            else{
                i--;    //else the row moves up by 1
            }
            if ((j+1)>(n-1)){
                j=0;    //to keep the column numbers within the square borders
            }
            else{
                j++;    //else the column moves to the right by 1
            }

            //if the next position has already been filled up, the next move will be to return to the previous position and move down by 1
            if (ms[i][j] != 0) {
                i = temp_i + 1;
                j = temp_j;
            }
            ms[i][j] = num; //fill the final position
        }
        return ms;
    }

    public int[][] MS_doublyEven(int n){
        //square will be filled in order from 1 to n*n
        int[][] ms = new int[n][n];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++)
                ms[i][j] = (n*i)+j+1;
        }

        //the array elements will be changed according to (n*n+1)-arr[i][j]

        //by order (n/4)*(n/4) //top right corner
        for (int i=0; i< n/4; i++){
            for (int j=3*(n/4); j<n; j++) {
                ms[i][j] = (n*n+1) - ms[i][j];
            }
        }

        //by order (n/4)*(n/4) //top left corner
        for (int i=0; i<n/4; i++){
            for (int j = 0; j<n/4; j++){
                ms[i][j] = (n*n + 1) - ms[i][j];
            }
        }

        //by order (n/4)*(n/4) //bottom right corner
        for (int i=3*n/4; i<n; i++){
            for (int j=3*n/4; j<n; j++){
                ms[i][j] = (n*n+1) - ms[i][j];
            }
        }

        //by order (n/4)*(n/4) //bottom left corner
        for (int i=3*n/4; i<n; i++){
            for (int j=0; j<n/4; j++) {
                ms[i][j] = (n * n + 1) - ms[i][j];
            }
        }

        //by order (n/2)*(n/2) //center square
        for (int i=n/4; i<3* n/4; i++){
            for (int j=n/4; j<3* n/4; j++){
                ms[i][j] = (n*n+1) - ms[i][j];
            }
        }
        return ms;
    }

    public void magicSquare(int n){

        //for an odd size
        if (n%2!=0 & n%4!=0){
            int[][] mat = MS_odd(1, n*n, n);
            printMatrix(mat);
        }

        //for a double even size
        else if (n%4==0){
            int[][] mat = MS_doublyEven(n);
            printMatrix(mat);
        }

        //for a singly even size
        else {
            //the square wil be divided into 4 equal sections, such that the sides of each section are an odd number
            //each section will be turned into their own magic square, following the odd-size method

            int[][] s1 = MS_odd(1, (n/2)*(n/2), n/2);   //top left section
            int[][] s2 = MS_odd(((n*n)/2)+1, (n/2)*(n/2)*(n/2), n/2);   //top right section
            int[][] s3 = MS_odd((n/2)*(n/2)*(n/2)+1, n*n, n/2); //bottom left section
            int[][] s4 = MS_odd((n/2)*(n/2)+1, (n*n)/2, n/2);   //bottom right section
            int[][] mat = new int[n][n];

            //fill in the final magic square, per section
            for (int i=0; i<(n/2); i++){
                for (int j=0; j<(n/2); j++){
                    mat[i][j] = s1[i][j];
                }
            }
            for (int i=0; i<(n/2); i++){
                for (int j=n/2, k=0; j<n & k<n/2; j++, k++){
                    mat[i][j] = s2[i][k];
                }
            }
            for (int i=n/2, k=0; i<n & k<n/2; i++, k++){
                for (int j=0; j<n/2; j++){
                    mat[i][j] = s3[k][j];
                }
            }
            for (int i=n/2, k=0; i<n & k<n/2; i++, k++){
                for (int j=n/2, l=0; j<n & l<n/2; j++, l++){
                    mat[i][j] = s4[k][l];
                }
            }

            printMatrix(mat);
        }

    }
}
