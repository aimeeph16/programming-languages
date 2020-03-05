import java.util.Arrays;
import java.util.Scanner;
public class n_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l;
        String letters;

        System.out.print("Enter the length of the array >> ");
        l = sc.nextInt();
        String x[] = new String[l];
        for (int i = 0; i < l; i++) {
            System.out.print("Enter elements in array >> ");
            letters = sc.next();
            x[i] = letters;
        }

        int i,j;
        String forward = "";
        String backward = "";
        for (i = 0, j = l-1; (i < l & j >= 0); i++, j--) {
            forward += x[i];
            backward += x[j];
        }
        if (!forward.equals(backward)) {
            System.out.println("not a palindrome");
        }
        else{
            System.out.println("it is a palindrome");
        }
    }
}
