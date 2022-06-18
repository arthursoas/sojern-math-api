package arthursoares.dev.mathapi.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operation")
public class OperationsController
{
    @PostMapping("/min")
    public List<Long> findMinNumbers()
    {
        return new ArrayList<>();
    }
    
    @PostMapping("/max")
    public List<Long> findMaxNumbers()
    {
        return new ArrayList<>();
    }
    
    @PostMapping("/avg")
    public Long findNumbersAverage()
    {
        return (long) 0;
    }
    
    @PostMapping("/median")
    public Long findNumbersMedian()
    {
        return (long) 0;
    }
}
