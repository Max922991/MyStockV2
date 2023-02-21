package com.example.mystockv2.services;

import com.example.mystockv2.models.Move;
import com.example.mystockv2.models.Product;
import com.example.mystockv2.models.Stock;
import com.example.mystockv2.repositories.MoveRepo;
import com.example.mystockv2.repositories.ProductRepo;
import com.example.mystockv2.repositories.StockRepo;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoveService {
    private final MoveRepo moveRepo;
    private final ProductRepo productRepo;
    private final StockRepo stockRepo;

    // Сделать проверку на количество товара на складе перед перемещением!!!

    @Transactional
    public Move addMoving(Move move) throws NotFoundException {
        Move result = new Move();

        Product product = productRepo.findById(move.getProduct().getId())
                .orElseThrow(() -> new NotFoundException("This product not found"));

        Stock stockFrom = stockRepo.findById(move.getStockFrom()
                .getId()).orElseThrow(() -> new NotFoundException("This stock_from not found"));

        Stock stockTo = stockRepo.findById(move.getStockTo()
                .getId()).orElseThrow(() -> new NotFoundException("This stock_to not found"));


        int quantityOnStock = stockRepo.findByQuantityId(move.getStockFrom().getId())
                .orElseThrow(() -> new NotFoundException("Товара на складе не хватает")).getQuantity();

        int quantityMove = move.getQuantity();

        if (quantityOnStock < quantityMove) {
            throw new NotFoundException("Товара на складе не хватает");
        }

        result = moveRepo.save(move);

        return result;
    }
}
