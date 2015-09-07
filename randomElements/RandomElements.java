// http://rafal.io/posts/assorted-notes.html

import java.util.*;
public class RandomElements {
    public static void main(String[] args) {
        int[] stream = new int[1000];
        for (int i = 0; i < stream.length; i++) {
            stream[i] = i;
        }

        int[] randomInts = generateFromStream(stream);

        System.out.println(Arrays.toString(randomInts));
    }

    public static int[] generateDistinctUniform(int m, int n) {
        Random rdm = new Random();
        int[] result = new int[m];
        int toSelect = m; // how many distinct elements to select
        int remaining = n; // remaining possibilities of numbers to select

        for (int i = 0; i < n; i++) {
            if ((1 + rdm.nextInt(remaining)) <= toSelect) {
                result[toSelect-1] = i;
                toSelect--;
            }
            remaining--;
        }
        return result;
    }

    private static void swap(int[] data, int idxA, int idxB) {
        int temp = data[idxA];
        data[idxA] = data[idxB];
        data[idxB] = temp;
    }

    public static void shuffle(int[] data) {
        Random rdm = new Random();
        for (int i = 0; i < data.length; i++) {
            swap(data, i, rdm.nextInt(data.length-1) + 1);
        }
    }

    public static int[] generateDistinctRandom(int m, int n) {
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        shuffle(numbers);

        int[] result = Arrays.copyOfRange(numbers, 0, m);
        return result;
    }

    public static boolean probability(Random rdm, int numerator, int denominator) {
        int result = rdm.nextInt(denominator) + 1;
        return result <= numerator;
    }

    public static int[] generateFromStream(int[] stream) {
        Random rdm = new Random();
        int p = 1;
        int resultSize = 0;
        int[] result = new int[stream.length];
        for (int i = 0; i < stream.length; i++) {
            if (probability(rdm, 1, p)) {
                result[resultSize] = stream[i];
                resultSize++;
                p++;
            }
        }
        int[] trimmedResult = new int[resultSize];
        System.arraycopy(result, 0, trimmedResult, 0, resultSize);

        return trimmedResult;
    }
}
