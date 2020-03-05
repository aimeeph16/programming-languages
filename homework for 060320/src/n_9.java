import java.util.Arrays;
import java.util.Scanner;
public class n_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, num;

        System.out.print("Enter the length of the array >> ");
        n = sc.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number in array >> ");
            num = sc.nextInt();
            x[i] = num;
        }
        int shift[] = new int[n];
        for (int i = 1; i < n; i++) {
            shift[i] = x[i-1];
        }
        shift[0] = x[n-1];
        System.out.print(Arrays.toString(shift));
    }
}
