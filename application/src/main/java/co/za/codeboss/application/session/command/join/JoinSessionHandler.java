package co.za.codeboss.application.session.command.join;

import co.za.codeboss.core.Results.OperationResult;
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
public class JoinSessionHandler implements ICommandHandler<JoinSession, OperationResult<Void>> {

    private ISessionElasticsearchRepository repository;

    public JoinSessionHandler(ISessionElasticsearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Future<OperationResult<Void>> handle(JoinSession command) throws Exception {
        Future<SessionDocument> future = repository.findOneByShortId(command.getShortId());

        if(future.get() == null) {
            return CompletableFuture.completedFuture(OperationResult.failure("Session not found."));
        }

        var document =  future.get();

        var estimator = EstimatorNestedDocument.create(command.getUsername());

        var estimators = document.getEstimators();
        // First joiner
        if (estimators == null){
            estimators = new HashSet<>(Collections.singletonList(estimator));
            document.setEstimators(estimators);
            repository.save(document);

            return CompletableFuture.completedFuture(OperationResult.success());
        }

        // joiners already present
        estimators.add(estimator);
        return CompletableFuture.completedFuture(OperationResult.success());
    }
}
