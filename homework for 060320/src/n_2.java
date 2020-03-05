import java.util.Scanner;
public class n_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = 10;
        int x[] = new int[limit];
        int num;

        for (int i = 0; i < limit; i++) {
            System.out.print("Enter number >> ");
            num = sc.nextInt();
            x[i] = num;
        }
        System.out.print("Enter number to check >> ");
        int check = sc.nextInt();

        int k = 0;
        int i = 0;
        while (i < limit) {
            if (x[i] == check) {
                k += 1;
                break;
            }
            else {
                i = i + 1;
            }
        }

        if (k==1){
            System.out.print("your number is present in the array.");
        }
        else{
            System.out.print("your number is not found.");
        }
    }
}
