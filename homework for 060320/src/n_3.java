import java.util.Arrays;
import java.util.Scanner;
public class n_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int limit = 20;
        int x[] = new int[limit];
        int num;

        for (int i = 0; i < limit; i++) {
            System.out.print("Enter number >> ");
            num = sc.nextInt();
            x[i] = num;
        }

        int pos = 0;
        int neg = 0;
        int od = 0;
        int ev = 0;
        int z = 0;

        for (int k = 0; k < limit; k++) {
            if (x[k] > 0) {
                pos++;
            } else if (x[k] < 0) {
                neg++;
            } else {
                z++;
            }
            if (x[k] % 2 == 0) {
                ev++;
            }
            if (x[k] % 2 != 0) {
                od++;
            }
        }
        System.out.println("positive integers: " + pos);
        System.out.println("negative integers: " + neg);
        System.out.println("odd integers: " + od);
        System.out.println("even integers: " + ev);
        System.out.println("zero's: " + z);
    }
}
