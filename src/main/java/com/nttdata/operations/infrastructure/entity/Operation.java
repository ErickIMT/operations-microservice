package com.nttdata.operations.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

  private String id;
  private String customerId;
  private TypeOperation typeOperation;
  private float bootcoinAmount;
  private TypePay typePay;

}
