package com.example.mystockv2.controllers;

import com.example.mystockv2.models.Stock;
import com.example.mystockv2.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("/getStocks")
    public ResponseEntity<List<Stock>> getAllStock() {
        return new ResponseEntity<>(stockService.findAllStocks(), HttpStatus.OK);
    }

    @GetMapping("/getStock/{Id}")
    public ResponseEntity<Stock> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(stockService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.addStock(stock), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteById(id);
    }


}
