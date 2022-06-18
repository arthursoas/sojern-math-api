package arthursoares.dev.mathapi.handlers;

import arthursoares.dev.mathapi.models.requests.Numbers;
import arthursoares.dev.mathapi.models.requests.QuantifiableNumbers;
import java.util.Collections;
import java.util.List;

public class OperationHandler {
    public static List<Double> getMinNumbers(QuantifiableNumbers quantifiableNumberList)
    {
        Collections.sort(quantifiableNumberList.numbers);
        
        return quantifiableNumberList.numbers.subList(0,
            quantifiableNumberList.quantifier);
    }
    
    public static List<Double> getMaxNumbers(QuantifiableNumbers quantifiableNumberList)
    {
        Collections.reverse(quantifiableNumberList.numbers);
        
        return quantifiableNumberList.numbers.subList(0,
            quantifiableNumberList.quantifier);
    }
    
    public static Double getNumbersAverage(Numbers numberList)
    {
        var sum = numberList.numbers.stream().reduce(0.0, (a, b) -> a + b);
        
        return sum * 1.0 / numberList.numbers.size();
    }
    
    public static Double getNumbersMedian(Numbers numberList)
    {
        Collections.sort(numberList.numbers);
        var listSize = numberList.numbers.size();
        var isListSizeEven = listSize % 2 == 0;
        
        if (isListSizeEven)
        {
            return (numberList.numbers.get(listSize/2) + numberList.numbers.get((listSize/2) - 1)) / 2.0;
        }
        
        return numberList.numbers.get(listSize/2) * 1.0;
    }
    
    public static Double getNumbersPercentile(QuantifiableNumbers quantifiableNumberList)
    {
        Collections.sort(quantifiableNumberList.numbers);
        var percentileIndex = (int) Math.round(
                (quantifiableNumberList.numbers.size() *
                        (quantifiableNumberList.quantifier / 100.0)) + .5) - 1;
        
        return quantifiableNumberList.numbers.get(percentileIndex);
    }
}
