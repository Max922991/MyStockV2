package com.example.mystockv2.repositories;

import com.example.mystockv2.models.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepo extends JpaRepository<Admission, Long> {
    Admission findByStockId(Long id);

}
