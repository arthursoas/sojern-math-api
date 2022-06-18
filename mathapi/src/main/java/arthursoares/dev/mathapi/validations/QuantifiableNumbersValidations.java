package arthursoares.dev.mathapi.validations;

import arthursoares.dev.mathapi.models.requests.QuantifiableNumbers;
import arthursoares.dev.mathapi.models.responses.ApiError;
import arthursoares.dev.mathapi.models.responses.BaseResponse;

public class QuantifiableNumbersValidations
{
    public static BaseResponse quantifierSmallerThanNumbersSize(QuantifiableNumbers quantifiableNumbers, BaseResponse baseResponse)
    {
        if (quantifiableNumbers.quantifier > quantifiableNumbers.numbers.size())
        {
            baseResponse.error = new ApiError("Quantifier cannot be greater than numbers length");
        }
        
        return baseResponse;
    }
}
