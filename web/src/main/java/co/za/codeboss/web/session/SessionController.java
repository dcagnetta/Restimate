package co.za.codeboss.web.session;

import co.za.codeboss.application.session.create.CreateSession;
import co.za.codeboss.application.session.create.ICreateSessionUseCase;
import co.za.codeboss.application.session.query.FindSession;
import co.za.codeboss.core.command.handler.CommandHandler;
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
    private CommandHandler<FindSession, Session> finder;

    @Autowired
    public SessionController(
            ICreateSessionUseCase creator,
            CommandHandler<FindSession, Session> finder ) {
        this.creator = creator;
        this.finder = finder;
    }

    // http://localhost:8080/session/create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody CreateSession command){
        creator.handle(command);
    }

    // http://localhost:8080/session/bac3be54-b227-4027-8198-868713241a67
    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSession(@PathVariable("sessionId") UUID sessionId) {
        var query = new FindSession();
        query.setId(sessionId);

        var session = finder.handle(query);
        return new ResponseEntity<>(session, HttpStatus.OK);
    }
}
