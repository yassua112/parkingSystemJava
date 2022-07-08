package com.spring.parkingsystem.dtos.transaction;

import com.spring.parkingsystem.models.Transaction;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class TransactionHeaderDto {
    private Integer id;
    private String Kendaraan;
    private LocalDateTime jam;
    private LocalDate tanggal;
    private Integer tarif;
    private Integer tarifLanjut;

    public static TransactionHeaderDto set(Transaction transaction){
        return new TransactionHeaderDto(transaction.getId(), transaction.getJenisKendaraan().getId(), transaction.getJamMasuk(), transaction.getTanggalMasuk(), transaction.getJenisKendaraan().getTarif(), transaction.getJenisKendaraan().getTariflanjut());
    }
}
