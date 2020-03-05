import java.util.Arrays;
import java.util.Scanner;
public class n_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int limit = 10;
        int x[] = new int[limit];
        int num;

        for(int i=0; i<limit; i++){
            System.out.print("Enter number >> ");
            num = sc.nextInt();
            x[i] = num;
        }

        System.out.println(Arrays.toString(x));

    }
}

