package com.nttdata.operations.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  private String id;
  private TypeId typeId;
  private String cellphoneNumber;
  private String email;
  private float bootcoinAmount;
}
