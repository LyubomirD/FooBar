package Solutions;

public class BrailleTranslator {

    public static void main(String[] args) {
        System.out.println(solution("The quick brown fox jumps over the lazy dog"));
    }

    public static String solution(String s) {
        StringBuilder output = new StringBuilder();
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String[] brailleAlphabet = new String[]{"100000", "110000", "100100", "100110", "100010", "110100", "110110", "110010", "010100", "010110", "101000", "111000", "101100", "101110", "101010", "111100", "111110", "111010", "011100", "011110", "101001", "111001", "010111", "101101", "101111", "101011"};
        String upperLetter = "000001";
        String space = "000000";

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                output.append(upperLetter);
                c = Character.toLowerCase(c);
            }

            if (c == ' ') {
                output.append(space);
            }

            for(int j = 0; j < alphabet.length; ++j) {
                if (c == alphabet[j]) {
                    output.append(brailleAlphabet[j]);
                }
            }
        }

        return output.toString();
    }
}

