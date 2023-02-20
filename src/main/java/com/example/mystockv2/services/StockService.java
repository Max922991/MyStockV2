package com.example.mystockv2.services;

import com.example.mystockv2.models.Stock;
import com.example.mystockv2.repositories.StockRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepo stockRepo;

    public Stock addStock(Stock stock){
        return stockRepo.save(stock);
    }

    public void deleteById(Long id) {
        stockRepo.deleteById(id);
    }

    public Stock findById(Long id) {
        return stockRepo.findById(id).orElse(null);
    }

}
