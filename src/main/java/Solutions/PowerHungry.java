package Solutions;
public class PowerHungry {

    public static void main(String[] args) {

        //test one is 8
        //test two is 60
        //test three is 0
        //test four is ?
        //test five is xs[0]

        int[] array1 = {2, 0, 2, 2, 0}; // 8
        int[] array2 = {-2, -3, 4, -5}; // 60
        int[] array3 = {0}; // 0
        int[] array4 = {1};// 1
        int[] array5 = {0, 2, 2, -4, -2, -2};// 32
        int[] array6 = {0, 0, -8, 0, -1};// 8
        int[] array7 = {-3, 4, -5, -2};// 60
        int[] array8 = {-4};// -4
        int[] array9 = {0, 1};// 1
        int[] array10 = {4, 3, -5, -4, -5, -2, 0, 0, 1, 1, -2};// 2400
        int[] array11 = {0, 0, 0, 0, 0, -4, 0, 0};// -4

        System.out.println(solution(array1));
        System.out.println(solution(array2));
        System.out.println(solution(array3));
        System.out.println(solution(array4));
        System.out.println(solution(array5));
        System.out.println(solution(array6));
        System.out.println(solution(array7));
        System.out.println(solution(array8));
        System.out.println(solution(array9));
        System.out.println(solution(array10));
        System.out.println(solution(array11));
    }

    public static String solution(int[] xs) {
        int length = xs.length;
        int negativeCount = 0;
        int positiveCount = 0;
        int[] negativeArray = new int[length];
        int[] positiveArray = new int[length];
        long output = 1;

        if (length == 1) {
            return String.valueOf(xs[0]);
        }

        for (int number : xs) {
            if (number < 0) {
                negativeArray[negativeCount] = number;
                negativeCount++;
            } else if (number > 0) {
                positiveArray[positiveCount] = number;
                positiveCount++;
            }
        }

        if ((positiveCount == 0 && negativeCount == 0) || (positiveCount == 0 && negativeCount == 1)) {
            return "0";
        }

        if (negativeCount % 2 == 1) {
            int largestNegativeNumber = Integer.MIN_VALUE;
            int largestNegativeIndex = -1;
            for (int i = 0; i < negativeArray.length; i++) {
                if (negativeArray[i] < 0 && negativeArray[i] > largestNegativeNumber) {
                    largestNegativeNumber = negativeArray[i];
                    largestNegativeIndex = i;
                }
            }
            if (largestNegativeIndex != -1) {
                int[] newArray = new int[negativeArray.length - 1];
                int j = 0;
                for (int i = 0; i < negativeArray.length; i++) {
                    if (i != largestNegativeIndex) {
                        newArray[j++] = negativeArray[i];
                    }
                }
                negativeArray = newArray;
                negativeCount--;
            }
        }

        for (int i = 0; i < positiveCount + negativeCount; i++) {
            if (i < positiveCount) {
                output *= positiveArray[i];
            } else {
                output *= negativeArray[i - positiveCount];
            }
        }
        return Long.toString(output);
    }
}