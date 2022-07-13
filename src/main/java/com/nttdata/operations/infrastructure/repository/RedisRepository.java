package com.nttdata.operations.infrastructure.repository;

import com.nttdata.operations.infrastructure.entity.Operation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class RedisRepository implements OperationRepository{

  private ReactiveRedisOperations<String, Operation> operations;

  public RedisRepository(ReactiveRedisOperations<String, Operation> operations) {
    this.operations = operations;
  }


  @Override
  public Mono<Operation> save(Operation operation) {
    operation.setId(RandomStringUtils.randomAlphabetic(5));
    return operations.opsForValue()
      .set(operation.getId(), operation)
      .map(__ -> operation);
  }

  @Override
  public Flux<Operation> findAllByTypeOperation(String typeOperation) {
    return null;
  }

  @Override
  public Mono<Operation> findById(String id) {
    return operations.opsForValue()
      .get(id)
      .map(operation -> new Operation(
        operation.getId(),
        operation.getCustomerId(),
        operation.getTypeOperation(),
        operation.getBootcoinAmount(),
        operation.getTypePay()
      ));
  }
}
