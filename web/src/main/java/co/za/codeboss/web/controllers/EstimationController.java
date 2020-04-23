package co.za.codeboss.web.controllers;

import co.za.codeboss.application.estimation.command.createitem.CreateEstimationItem;
import co.za.codeboss.core.Results.OperationResult;
import co.za.codeboss.core.command.handler.ICommandHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estimation")
public class EstimationController {

    private ICommandHandler<CreateEstimationItem, OperationResult> itemCreator;

    public EstimationController(ICommandHandler<CreateEstimationItem, OperationResult> itemCreator) {
        this.itemCreator = itemCreator;
    }

    @PostMapping("/create-item")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OperationResult> createItem(@RequestBody CreateEstimationItem command) throws Exception {
        var op = this.itemCreator.handle(command).get();

        return ResponseEntity.ok(op);
    }
}
