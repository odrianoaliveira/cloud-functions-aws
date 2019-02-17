package tech.adriano.cloudfunctions.fn;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FactorialFn {

    public static Function<Integer, Integer> factorial() {
        return number -> IntStream.rangeClosed(2, number).reduce(1, (x, y) -> x * y);
    }
}
