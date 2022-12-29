import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //Create the algorithm

        /*

        1. Locate the begining (
        2. Locate the ending )
        3. Cut the string in new variable
        4. Implement reverse algoritm
        5. Concatenate the String

         */

        String input = "abcd(efg)ijk(lmn)hijk";
        StringBuilder sb;
        System.out.println("O:" + input);

        if (input.contains("(")) {
            //Regex
            List<String> matchList = new ArrayList<>();
            Pattern regex = Pattern.compile("\\((.*?)\\)");

            Matcher regexMatcher = regex.matcher(input);

            while (regexMatcher.find()) {//Finds Matching Pattern in String
                String o = regexMatcher.group(1);
                String r = reverse(o);

                int s = regexMatcher.start();
                int e = regexMatcher.end();

                sb = new StringBuilder();
                sb.append(input.substring(0, s + 1));
                sb.append(r);
                sb.append(input.substring(e - 1));

                input = sb.toString();
            }
        } else {
            System.out.println("R:" + input);
        }
        System.out.println("R:" + input);

    }

    public static String reverse(String str) {
        //reverse
        String n = "";
        char ch;

        for (int r = 0; r < str.length(); r++) {
            ch = str.charAt(r);
            n = ch + n;
        }

        return n;
    }




    /*
    input -> abcd(efg)ijklmnhijk
    output -> abcd(gfe)ijklmnhijk
    input -> abcd(efg)ijk(lmn)hijk
    output -> abcd(gfe)ijk(nml)hijk
    input -> abcd
    output -> abcd
    input -> (abcd)
    output -> (dcba)

     */
}