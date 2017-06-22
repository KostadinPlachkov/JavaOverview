import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {

        // \d = [0-9], \w = [a-zA-Z0-9_], \s = white-space
        // \D = [^0-9], \W = [^a-zA-Z0-9_], \S = non white-space
        String regex = "[^eiaoy]";
        String text = "Text with regex and text and more text";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        Integer counter = 0;
        while (matcher.find()) {
            counter++;
        }
        System.out.println("Matches: " + counter);

        // Quantifier
        // + - one or more matches
        // * - zero or more matches
        // ? - zero or one match
        // {min length, max length} - exact quantifier

        regex = "\\d+";
        text = "Text with regex from 2017 and lines 64.";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // Lazy quantifier
        regex = "\".+?\"";
        text = "Text with \"regex\" from \"2017\" and lines 64.";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // Special Characters
        // . - matches any char except for \n
        // | - logical OR
        regex = "\\+359( |-).+";
        text = "+359-999-9999-9999\n+98 8844 4545\n+359 9999 9999 9999";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // Anchors
        // ^ - at the start
        // $ - at the end
        regex = "^\\w{6,20}$";
        text = "maya_lekova ";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        if (matcher.find())
            System.out.format("Valid name: \"%s\"\n", text);
        else
            System.out.format("Invalid name: \"%s\"\n", text);

        // Grouping Constructs
        regex = "(\\d{2})-(\\w{3})-(\\d{4})";
        text = "15-Jan-2017";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        if (matcher.find()){
            System.out.println("Valid date: " + text);
            System.out.println("Date: " + matcher.group(1));
            System.out.println("Month: " + matcher.group(2));
            System.out.println("Year: " + matcher.group(3));
        }
        else
            System.out.println("Invalid date: " + text);

        // Back reference constructs
        regex = "\\d{2}(-|\\/)\\w{3}\\1\\d{4}";
//      regex = "\\d{2}(?<del>-|\\/)\\w{3}\\k<del>\\d{4}";
        text = "15-Jan/2017";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(text);
        if (matcher.find()){
            System.out.println("Valid date: " + text);
        }
        else
            System.out.println("Invalid date: " + text);


    }
}
