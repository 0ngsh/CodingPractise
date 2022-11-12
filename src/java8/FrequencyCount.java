package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCount {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,3,1,2,4,4,2,1,4,5,6,4,3);
        Map<Integer, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
                       

        for (Map.Entry<Integer, Long> entry: frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        }
}
