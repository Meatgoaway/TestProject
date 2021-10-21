package com.example.exchangerateinfoservice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "currency_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyHistory {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "number")
    private String number;

    @Column(name = "char_code")
    private String charCode;

    @Column(name = "denomination")
    private Integer denomination;

    @Column(name = "name")
    private String name;

    @Column(name = "amount_in_rubles")
    private BigDecimal amountInRubles;

    @Column(name = "previous_amount_in_rubles")
    private BigDecimal previousAmountInRubles;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

}