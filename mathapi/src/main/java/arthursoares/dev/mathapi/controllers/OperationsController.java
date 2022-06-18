package arthursoares.dev.mathapi.controllers;

import arthursoares.dev.mathapi.models.NumberList;
import arthursoares.dev.mathapi.models.QuantifiableNumberList;
import java.util.ArrayList;
import java.util.List;
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
    public List<Long> findMinNumbers(@Validated @RequestBody QuantifiableNumberList body)
    {
        return new ArrayList<>();
    }
    
    @PostMapping("/max")
    public List<Long> findMaxNumbers(@Validated @RequestBody QuantifiableNumberList body)
    {
        return new ArrayList<>();
    }
    
    @PostMapping("/avg")
    public Long findNumbersAverage(@Validated @RequestBody NumberList body)
    {
        return (long) 0;
    }
    
    @PostMapping("/median")
    public Long findNumbersMedian(@Validated @RequestBody NumberList body)
    {
        return (long) 0;
    }
}
