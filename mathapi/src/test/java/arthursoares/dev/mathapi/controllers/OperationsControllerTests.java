package arthursoares.dev.mathapi.controllers;

import arthursoares.dev.mathapi.models.requests.Numbers;
import arthursoares.dev.mathapi.models.requests.QuantifiableNumbers;
import java.util.Arrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class OperationsControllerTests
{
    private OperationsController operationController;
    
    @BeforeAll
    public void initialize()
    {
        operationController = new OperationsController();
    }
    
    @Test
    public void findMinNumbers_whenInputIsValid_shouldReturnSuccess()
    {
        // Arrange
        var body = new QuantifiableNumbers();
        body.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        body.quantifier = 2;
        
        // Act
        var result = operationController.findMinNumbers(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(200));
        assertNull(result.getBody().error);
        assertThat(result.getBody().numbers, contains(1.0, 2.0));
    }
    
    @Test
    public void findMinNumbers_whenInputIsInvalid_shouldReturnBadRequest()
    {
        // Arrange
        var body = new QuantifiableNumbers();
        body.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        body.quantifier = 100;
        
        // Act
        var result = operationController.findMinNumbers(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(400));
        assertNotNull(result.getBody().error);
        assertNull(result.getBody().numbers);
    }
    
    @Test
    public void findMaxNumbers_whenInputIsValid_shouldReturnSuccess()
    {
        // Arrange
        var body = new QuantifiableNumbers();
        body.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        body.quantifier = 2;
        
        // Act
        var result = operationController.findMaxNumbers(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(200));
        assertNull(result.getBody().error);
        assertThat(result.getBody().numbers, contains(5.0, 4.0));
    }
    
    @Test
    public void findMaxNumbers_whenInputIsInvalid_shouldReturnBadRequest()
    {
        // Arrange
        var body = new QuantifiableNumbers();
        body.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        body.quantifier = 100;
        
        // Act
        var result = operationController.findMaxNumbers(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(400));
        assertNotNull(result.getBody().error);
        assertNull(result.getBody().numbers);
    }
    
    @Test
    public void findNumbersAverage_whenInputIsValid_shouldReturnSuccess()
    {
        // Arrange
        var body = new Numbers();
        body.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        
        // Act
        var result = operationController.findNumbersAverage(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(200));
        assertNull(result.getBody().error);
        assertThat(result.getBody().average, is(3.0));
    }
    
    @Test
    public void findNumbersAverage_whenInputIsInvalid_shouldReturnBadRequest()
    {
        // Arrange
        var body = new Numbers();
        body.numbers = Arrays.asList();
        
        // Act
        var result = operationController.findNumbersAverage(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(400));
        assertNotNull(result.getBody().error);
    }
    
    @Test
    public void findNumbersMedian_whenInputIsValid_shouldReturnSuccess()
    {
        // Arrange
        var body = new Numbers();
        body.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        
        // Act
        var result = operationController.findNumbersMedian(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(200));
        assertNull(result.getBody().error);
        assertThat(result.getBody().median, is(3.0));
    }
    
    @Test
    public void findNumbersMedian_whenInputIsInvalid_shouldReturnBadRequest()
    {
        // Arrange
        var body = new Numbers();
        body.numbers = Arrays.asList();
        
        // Act
        var result = operationController.findNumbersAverage(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(400));
        assertNotNull(result.getBody().error);
    }
    
    @Test
    public void findNumbersPercentile_whenInputIsValid_shouldReturnSuccess()
    {
        // Arrange
        var body = new QuantifiableNumbers();
        body.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        body.quantifier = 40;
        
        // Act
        var result = operationController.findNumbersPercentile(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(200));
        assertNull(result.getBody().error);
        assertThat(result.getBody().percentile, is(3.0));
    }
    
    @Test
    public void findNumbersPercentile_whenInputIsInvalid_shouldReturnBadRequest()
    {
        // Arrange
        var body = new QuantifiableNumbers();
        body.numbers = Arrays.asList();
        body.quantifier = 40;
        
        // Act
        var result = operationController.findNumbersAverage(body);
        
        // Assert
        assertThat(result.getStatusCodeValue(), is(400));
        assertNotNull(result.getBody().error);
    }
}
