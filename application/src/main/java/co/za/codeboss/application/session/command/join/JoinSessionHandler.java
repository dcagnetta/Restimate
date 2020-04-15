package co.za.codeboss.application.session.command.join;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.documents.EstimatorNestedDocument;
import co.za.codeboss.data.elastic.repositories.ISessionRepository;

import java.util.Collections;
import java.util.HashSet;

@CommandHandlerAnnotation
public class JoinSessionHandler implements ICommandHandler<JoinSession, Void> {

    private ISessionRepository repository;

    public JoinSessionHandler(ISessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void handle(JoinSession command) {
        var document =  repository.findById(command.getSessionId()).get();

        var estimator = EstimatorNestedDocument.create(command.getEstimatorName());

        var estimators = document.getEstimators();
        // First joiner
        if (estimators == null){
            estimators = new HashSet<>(Collections.singletonList(estimator));
            document.setEstimators(estimators);
            repository.save(document);
            return null;
        }

        // joiners already present
        estimators.add(estimator);
        return null;
    }
}
