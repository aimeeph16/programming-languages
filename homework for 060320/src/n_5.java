import java.util.Arrays;
import java.util.Scanner;
public class n_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l, num;

        System.out.print("Enter the length of the array >> ");
        l = sc.nextInt();
        int x[] = new int[l];
        for (int i = 0; i < l; i++) {
            System.out.print("Enter number in array >> ");
            num = sc.nextInt();
            x[i] = num;
        }

        int big = x[0];
        int smol = x[0];
        for (int i = 1; i < l; i++) {
            if (x[i]>big){
                big = x[i];
            }
            else if (x[i]<smol){
                smol = x[i];
            }
        }
        System.out.println("biggest number: " + big);
        System.out.println("smallest number: " + smol);
    }
}
