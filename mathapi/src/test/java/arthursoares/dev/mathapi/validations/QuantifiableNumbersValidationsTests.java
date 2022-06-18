package arthursoares.dev.mathapi.validations;

import arthursoares.dev.mathapi.models.requests.QuantifiableNumbers;
import arthursoares.dev.mathapi.models.responses.BaseResponse;
import java.util.Arrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class QuantifiableNumbersValidationsTests
{
    @Test
    public void quantifierSmallerThanNumbersSize_whenQuantifierIsGreaterThanNumbersSize_shouldAddErrorToResponse()
    {
        // Arrange
        var response = new BaseResponse();
        var quantifiableNumbers = new QuantifiableNumbers();
        quantifiableNumbers.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        quantifiableNumbers.quantifier = 10;
        
        // Act
        var result = QuantifiableNumbersValidations.quantifierSmallerThanNumbersSize(quantifiableNumbers, response);
        
        // Assert
        assertNotNull(result.error);
        assertThat(result.error.message, is("Quantifier cannot be greater than numbers length"));
    }
    
    @Test
    public void quantifierSmallerThanNumbersSize_whenQuantifierIsSmallerThanNumbersSize_shouldNotAddErrorToResponse()
    {
        // Arrange
        var response = new BaseResponse();
        var quantifiableNumbers = new QuantifiableNumbers();
        quantifiableNumbers.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        quantifiableNumbers.quantifier = 2;
        
        // Act
        var result = QuantifiableNumbersValidations.quantifierSmallerThanNumbersSize(quantifiableNumbers, response);
        
        // Assert
        assertNull(result.error);
    }
}
