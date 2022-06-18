package arthursoares.dev.mathapi.validations;

import arthursoares.dev.mathapi.models.requests.Numbers;
import arthursoares.dev.mathapi.models.responses.BaseResponse;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class NumberValidationsTests
{
    @Test
    public void numbersEmptyOrNull_whenListIsEmpty_shouldAddErrorToResponse()
    {
        // Arrange
        var response = new BaseResponse();
        var numbers = new Numbers();
        numbers.numbers = new ArrayList<>();
        
        // Act
        var result = NumbersValidations.numbersEmptyOrNull(numbers, response);
        
        // Assert
        assertNotNull(result.error);
        assertThat(result.error.message, is("Numbers must have at least 1 element"));
    }
    
    @Test
    public void numbersEmptyOrNull_whenListIsNull_shouldAddErrorToResponse()
    {
        // Arrange
        var response = new BaseResponse();
        var numbers = new Numbers();
        numbers.numbers = null;
        
        // Act
        var result = NumbersValidations.numbersEmptyOrNull(numbers, response);
        
        // Assert
        assertNotNull(result.error);
        assertThat(result.error.message, is("Numbers must have at least 1 element"));
    }
    
    @Test
    public void numbersEmptyOrNull_whenListIsNotEmpty_shouldNotAddErrorToResponse()
    {
        // Arrange
        var response = new BaseResponse();
        var numbers = new Numbers();
        numbers.numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        
        // Act
        var result = NumbersValidations.numbersEmptyOrNull(numbers, response);
        
        // Assert
        assertNull(result.error);
    }
}
