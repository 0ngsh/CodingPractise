package java8;

import java.util.stream.IntStream;

public class StreamExperiment {
    
    public static void main(String[] args) {

IntStream.range(1, 100).skip(1).filter(x->isPrime(x)).forEach(System.out::println);
IntStream.range(1, 100).map(null).collect(null, null, null);

int[] a ={2,3,5,5,3,3,6};

}

public static boolean isPrime(int number) {
    return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
}
//Boxed method https://howtodoinjava.com/java8/java8-boxed-intstream/
//Collector

}