public final class Ordering {
    private Ordering() {
        // empty constructor
    }
    public static void permutation(String str) {
        permutation("", str);
    }

    public static void permutation(String prefix, String str) {
        if (str.length() == 1) {
            System.out.println(prefix+str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
            }
        }
    }

    public static void combination(String str, int choose) {
        combination("", str, choose);
    }

    public static void combination(String prefix, String str, int choose) {
        if (choose == 0) {
            System.out.println(prefix);
        } else if (choose == 1 && str.length() == 1) {
            System.out.println(prefix+str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                combination(prefix + str.charAt(i), str.substring(i+1), choose-1);
            }
        }
    }
}
