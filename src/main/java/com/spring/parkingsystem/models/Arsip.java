package com.spring.parkingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Arsip {
    @Id
    @Column(name = "VehicleId", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "VehicleId", nullable = false)
    private Transaction transaction;

    @Column(name = "Masuk", nullable = false)
    private LocalDateTime masuk;

    @Column(name = "Keluar", nullable = false)
    private LocalDateTime keluar;

    @Column(name = "Tarif", nullable = false)
    private Integer tarif;

    @Column(name = "Keterangan", length = 200)
    private String keterangan;

}