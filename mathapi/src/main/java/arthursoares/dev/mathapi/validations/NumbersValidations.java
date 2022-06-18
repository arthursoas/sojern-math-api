package arthursoares.dev.mathapi.validations;

import arthursoares.dev.mathapi.models.requests.Numbers;
import arthursoares.dev.mathapi.models.responses.ApiError;
import arthursoares.dev.mathapi.models.responses.BaseResponse;

public class NumbersValidations {
    public static BaseResponse numbersEmptyOrNull(Numbers numbers, BaseResponse baseResponse)
    {
        if (numbers.numbers == null || numbers.numbers.size() < 1)
        {
            baseResponse.error = new ApiError("Numbers must have at least 1 element");
        }
        
        return baseResponse;
    }
}
