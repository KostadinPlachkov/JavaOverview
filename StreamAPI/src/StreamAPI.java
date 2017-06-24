import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {

        // Stream
        List<Integer> numbers = new ArrayList<>(Arrays.asList(15, 2, 78, 13, 14, 79, 5, 1, 5));
        System.out.println(numbers);
        numbers.stream()
                .distinct()  // Uses only the unique values. Like Set.
                .filter(x -> 10 <= x && x <= 20)  // Filter
                .limit(2)  // Takes only x values from the collection
                .forEach(System.out::println);  // For each it prints it.


        List<Integer> ages = new ArrayList<>(Arrays.asList(15, 25, 48, 62, 27, 37));
        System.out.println(ages);
        ages.stream()
                .filter(a -> a > 18)
                .peek(a -> System.out.println("Above 18: " + a))
                .filter(a -> a > 30)
                .forEach(a -> System.out.println("Above 30: " + a));


        String string = "lower case to upper";
        Arrays.stream(string.split("\\s+"))
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // Collectors
        List<Integer> nums = new ArrayList<>(Arrays.asList(15, 25, -48, 62, -27, 37));
        System.out.println(nums);
        int numbersToSkip = 3;
        List<Integer> result = nums.stream()
                .skip(numbersToSkip)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Removes the first " + numbersToSkip + " elements, result: " + result);


        System.out.println(nums);
        Map<Boolean, List<Integer>> collectionNums =
                nums.stream()
                .collect(Collectors.partitioningBy(num -> num >= 0));
        System.out.println(collectionNums);


        List<String> names = new ArrayList<>(Arrays.asList("Maria", "Maya", "Albena"));
        System.out.println(names);
        Map<Integer, List<String>> collectionNames =
                names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(collectionNames);


        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Gosho", new ArrayList<>(Arrays.asList("Ivan", "Maria")));
        friends.put("Peter", new ArrayList<>(Arrays.asList("Jonny", "Simon")));
        System.out.println(friends);
        List<String> friendsOfFriends = friends
                .entrySet()  // The entry
                .stream()
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.toList());
        System.out.println(friendsOfFriends);

    }
}
