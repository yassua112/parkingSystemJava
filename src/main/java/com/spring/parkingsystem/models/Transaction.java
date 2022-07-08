package com.spring.parkingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "\"Transaction\"")
@Setter
@Getter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VehicleId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "JenisKendaraan", nullable = false)
    private Category jenisKendaraan;

    @Column(name = "Keterangan", length = 200)
    private String keterangan;

    @Column(name = "JamMasuk", nullable = false)
    private LocalDateTime jamMasuk;

    @Column(name = "TanggalMasuk", nullable = false)
    private LocalDate tanggalMasuk;

    public Transaction(Integer id, String jenisKendaraan, String keterangan, LocalDateTime jamMasuk, LocalDate tanggalMasuk) {
        this.id = id;
        this.jenisKendaraan = new Category(jenisKendaraan);
        this.keterangan = keterangan;
        this.jamMasuk = jamMasuk;
        this.tanggalMasuk = tanggalMasuk;
    }

    public Transaction(Integer id) {
        this.id = id;
    }
}