import java.util.Scanner;

public class driver_1 {
    public static void main(String[] args) {
        utility u = new utility();
        int len = u.arrayLength();
        int x[] = new int[len];

        u.inputValues(x, len);
        int largest = u.findLargest(x, len); //checks for the largest number

        int pos = u.index(x, largest);
        x[pos] = 0;     //the largest is turned to 0 in order to find the second largest

        int secondL = u.findLargest(x, len);
        int add = largest - secondL;

        for (int i=0; i<pos; i++){
            System.out.print(x[i]);     //prints out the elements from the start up to the position of the largest element
        }
        System.out.print(secondL);      //prints out the second largest, as well as the additive element
        System.out.print(add);
        for (int i=pos+1; i<len; i++){
            System.out.print(x[i]);     //prints out the rest of the elements
        }
    }
}

