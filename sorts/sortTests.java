import java.util.function.*;
import java.util.*;


public class sortTests {
    public static void main(String[] args) {
        testSort(args, Sort::bubbleSort, "Bubble Sort");
        testSort(args, Sort::selectionSort, "Selection Sort");
        testSort(args, Sort::insertionSort, "Insertion Sort");
        testSort(args, Sort::shellSort, "Shell Sort");
        testSort(args, Sort::mergeSort, "Merge Sort");
    }

    public static void testSort(String[] args, Function<int[], int[]> sortFunc, String name) {
        ArrayList<int[]> testCases = new ArrayList<int[]>();
        Random rdm = new Random();
        int n = Integer.parseInt(args[0]);
        int i = 0;
        int failures = 0;
        boolean verbose = true;

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
            int[] unsortedArray = new int[rdmSize];

            for (int j = 0; j < unsortedArray.length - 1; j++) {
                unsortedArray[j] = rdm.nextInt(30);
            }
            testCases.add(unsortedArray);
        }

        for (int[] unsortedArray : testCases) {
            int[] sortedArray = null;
            if (verbose) {
                System.out.println("The unsorted array is: " + Arrays.toString(unsortedArray));
                System.out.println();
            }
            sortedArray = sortFunc.apply(unsortedArray.clone());
            if (verbose) { System.out.println(name + ": " + Arrays.toString(sortedArray)); }
            if (!Sort.validate(unsortedArray, sortedArray, verbose)) { failures++; }
        }

        if (!verbose) { System.out.println(name + " had " + failures + " FAILURES."); }
        else { System.out.println("There were " + failures + " FAILURES."); }
    }
}
