import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {

        // Stream<T>
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 15, 2, 78, 13, 14, 79, 5, 1, 5);
        numbers.stream()
                .distinct()  // Uses only the unique values. Like Set.
                .filter(x -> 10 <= x && x <= 20)  // Filter
                .limit(2)  // Takes only x values from the collection
                .forEach(System.out::println);  // For each it prints it.

        HashMap<String, String> hashMap = new HashMap<>();
        Stream<Map.Entry<String, String>> entryStream =
                hashMap.entrySet().stream();
        Stream<String> keys = hashMap.keySet().stream();
        Stream<String> values = hashMap.values().stream();

        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

        // Optional<T>

    }
}
