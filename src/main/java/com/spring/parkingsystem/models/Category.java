package com.spring.parkingsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "kategori", nullable = false, length = 10)
    private String id;

    @Column(name = "tarif", nullable = false)
    private Integer tarif;

    @Column(name = "tariflanjut", nullable = false)
    private Integer tariflanjut;

    public Category(String id) {
        this.id = id;
    }

    public Category(String id, Integer tarif, Integer tariflanjut) {
        this.id = id;
        this.tarif = tarif;
        this.tariflanjut = tariflanjut;
    }
}