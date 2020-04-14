package co.za.codeboss.web.session;

import co.za.codeboss.application.session.create.CreateSession;
import co.za.codeboss.application.session.create.ICreateSessionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    private ICreateSessionUseCase creator;

    @Autowired
    public SessionController(ICreateSessionUseCase creator) {
        this.creator = creator;
    }

    // http://localhost:8080/session/create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody CreateSession command){
        creator.handle(command);
    }
}
