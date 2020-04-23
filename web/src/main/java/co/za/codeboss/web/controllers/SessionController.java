package co.za.codeboss.web.controllers;

import co.za.codeboss.application.session.command.create.CreateSession;
import co.za.codeboss.application.session.command.create.ICreateSessionUseCase;
import co.za.codeboss.application.session.command.join.JoinSession;
import co.za.codeboss.application.session.query.FindSession;
import co.za.codeboss.core.Results.OperationResult;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.domain.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/session")
public class SessionController {

    private ICreateSessionUseCase creator;
    private ICommandHandler<FindSession, Session> finder;
    private ICommandHandler<JoinSession, OperationResult> joiner;

    @Autowired
    public SessionController(
            ICreateSessionUseCase creator,
            ICommandHandler<FindSession, Session> finder,
            ICommandHandler<JoinSession, OperationResult> joiner) {
        this.creator = creator;
        this.finder = finder;
        this.joiner = joiner;
    }

    // http://localhost:8080/session/create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody CreateSession command) throws Exception{
        creator.handle(command);
    }

    // http://localhost:8080/session/bac3be54-b227-4027-8198-868713241a67
    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSession(@PathVariable("sessionId") UUID sessionId) throws Exception {
        var query = new FindSession();
        query.setSessionId(sessionId);

        var session = finder.handle(query);

        return new ResponseEntity<>(session.get(), HttpStatus.OK);
    }

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OperationResult> join(@RequestBody JoinSession command) throws Exception{
        var op = joiner.handle(command).get();

        return ResponseEntity.ok(op);
    }
}
