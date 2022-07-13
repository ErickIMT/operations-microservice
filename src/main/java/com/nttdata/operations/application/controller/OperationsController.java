package com.nttdata.operations.application.controller;

import com.nttdata.operations.infrastructure.entity.Operation;
import com.nttdata.operations.infrastructure.entity.TypePay;
import com.nttdata.operations.infrastructure.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class OperationsController {

  @Autowired
  private OperationService operationService;

  @PostMapping("/operation/sell")
  private Mono<Operation> saveSellOperation(@RequestBody Operation operation, @RequestParam String transaction) {
    if(transaction.equals("Yanki")) {
      operation.setTypePay(TypePay.Yanki);
    }else if(transaction.equals("Transferencia")) {
      operation.setTypePay(TypePay.Yanki);
    }

    return operationService.saveSellOperation(operation);
  }

  @PostMapping("/operation/buy")
  private Mono<Operation> saveBuyOperation(@RequestBody Operation operation, @RequestParam String transaction) {
    if(transaction.equals("Yanki")) {
      operation.setTypePay(TypePay.Yanki);
    }else if(transaction.equals("Transferencia")) {
      operation.setTypePay(TypePay.Yanki);
    }

    return operationService.saveBuyOperation(operation);
  }

  @GetMapping("/operation/{id}")
  private Mono<ResponseEntity<Operation>> findById(@PathVariable String id) {

    return operationService.findByOperationId(id)
      .map(operation -> ResponseEntity.status(HttpStatus.OK).body(operation))
      .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
