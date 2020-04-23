package co.za.codeboss.application.estimation;

import co.za.codeboss.application.estimation.command.createitem.CreateEstimationItem;
import co.za.codeboss.core.Results.OperationResult;
import co.za.codeboss.core.annotations.CommandHandlerAnnotation;
import co.za.codeboss.core.command.handler.ICommandHandler;
import co.za.codeboss.data.elastic.repositories.ISessionElasticsearchRepository;
import co.za.codeboss.documents.EstimationItemNestedDocument;
import co.za.codeboss.documents.SessionDocument;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@CommandHandlerAnnotation
public class EstimationItemHandlers  implements
        ICommandHandler<CreateEstimationItem, OperationResult> {

    private ISessionElasticsearchRepository repository;

    public EstimationItemHandlers(ISessionElasticsearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public Future<OperationResult> handle(CreateEstimationItem command) throws Exception {
        Future<SessionDocument> future = repository.findOneById(command.getSessionId());

        if(future.get() == null) {
            return CompletableFuture.completedFuture(OperationResult.failure("Session not found."));
        }

        var document =  future.get();

        var item = EstimationItemNestedDocument.create(command.getName(), command.getDescription());

        var items = document.getItems();

        // First item
        if (items == null){
            items = new HashSet<>(Collections.singletonList(item));
            document.setItems(items);
            repository.save(document);

            return CompletableFuture.completedFuture(OperationResult.success());
        }

        // joiners already present
        items.add(item);
        return CompletableFuture.completedFuture(OperationResult.success());
    }
}
