import java.util.*;

public class PaternityTest {
    public static int[] possibleFather(String child, String mother, String father) {
        List motherMatches = new ArrayList();
        List notMotherMatches = new ArrayList();

        int idx = 0;

        for (int i = 0; i < child.length(); i++) {
            if (mother.charAt(i) == child.charAt(i)) {
                motherMatches.add(i);
                idx++;
            } else {
                notMotherMatches.add(i);
            }
        }

        int excess = motherMatches.size() - child.length()/2;
        if (excess == 0) {
            findMatch(child, father, notMotherMatches);
        } else {
            List permutations = new ArrayList();
            PaternityTest.findGeneticPermutations(motherMatches, notMotherMatches, permutations);
        }

        findMatch(new int[child.length()/2], child, father, excess, permutations);
    }

    public static void findGeneticPermutations(int[] sequence, List motherMatches, List notMotherMatches, int choose, List permutations) {
        if (choose == 0) {
            permutations.add(concatArray(sequence, notMotherMatches.toArray(new int[notMotherMatches.size()])));
        } else if (choose == 1 && str.length() == 1) {
            System.out.println(prefix+str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permutation(prefix + str.charAt(i), str.substring(i+1), choose-1);
            }
        }
    }

    public static int[] concatArray(int[] array1, int[] array2) {
        int[] combinedArray = new int[array1.length + array2.length];

        int idx = 0;
        for (int i : array1) {
            combinedArray[idx] = i;
            idx++;
        }

        for (int j : array2) {
            combinedArray[idx] = j;
            idx++;
        }

        return combinedArray;
    }

}
