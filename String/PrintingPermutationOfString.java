import java.util.Arrays;

public class PrintingPermutationOfString {
    static void permute(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = new String(chars);

        while (true) {
            System.out.println(str);

            int i = str.length() - 2;
            while (i >= 0 && str.charAt(i) >= str.charAt(i + 1)) {
                i--;
            }

            if (i == -1) {
                break;
            }

            int j = str.length() - 1;
            while (str.charAt(j) <= str.charAt(i)) {
                j--;
            }

            char[] strChars = str.toCharArray();
            char temp = strChars[i];
            strChars[i] = strChars[j];
            strChars[j] = temp;
            str = new String(strChars);

            str = str.substring(0, i + 1) + new StringBuilder(str.substring(i + 1)).reverse().toString();
        }
    }

    public static void main(String[] args) {
        String s = "afjgd";
        permute(s);
    }
}