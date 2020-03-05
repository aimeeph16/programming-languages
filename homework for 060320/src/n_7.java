import java.util.Arrays;
import java.util.Scanner;
public class n_7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int limit = 10;
        String num;
        String[] list1 = new String[5];
        String[] list2 = new String[5];
        String x[] = new String[limit];

        for (int i = 0; i < limit; i++) {
            System.out.print("Enter elements in array >> ");
            num = sc.next();
            x[i] = num;
        }
        for (int i = 0, j = 5; i<5 & j<limit; i++, j++){
            list1[i] = x[i];
            list2[i] = x[j];
        }
        System.out.println("list 1: " + Arrays.toString(list1));
        System.out.println("list 2: " + Arrays.toString(list2));
    }
}
