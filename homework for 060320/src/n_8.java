import java.util.Arrays;
import java.util.Scanner;
public class n_8 {
    public static int index(int arr[], int t) {
        if (arr == null) {
            return -1;
        }

        int len = arr.length;
        int i = 0;

        while (i < len) {
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

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

        int largest = x[0];
        for (int i = 1; i < n; i++) {
            if (x[i]>largest){
                largest = x[i];
            }
        }
        int pos = index(x, largest);
        x[pos] = 0;

        int second = x[0];
        for (int i = 1; i < n; i++) {
            if (x[i]>second){
                second = x[i];
            }
        }
        int add = largest - second;

        int list1[] = new int[pos+1];
        int list2[] = new int[n-pos];
        list1[pos] = second;
        list2[0] = add;

        for (int i=0, j=pos+1; i<pos & j<n; i++, j++){
            list1[i] = x[i];
        }
        for (int j=pos+1, k=1; j<n & k<n-pos; j++, k++){
            list2[k] = x[j];
        }

        for (int i=0; i<list1.length; i++){
            System.out.print(list1[i]);
        }
        for (int j=0; j<list2.length; j++){
            System.out.print(list2[j]);
        }
    }
}
