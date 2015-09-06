public final class Sort {

    private Sort() {
        // blank constructor
    }

    public static boolean validate(int[] oldData, int[] newData, boolean verbose) {
        boolean status = true;

        if (verbose) {
            System.out.println("-----------------------------");
            System.out.print("Is Sorted: ");
        }
        if (Sort.isSorted(newData)) {
            if (verbose) {
                System.out.println("yes");
            }
        } else {
            if (verbose) {
                System.out.println("no");
            }
            status = false;
        }
        if (verbose) {
            System.out.print("Same Length: ");
        }
        if (Sort.sameLength(oldData, newData)) {
            if (verbose) {
                System.out.println("yes");
            }
        } else {
            if (verbose) {
                System.out.println("no");
            }
            status = false;
        }
        if (verbose) {
            System.out.print("Numbers Match: ");
        }
        if (Sort.numbersMatch(oldData, newData)) {
            if (verbose) {
                System.out.println("yes");
            }
        } else {
            if (verbose) {
                System.out.println("no");
            }
            status = false;
        }

        if (verbose) {
            System.out.print("Status: ");
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
        }

        return status;
    }

    public static boolean isSorted(int[] data) {
        if (data == null) { return false; }

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i+1]) { return false; }
        }

        return true;
    }

    public static boolean sameLength(int[] oldData, int[] newData) {
        return oldData.length == newData.length;
    }

    private static int findMax(int[] data) {
        int max = Integer.MIN_VALUE;

        for (int i = data.length-1; i >= 0; i--) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        return max;
    }

    private static int findMin(int[] data) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }

        return min;
    }

    private static boolean hasNegative(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean numbersMatch(int[] oldData, int[] newData) {
        if (oldData.length == 0 && newData.length == 0) { return true; }
        if (sameLength(oldData, newData) == false) { return false; }

        boolean hasNegative = false;
        int max = findMax(newData);

        int[] negCountArray = null;
        int[] countArray = new int[max + 1];
        int i = 0;

        if (hasNegative(newData)) {
            int min = findMin(newData);
            negCountArray = new int[Math.abs(min)+1];
            hasNegative = true;
        }

        for (i = 0; i < oldData.length; i++) {
            if (oldData[i] < 0) { negCountArray[Math.abs(oldData[i])]++; } else { countArray[oldData[i]]++; }
        }
        for (i = 0; i < oldData.length; i++) {
            if (newData[i] < 0) { negCountArray[Math.abs(newData[i])]--; } else { countArray[newData[i]]--; }
        }

        for (i = 0; i < countArray.length; i++ ) {
            if (countArray[i] != 0) { return false; }
        }

        if (hasNegative) {
            for (i = 0; i < negCountArray.length; i++ ) {
                if (negCountArray[i] != 0) { return false; }
            }
        }

        return true;
    }

    public static void swap(int[] data, int idxA, int idxB) {
        int temp = 0;

        temp = data[idxA];
        data[idxA] = data[idxB];
        data[idxB] = temp;
    }

    public static int[] bubbleSort(int[] data) {
        if (data == null) { return null; }
        if (data.length == 1) { return data; }

        boolean hasSwapped = true;
        int temp = 0;

        while (hasSwapped == true) {
            hasSwapped = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i+1]) {
                    swap(data, i, i+1);
                    hasSwapped = true;
                }
            }
        }

        return data;
    }

    public static int[] selectionSort(int[] data) {
        if (data == null) { return null; }
        if (data.length == 1) { return data; }

        for (int i = 0; i < data.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[minIdx] > data[j]) { minIdx = j; }
            }
            swap(data, i, minIdx);
        }

        return data;
    }

    public static int[] insertionSort(int[] data) {
        if (data == null) { return null; }
        if (data.length == 1) { return data; }

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i+1]) {
                for (int j = i; j >= 0; j--) {
                    if (data[j] > data[j+1]) { swap(data, j, j+1); }
                }
            }
        }
        return data;
    }

    public static int[] shellSort(int[] data) {
        if (data == null) { return null; }
        if (data.length == 1) { return data; }
        if (data.length == 0) { return data; }

        boolean running = true;
        int splitSize = data.length / 2;

        while (running) {
            if (splitSize == 1) {
                running = false;
                data = insertionSort(data);
            } else {
                for (int i = 0; i < data.length / 2; i++) {
                    for (int j = i; j < data.length - splitSize; j += splitSize-1) {
                        if (data[j] > data[j+splitSize-1]) {
                            for (int k = j; k >= 0; k-= splitSize-1) {
                                if (data[k] > data[k+splitSize-1]) { swap(data, k, k+splitSize-1); }
                            }
                        }
                    }
                }
                splitSize /= 2;
            }
        }
        return data;
    }
}
