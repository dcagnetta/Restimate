package co.za.codeboss.web.controllers;

import co.za.codeboss.application.estimation.command.createitem.CreateEstimationItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estimation")
public class EstimationController {

    @PostMapping("/create-item")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody CreateEstimationItem command){

    }
}
