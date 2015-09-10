import java.util.*;
public class referenceTest {
    public static void main(String args[]) {
        String x = null;
        int[] array = new int[]{1, 2};
        blah(array);
        //giveMeAString(x);
        //System.out.println(x);
        System.out.println(Arrays.toString(array));
    }

    static void giveMeAString(String y) {
        y = "dog";
    }

    static void blah(int[] stuff) {
        stuff[0] = -5;
    }
}
