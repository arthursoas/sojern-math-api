package arthursoares.dev.mathapi.controllers;

import arthursoares.dev.mathapi.handlers.OperationHandler;
import arthursoares.dev.mathapi.models.responses.Numbers;
import arthursoares.dev.mathapi.models.requests.QuantifiableNumbers;
import arthursoares.dev.mathapi.models.responses.ApiError;
import arthursoares.dev.mathapi.models.responses.Average;
import arthursoares.dev.mathapi.models.responses.Median;
import arthursoares.dev.mathapi.models.responses.Percentile;
import arthursoares.dev.mathapi.validations.NumbersValidations;
import arthursoares.dev.mathapi.validations.QuantifiableNumbersValidations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operation")
public class OperationsController
{   
    @PostMapping("/min")
    public ResponseEntity<Numbers> findMinNumbers(@Validated @RequestBody QuantifiableNumbers body)
    {
        var response = new Numbers();
        QuantifiableNumbersValidations.quantifierSmallerThanNumbersSize(body, response);
        if (response.error != null)
        {
            return ResponseEntity.badRequest().body(response);
        }
        
        response.numbers = OperationHandler.getMinNumbers(body);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("/max")
    public ResponseEntity<Numbers> findMaxNumbers(@Validated @RequestBody QuantifiableNumbers body)
    {
        var response = new Numbers();
        QuantifiableNumbersValidations.quantifierSmallerThanNumbersSize(body, response);
        if (response.error != null)
        {
            return ResponseEntity.badRequest().body(response);
        }
        
        response.numbers = OperationHandler.getMaxNumbers(body);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("/avg")
    public ResponseEntity<Average> findNumbersAverage(@Validated @RequestBody arthursoares.dev.mathapi.models.requests.Numbers body)
    {
        var response = new Average();
        NumbersValidations.numbersEmptyOrNull(body, response);
        if (response.error != null)
        {
            return ResponseEntity.badRequest().body(response);
        }
        
        response.average = OperationHandler.getNumbersAverage(body);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("/median")
    public ResponseEntity<Median> findNumbersMedian(@Validated @RequestBody arthursoares.dev.mathapi.models.requests.Numbers body)
    {
        var response = new Median();
        NumbersValidations.numbersEmptyOrNull(body, response);
        if (response.error != null)
        {
            return ResponseEntity.badRequest().body(response);
        }
        
        response.median = OperationHandler.getNumbersMedian(body);
        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("/percentile")
    public ResponseEntity<Percentile> findNumbersPercentile(@Validated @RequestBody QuantifiableNumbers body)
    {
        var response = new Percentile();
        NumbersValidations.numbersEmptyOrNull(body, response);
        if (response.error != null)
        {
            return ResponseEntity.badRequest().body(response);
        }
        
        response.percentile = OperationHandler.getNumbersPercentile(body);
        return ResponseEntity.ok().body(response);
    }
}
 