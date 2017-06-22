import java.util.Random;
import java.util.function.*;

public class FunctionalProgramming {
    public static void main(String[] args) {

        // Consumer<T>
        Consumer<String> print = string -> System.out.println(string);
        print.accept("Message from consumer func");

        // Supplier<T>
        Supplier<Integer> getRandomNumber =
                () -> new Random().nextInt(42);
        print.accept("Random number: " + getRandomNumber.get().toString());

        // Predicate<T> -> bool
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(
                "Is the random number even: " + isEven.test(getRandomNumber.get())
        );

        // BiFunction<T, U, R>
        BiFunction<Integer, Integer, String> sum =
                (x, y) -> "The sum of " + x + " and " + y + " is " + (x + y);
        System.out.println(sum.apply(5, 9));
    }
}
