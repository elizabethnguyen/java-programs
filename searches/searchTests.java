import java.util.function.*;
import java.util.*;


public class searchTests {
    @FunctionalInterface
    interface SearchFunction<A, B, R> {
        public R apply(A one, B two);
    }

    public static void main(String[] args) {
        testSearch(args, Search::recursiveBinarySearch, "Recursive Binary Search");
        testSearch(args, Search::iterativeBinarySearch, "Iterative Binary Search");
        testSearch(args, Search::iterativeLinearSearch, "Iterative Linear Search");
        testSearch(args, Search::recursiveLinearSearch, "Recursive Linear Search");
    }

    public static void testSearch(String[] args, SearchFunction<int[], Integer, Integer> searchFunc, String name) {
        ArrayList<int[]> testCases = new ArrayList<int[]>();
        Random rdm = new Random();
        int n = Integer.parseInt(args[0]);
        int i = 0;
        int failures = 0;
        boolean verbose = true;
        int targetNum = 0;

        if (args.length > 1) {
            if (args[1].equals("true")) { verbose = true; } else { verbose = false; }
        }

        testCases.add(new int[]{});
        testCases.add(new int[]{0});
        testCases.add(new int[]{1, 1});
        testCases.add(new int[]{1, 2});
        testCases.add(new int[]{2, 1});
        testCases.add(new int[]{1, 1, 1});
        testCases.add(new int[]{1, 2, 3});
        testCases.add(new int[]{3, 2, 1});
        testCases.add(new int[]{2, 1, 3});
        testCases.add(new int[]{3, 1, 2});
        testCases.add(new int[]{-1});
        testCases.add(new int[]{-1, 1});
        testCases.add(new int[]{-1, -1});
        testCases.add(new int[]{1, -1});
        testCases.add(new int[]{-2, -1});
        testCases.add(new int[]{-1, -2});
        testCases.add(new int[]{1, -1, 1});
        testCases.add(new int[]{-1, -1, -1});
        testCases.add(new int[]{-1, -2, -3});
        testCases.add(new int[]{-3, -2, -1});
        testCases.add(new int[]{-2, -1, -3});
        testCases.add(new int[]{-3, -1, -2});
        testCases.add(new int[]{0, -1, 0, -1});
        testCases.add(new int[]{0, -1, 0, 1, 0});

        for (i = 0; i < n; i++) {
            int rdmSize = rdm.nextInt(15);
            int[] unsearchedArray = new int[rdmSize];

            for (int j = 0; j < unsearchedArray.length - 1; j++) {
                unsearchedArray[j] = rdm.nextInt(30);
            }
            testCases.add(unsearchedArray);
        }

        for (int[] unsearchedArray : testCases) {
            if (unsearchedArray.length > 1) {
                targetNum = rdm.nextInt(unsearchedArray.length-1);
            } else if (unsearchedArray.length == 1) {
                targetNum = unsearchedArray[0];
            }
            if (verbose) {
                System.out.println("The unsearched array is: " + Arrays.toString(unsearchedArray));
            }
            int resultPosition = searchFunc.apply(unsearchedArray, targetNum);
            if (verbose) {
                System.out.println("The sorted array is: " + Arrays.toString(unsearchedArray));
            }
            if (!Search.validate(unsearchedArray, targetNum, resultPosition, verbose)) { failures++; }
        }

        for (int[] unsearchedArray : testCases) {
            if (verbose) {
                System.out.println("The unsearched array is: " + Arrays.toString(unsearchedArray));
            }
            int resultPosition = searchFunc.apply(unsearchedArray, Integer.MAX_VALUE);
            if (verbose) {
                System.out.println("The sorted array is: " + Arrays.toString(unsearchedArray));
            }
            if (!Search.validate(unsearchedArray, Integer.MAX_VALUE, resultPosition, verbose)) { failures++; }
        }

        if (!verbose) { System.out.println(name + " had " + failures + " FAILURES."); }
        else { System.out.println("There were " + failures + " FAILURES."); }
    }
}
