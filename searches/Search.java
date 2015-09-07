import java.util.*;

public final class Search {

    private Search() {
        // blank constructor
    }

    public static boolean validate(int[] data, int targetVal, int resultIdx, boolean verbose) {
        boolean status = true;
        boolean numberExists = searchArray(data, targetVal, resultIdx);

        if (verbose) {
            System.out.println("-----------------------------");
            System.out.println("Target number: " + targetVal);
            System.out.println("Result Position: " + resultIdx);
            System.out.print("Result: ");
        }
        if (resultIdx == -1) {
            if (numberExists) {
                if (verbose) {
                    System.out.println("search could not find the target number!");
                }
                status = false;
            } else {
                if (verbose) {
                    System.out.println("search confirmed that the target number does not exist!");
                }
            }
        } else {
            if (numberExists) {
                if (verbose) {
                    System.out.println("search found " +
                                       targetVal + " at index " + resultIdx);
                }
            } else {
                if (verbose) {
                    System.out.println("search found " +
                                       targetVal + " at the wrong index (" + resultIdx + ")");
                }
                status = false;
            }
        }

        if (status == true) {
            if (verbose) {
                System.out.println("PASS");
            }
        } else {
            if (verbose) {
                System.out.println("FAIL");
            }
        }

        if (verbose) {
            System.out.println("-----------------------------");
            System.out.println();
        }

        return status;
    }

    private static boolean searchArray(int[] data, int targetVal, int resultIdx) {
        if (resultIdx == -1) {
            for (int i = 0; i < data.length; i++) {
                if (targetVal == data[i]) { return true; }
            }
            return false;
        } else {
            if (data[resultIdx] == targetVal) { return true; }
        }

        return false;
    }

    public static int recursiveBinarySearch(int[] data, int targetNum) {
        if (data == null) { return -1; }
        if (data.length < 1) { return -1; }

        Arrays.sort(data);

        int leftIdx = 0;
        int rightIdx = data.length-1;

        return recursiveBinarySearch(data, leftIdx, rightIdx, targetNum);
    }

    public static int recursiveBinarySearch(int[] data, int leftIdx, int rightIdx, int targetNum) {
        int middleIdx = (rightIdx - leftIdx) / 2 + leftIdx;

        if (rightIdx < leftIdx) { return -1; }

        if (targetNum == data[middleIdx]) { return middleIdx; }
        else if (targetNum < data[middleIdx]) { return recursiveBinarySearch(data, leftIdx, middleIdx-1, targetNum); }
        else { return recursiveBinarySearch(data, middleIdx+1, rightIdx, targetNum); }
    }

    public static int iterativeBinarySearch(int[] data, int targetNum) {
        if (data == null) { return -1; }
        if (data.length < 1) { return -1; }

        Arrays.sort(data);

        int leftIdx = 0;
        int rightIdx = data.length-1;

        while (rightIdx >= leftIdx) {
            int middleIdx = (rightIdx - leftIdx) / 2 + leftIdx;
            if (targetNum == data[middleIdx]) {
                return middleIdx;
            } else if (targetNum < data[middleIdx]) {
                rightIdx = middleIdx-1;
            } else {
                leftIdx = middleIdx+1;
            }
        }

        return -1;
    }

    public static int iterativeLinearSearch(int[] data, int targetNum) {
        if (data == null) { return -1; }
        if (data.length < 1) { return -1; }

        for (int i = 0; i < data.length; i++) {
            if (data[i] == targetNum) {
                return i;
            }
        }
        return -1;
    }

    public static int recursiveLinearSearch(int[] data, int targetNum) {
        if (data == null) { return -1; }
        if (data.length < 1) { return -1; }

        int leftIdx = 0;
        return recursiveLinearSearch(data, targetNum, leftIdx);
    }

    public static int recursiveLinearSearch(int[] data, int targetNum, int leftIdx) {
        if (leftIdx >= data.length) {
            return -1;
        } else if (data[leftIdx] == targetNum) {
            return leftIdx;
        } else {
            return recursiveLinearSearch(data, targetNum, ++leftIdx);
        }
    }
}
