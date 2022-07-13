package com.nttdata.operations.infrastructure.service;

import com.nttdata.operations.infrastructure.entity.Operation;
import com.nttdata.operations.infrastructure.entity.TypeOperation;
import com.nttdata.operations.infrastructure.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OperationService {

  @Autowired
  private OperationRepository operationRepository;

  public Mono<Operation> saveSellOperation(Operation operation) {
    operation.setTypeOperation(TypeOperation.SELL);
    return operationRepository.save(operation);
  }

  public Mono<Operation> saveBuyOperation(Operation operation) {
    operation.setTypeOperation(TypeOperation.BUY);
    return operationRepository.save(operation);
  }

  public Mono<Operation> findByOperationId(String id) {
    return operationRepository.findById(id);
  }
}
