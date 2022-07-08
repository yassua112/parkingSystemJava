package com.spring.parkingsystem.repositories;

import com.spring.parkingsystem.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("""
			SELECT cat.id, cat.tarif, cat.tariflanjut
			FROM Category AS cat
			WHERE cat.id LIKE %:id%	""")
    public Page<Object> findAll(@Param("id") String id, Pageable pageable);
}
