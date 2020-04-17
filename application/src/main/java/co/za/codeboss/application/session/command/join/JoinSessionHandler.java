package co.za.codeboss.application.session.command.join;

import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.repositories.ISessionElasticsearchRepository;
import co.za.codeboss.documents.EstimatorNestedDocument;
import co.za.codeboss.documents.SessionDocument;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@CommandHandlerAnnotation
public class JoinSessionHandler implements ICommandHandler<JoinSession, Void> {

    private ISessionElasticsearchRepository repository;

    public JoinSessionHandler(ISessionElasticsearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Future<Void> handle(JoinSession command) throws Exception {
        Future<SessionDocument> future = repository.findOneById(command.getSessionId());
        var document =  future.get();

        var estimator = EstimatorNestedDocument.create(command.getEstimatorName());

        var estimators = document.getEstimators();
        // First joiner
        if (estimators == null){
            estimators = new HashSet<>(Collections.singletonList(estimator));
            document.setEstimators(estimators);
            repository.save(document);

            return CompletableFuture.completedFuture(null);
        }

        // joiners already present
        estimators.add(estimator);
        return null;
    }
}
