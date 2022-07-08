package com.spring.parkingsystem.dtos.transaction;

import com.spring.parkingsystem.models.Category;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class TransactionGridDto {
    private Integer id;
    private Category kendaraan;
    private String keterangan;
    private LocalDateTime jam;
    private LocalDate tanggal;
}
