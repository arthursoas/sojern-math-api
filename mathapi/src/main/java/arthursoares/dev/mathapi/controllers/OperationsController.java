package arthursoares.dev.mathapi.controllers;

import arthursoares.dev.mathapi.handlers.OperationHandler;
import arthursoares.dev.mathapi.models.NumberList;
import arthursoares.dev.mathapi.models.QuantifiableNumberList;
import java.util.List;
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
    public ResponseEntity<List<Long>> findMinNumbers(@Validated @RequestBody QuantifiableNumberList body)
    {
        return ResponseEntity.ok().body(OperationHandler.getMinNumbers(body));
    }
    
    @PostMapping("/max")
    public ResponseEntity<List<Long>> findMaxNumbers(@Validated @RequestBody QuantifiableNumberList body)
    {
        return ResponseEntity.ok().body(OperationHandler.getMaxNumbers(body));
    }
    
    @PostMapping("/avg")
    public ResponseEntity<Double> findNumbersAverage(@Validated @RequestBody NumberList body)
    {
        return ResponseEntity.ok().body(OperationHandler.getNumbersAverage(body));
    }
    
    @PostMapping("/median")
    public ResponseEntity<Double> findNumbersMedian(@Validated @RequestBody NumberList body)
    {
        return ResponseEntity.ok().body(OperationHandler.getNumbersMedian(body));
    }
    
    @PostMapping("/percentile")
    public ResponseEntity<Long> findNumbersPercentile(@Validated @RequestBody QuantifiableNumberList body)
    {
        return ResponseEntity.ok().body(OperationHandler.getNumbersPercentile(body));
    }
}
 