package com.spring.parkingsystem.repositories;

import com.spring.parkingsystem.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("""
			SELECT t.id, t.jenisKendaraan, t.keterangan, t.jamMasuk, t.tanggalMasuk
			FROM Transaction as t
			WHERE t.keterangan LIKE %:keterangan% """)
    public Page<Object> findAll(@Param("keterangan") String keterangan, Pageable pageable);
}
