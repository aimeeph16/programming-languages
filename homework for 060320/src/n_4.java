import java.util.Arrays;
import java.util.Scanner;
public class n_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l, num;
        int sum = 0;
        int prod = 0;

        System.out.print("Enter the length of the array >> ");
        l = sc.nextInt();
        int x[] = new int[l];
        for (int i = 0; i < l; i++) {
            System.out.print("Enter number in array >> ");
            num = sc.nextInt();
            x[i] = num;
        }

        for(int i = 0; i < l; i++)
        {
            sum = sum + x[i];

            if(i == 0){
                prod = x[i];
            }
            else{
                prod = prod * x[i];
            }
        }
        System.out.println("Sum:" + sum);
        System.out.println("Product:" + prod);
    }

}
