public class driver_3 {
    public static void main(String[] args){
        utility u = new utility();
        int[][] matrix = u.inputMatrix(3, 3);
        System.out.println("your matrix: ");
        u.printMatrix(matrix);

        if (u.isSymmetric(matrix)) {
            System.out.println("your matrix is symmetric.");
        }
        else{
            System.out.println("your matrix is not symmetric.");
        }
    }
}

