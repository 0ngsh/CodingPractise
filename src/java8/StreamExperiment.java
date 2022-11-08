package java8;

import java.util.stream.IntStream;

public class StreamExperiment {
    
    public static void main(String[] args) {

IntStream.range(2, 100).filter(x->isPrime(x)).forEach(System.out::println);
    }

public static boolean isPrime(int number) {
    return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
}


}