package arthursoares.dev.mathapi.handlers;

import arthursoares.dev.mathapi.models.requests.Numbers;
import arthursoares.dev.mathapi.models.requests.QuantifiableNumbers;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

public class OperationHandlerTests
{
    @Test
    public void getMinNumbers_whenListIsEmpty_shouldReturnEmptyList()
    {
        // Arrange
        var quantifiableNumbers = new QuantifiableNumbers();
        quantifiableNumbers.numbers = new ArrayList<>();
        quantifiableNumbers.quantifier = 0;
        
        // Act
        var result = OperationHandler.getMinNumbers(quantifiableNumbers);
        
        // Assert
        assertThat(result, hasSize(0));
    }
    
    @Test
    public void getMinNumbers_whenListHasElements_shouldReturnMinElementsFromList()
    {
        // Arrange
        var quantifiableNumbers = new QuantifiableNumbers();
        quantifiableNumbers.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        quantifiableNumbers.quantifier = 2;
        
        // Act
        var result = OperationHandler.getMinNumbers(quantifiableNumbers);
        
        // Assert
        assertThat(result, hasSize(2));
        assertThat(result, contains(1.0, 2.0));
    }
    
    @Test
    public void getMaxNumbers_whenListIsEmpty_shouldReturnEmptyList()
    {
        // Arrange
        var quantifiableNumbers = new QuantifiableNumbers();
        quantifiableNumbers.numbers = new ArrayList<>();
        quantifiableNumbers.quantifier = 0;
        
        // Act
        var result = OperationHandler.getMaxNumbers(quantifiableNumbers);
        
        // Assert
        assertThat(result, hasSize(0));
    }
    
    @Test
    public void getMaxNumbers_whenListHasElements_shouldReturnMaxElementsFromList()
    {
        // Arrange
        var quantifiableNumbers = new QuantifiableNumbers();
        quantifiableNumbers.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        quantifiableNumbers.quantifier = 2;
        
        // Act
        var result = OperationHandler.getMaxNumbers(quantifiableNumbers);
        
        // Assert
        assertThat(result, hasSize(2));
        assertThat(result, contains(5.0, 4.0));
    }
    
    @Test
    public void getNumbersAverage_whenListHasElements_shouldReturnAverage()
    {
        // Arrange
        var numbers = new Numbers();
        numbers.numbers = Arrays.asList(10.0, 30.0, 20.0);
        
        // Act
        var result = OperationHandler.getNumbersAverage(numbers);
        
        // Assert
        assertThat(result, is(20.0));
    }
    
    @Test
    public void getNumbersMedian_whenListHasElements_shouldReturnMedian()
    {
        // Arrange
        var numbers = new Numbers();
        numbers.numbers = Arrays.asList(10.0, 30.0, 20.0);
        
        // Act
        var result = OperationHandler.getNumbersMedian(numbers);
        
        // Assert
        assertThat(result, is(20.0));
    }
    
    @Test
    public void getNumbersPercentile_whenListHasElements_shouldReturnPercentile()
    {
        // Arrange
        var quantifiableNumbers = new QuantifiableNumbers();
        quantifiableNumbers.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        quantifiableNumbers.quantifier = 25;
        
        // Act
        var result = OperationHandler.getNumbersPercentile(quantifiableNumbers);
        
        // Assert
        assertThat(result, is(2.0));
    }
}
