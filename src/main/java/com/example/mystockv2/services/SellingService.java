package com.example.mystockv2.services;

import com.example.mystockv2.models.Product;
import com.example.mystockv2.models.Selling;
import com.example.mystockv2.models.Stock;
import com.example.mystockv2.repositories.ProductRepo;
import com.example.mystockv2.repositories.SellingRepo;
import com.example.mystockv2.repositories.StockRepo;
import com.sun.xml.bind.v2.TODO;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellingService {
    private final SellingRepo sellingRepo;
    private final ProductRepo productRepo;
    private final StockRepo stockRepo;

    public Selling addSelling(Selling selling) throws NotFoundException {
        Selling result = new Selling();

        Product product = productRepo.findById(selling.getProduct().getId())
                .orElseThrow(() -> new NotFoundException("This product not found"));

        Stock stock = stockRepo.findById(selling.getStock().getId())
                .orElseThrow(() -> new NotFoundException("This stock not found"));

        result.setStock(stock);
        result.setQuantity(selling.getQuantity());
        result.setSalePrice(selling.getSalePrice());
        result.setProduct(product);

        sellingRepo.save(result);
        return result;

        // Сделать проверку на количество товара на складе перед продажей!!!

    }

    public Selling findById(Long id) {
        return sellingRepo.findById(id).orElse(null);
    }

    public void deleteSellingById(Long id) {
        sellingRepo.deleteById(id);
    }

    public List<Selling> findAllSelling() {
        return sellingRepo.findAll();
    }
}
