package com.littlebank.littlebanknew.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * Created by sbt-velichko-aa on 17.03.17.
 */
@Data
@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", updatable = false, nullable = false)
    private Long account_id;

//    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(columnDefinition = "BINARY(16)")
//    private UUID account_id;

    @PositiveOrZero
    @Column(nullable = false, updatable = false)
    private Long accountNumber;

    @NotNull
    @Column(nullable = false)
    @Size(min = 3, max = 25, message = "IBAN should have at least 2 characters and not more 25.")
    private String IBAN;

    @Column(nullable = false)
    @Size(min = 3, max = 25, message = "Bank Name should have at least 2 characters and not more 25.")
    private String bankName;

    @Column(nullable = false)
    @PositiveOrZero
    private Long bic;

    private @Version @JsonIgnore
    Long version;

    private BankAccount() {
    }

    public BankAccount(Long accountNumber, String IBAN, String bankName, Long bic) {
        this.accountNumber = accountNumber;
        this.IBAN = IBAN;
        this.bankName = bankName;
        this.bic = bic;
    }

    public BankAccount(String IBAN, String bankName) {
        this.IBAN = IBAN;
        this.bankName = bankName;
    }

}
