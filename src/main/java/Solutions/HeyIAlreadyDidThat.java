package Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HeyIAlreadyDidThat {

    public static void main(String[] args) {

        System.out.println(solution("1211", 10));
        System.out.println(solution("210022", 3));

    }

    public static int solution(String n, int b) {
        int k = n.length();

        Set<String> visitedMinionID = new HashSet<>();
        while (!visitedMinionID.contains(n)) {
            visitedMinionID.add(n);
            n = nextMinion(n, k, b);
        }

        return cycleThroughtLength(n, k, b);
    }

    private static int cycleThroughtLength(String n, int k, int b) {

        HashSet<String> addID = new HashSet<>();
        int res = 0;
        while (!addID.contains(n)) {
            addID.add(n);
            n = nextMinion(n, k, b);
            res++;
        }
        return res;
    }

    private static String nextMinion(String n, int k, int b) {

        char[] descendingOrderX = n.toCharArray();
        char[] ascendingOrderY = n.toCharArray();

        Arrays.sort(descendingOrderX);
        for (int i = 0; i < descendingOrderX.length / 2; i++) {
            char t = descendingOrderX[i];
            descendingOrderX[i] = descendingOrderX[descendingOrderX.length - 1 - i];
            descendingOrderX[descendingOrderX.length - 1 - i] = t;
        }
        String n1 = String.copyValueOf(descendingOrderX);

        Arrays.sort(ascendingOrderY);
        String n2 = String.copyValueOf(ascendingOrderY);

        int res = Integer.parseInt(n1, b) - Integer.parseInt(n2, b);
        String ret = Integer.toString(res, b);

        return "0".repeat(Math.max(0, k - ret.length())) + ret;
    }
}
