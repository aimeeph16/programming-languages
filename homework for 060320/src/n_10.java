import java.util.Arrays;
import java.util.Scanner;
public class n_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, num;
        int temp = 0;

        System.out.print("Enter the length of the array >> ");
        n = sc.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number in array >> ");
            num = sc.nextInt();
            x[i] = num;
        }
        for (int i=0; i<(n-1); i++) {
            for (int j=0; j<(n-1-i); j++) {
                if (x[j] > x[j + 1]) {
                    temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
        for (int i=0; i<n; i++){
            System.out.print(x[i]);
        }
    }
}
