public final class LevenshteinDistance
{
    static int[][] distanceGrid;
    static char[] stringAchars; // rows
    static char[] stringBchars; // columns

    private LevenshteinDistance() {
        // empty constructor
    }

    public static int calculateDistance(String stringA, String stringB) {
        if (stringA.length() == 0 || stringB.length() == 0) {
            return -1;
        }

        stringAchars = stringA.toLowerCase().toCharArray();
        stringBchars = stringB.toLowerCase().toCharArray();
        distanceGrid = new int[stringA.length()][stringB.length()];

        int i = 0;
        int j = 0;
        int edge = 0;

        if (stringAchars[i] == stringBchars[j]) {
            distanceGrid[0][0] = 0;
        } else {
            distanceGrid[0][0] = 1;
        }

        for (i = 1; i < stringAchars.length; i++) {
            distanceGrid[i][0] = i;
        }

        for (j = 1; j < stringBchars.length; j++) {
            distanceGrid[0][j] = j;
        }

        for (i = 1; i < stringAchars.length; i++) {
            for (j = 1; j < stringBchars.length; j++) {
                if (stringAchars[i] == stringBchars[j]) {
                    edge = 0;
                } else {
                    edge = 1;
                }
                distanceGrid[i][j] = getMin(distanceGrid[i][j-1], distanceGrid[i-1][j], distanceGrid[i-1][j-1]) + edge;
            }
        }
        return distanceGrid[stringAchars.length-1][stringBchars.length-1];
    }

    private static int getMin(int i, int j, int k) {
        int min = Integer.MIN_VALUE;
        if (i < j) {
            min = i;
        } else {
            min = j;
        }

        if (k < min) {
            return k;
        } else {
            return min;
        }
    }

    public static void gridToString() {
        System.out.print("-");
        for (int k = 0; k < stringBchars.length; k++) {
            System.out.print(stringBchars[k]);
        }
        System.out.println();
        for (int i = 0; i < stringAchars.length; i++) {
            System.out.print(stringAchars[i]);
            for (int j = 0; j < stringBchars.length; j++) {
                System.out.print(distanceGrid[i][j]);
            }
            System.out.println();
        }

    }
}
