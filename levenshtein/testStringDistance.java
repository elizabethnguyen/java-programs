public class testStringDistance {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Insufficient arguments!");
            return;
        }

        String stringA = args[0];
        String stringB = args[1];

        System.out.println("The distance between '" + stringA + "' and '" + stringB + "' is " + LevenshteinDistance.calculateDistance(stringA, stringB) + ".");
        System.out.println();
        LevenshteinDistance.gridToString();
    }
}
