import java.util.Scanner;

public class driver_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        utility u = new utility();
        int size;
        System.out.println("Enter the size of the square >> ");
        size = sc.nextInt();
        u.magicSquare(size);
    }
}
