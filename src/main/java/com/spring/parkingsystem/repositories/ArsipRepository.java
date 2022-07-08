package com.spring.parkingsystem.repositories;

import com.spring.parkingsystem.models.Arsip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ArsipRepository extends JpaRepository<Arsip, Integer> {
    @Query("""
			SELECT a.id, a.masuk, a.keluar, a.tarif, a.keterangan
			FROM Arsip AS a
			WHERE a.keterangan LIKE %:keterangan% """)
    public Page<Object> findAll(@Param("keterangan") String keterangan, Pageable pageable);
}
