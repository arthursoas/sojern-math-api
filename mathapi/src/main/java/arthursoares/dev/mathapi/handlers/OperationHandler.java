package arthursoares.dev.mathapi.handlers;

import arthursoares.dev.mathapi.models.NumberList;
import arthursoares.dev.mathapi.models.QuantifiableNumberList;
import java.util.Collections;
import java.util.List;

public class OperationHandler {
    public static List<Long> getMinNumbers(QuantifiableNumberList quantifiableNumberList)
    {
        Collections.sort(quantifiableNumberList.numbers);
        
        return quantifiableNumberList.numbers.subList(0,
            quantifiableNumberList.quantifier);
    }
    
    public static List<Long> getMaxNumbers(QuantifiableNumberList quantifiableNumberList)
    {
        Collections.reverse(quantifiableNumberList.numbers);
        
        return quantifiableNumberList.numbers.subList(0,
            quantifiableNumberList.quantifier);
    }
    
    public static Double getNumbersAverage(NumberList numberList)
    {
        var sum = numberList.numbers.stream().reduce((long) 0, (a, b) -> a + b);
        
        return sum * 1.0 / numberList.numbers.size();
    }
    
    public static Double getNumbersMedian(NumberList numberList)
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
}
