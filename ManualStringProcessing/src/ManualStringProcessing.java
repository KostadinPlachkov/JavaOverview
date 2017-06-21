import java.util.Scanner;

public class ManualStringProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 3 numbers: ");
        float num1 = scanner.nextFloat();
        float num2 = scanner.nextFloat();
        float num3 = scanner.nextFloat();
        // Format
        String result1 = String
                .format("%1$-10s | %2$7s | %3$-4s", num1, num2, num3);
        String result2 = String
                .format("%1$.2f | %2$.5f | %3$.7f", num1, num2, num3);
        System.out.println(result1);
        System.out.println(result2);

        String cleanResult = result1.trim(); // Trims whitespace at start and end of the string

        boolean startsWithNum1 = result1.startsWith("1.0");
        boolean endsWithNum0 = result2.endsWith("0");
        System.out.format("Starts with 1.0: %s\n", startsWithNum1);
        System.out.format("Ends with 0: %s\n", endsWithNum0);

        // Substring
        String email = "example@gmail.com";
        int index = 8;
        Integer index1 = email.indexOf("e");
        Integer index2 = email.indexOf("q");
        Integer index3 = email.indexOf("e", index);
        System.out.println(email);
        System.out
                .format("Index of 'e': %s, Index of 'q': %s, Index of 'e' from index %d: %s\n", index1, index2, index, index3);
        System.out.format("Substring: %s\n", email.substring(5, 9));

        // Compare
        String str1 = "abc";
        String str2 = "abc";
        System.out.format("Compare abc to abc: %b\n", str1.compareTo(str2));

        // StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Text from sb");  // Adds text
        System.out.println(stringBuilder);
        stringBuilder.insert(5, "*inserted text*");  // Inserts text
        System.out.println(stringBuilder);
        stringBuilder.replace(5, stringBuilder.length(),"replaced!");  // Replace text
        System.out.println(stringBuilder);
        stringBuilder.reverse();  // Reverses the string
        System.out.println(stringBuilder);



    }
}
