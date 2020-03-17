import java.util.Arrays;
public class driver_2 {
    public static void main(String[] args){
        utility u = new utility();
        int len = u.arrayLength();
        int x[] = new int[len];
        u.inputValues(x, len);

        int shift[] = new int[len];
        for (int i = 1; i < len; i++) {
            shift[i] = x[i-1];      //the new array will start at position 1
        }
        shift[0] = x[len-1];    //position 0 will be filled with the last element of the original array
        System.out.print(Arrays.toString(shift));
    }
}
