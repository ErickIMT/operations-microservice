package com.nttdata.operations.infrastructure.repository;

import com.nttdata.operations.infrastructure.entity.Operation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OperationRepository {

  Mono<Operation> save(Operation operation);
  Flux<Operation> findAllByTypeOperation(String typeOperation);
  Mono<Operation> findById(String id);
}
