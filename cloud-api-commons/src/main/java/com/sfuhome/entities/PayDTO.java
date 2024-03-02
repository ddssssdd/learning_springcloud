package com.sfuhome.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO {
    private Integer id;
    private String orderNo;
    private String payNo;
    private String userId;
    private BigDecimal amount;
}
