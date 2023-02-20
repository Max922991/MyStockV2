package com.example.mystockv2.repositories;

import com.example.mystockv2.models.Selling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellingRepo extends JpaRepository<Selling, Long> {
}
