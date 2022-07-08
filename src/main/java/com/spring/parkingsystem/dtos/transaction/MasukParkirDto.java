package com.spring.parkingsystem.dtos.transaction;

import com.spring.parkingsystem.models.Category;
import com.spring.parkingsystem.models.Transaction;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class MasukParkirDto {
    private final Integer id;
    private final Category jenisKendaraan;
    private final String keterangan;
    private final LocalTime jamMasuk;
    private final LocalDate tanggalMasuk;

    public Transaction parkirMotor(Transaction motor) {
        motor.setJenisKendaraan(new Category("Roda 2", 2000, 2000));
        motor.setKeterangan("Motor");
        motor.setJamMasuk(LocalDateTime.now());
        motor.setTanggalMasuk(LocalDate.now());
        return motor;
    }

    public Transaction parkirMobil(Transaction mobil, Category tarifMobil) {
        mobil.setJenisKendaraan(tarifMobil);
        mobil.setKeterangan("Mobil");
        mobil.setJamMasuk(LocalDateTime.now());
        mobil.setTanggalMasuk(LocalDate.now());
        return mobil;
    }

    public Transaction parkirMoge(Transaction moge){
        moge.setJenisKendaraan(new Category("Roda 2", 10000, 5000));
        moge.setKeterangan("Mogee");
        moge.setJamMasuk(LocalDateTime.now());
        moge.setTanggalMasuk(LocalDate.now());
        return moge;
    }
}
