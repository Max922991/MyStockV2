package com.example.mystockv2.services;

import com.example.mystockv2.models.Admission;
import com.example.mystockv2.models.Product;
import com.example.mystockv2.models.Stock;
import com.example.mystockv2.repositories.AdmissionRepo;
import com.example.mystockv2.repositories.ProductRepo;
import com.example.mystockv2.repositories.StockRepo;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdmissionService {

    private final AdmissionRepo admissionRepo;
    private final StockRepo stockRepo;
    private final ProductRepo productRepo;

    @Transactional
    public Admission addAdmission(Admission admission) throws NotFoundException {
        Admission result = new Admission();

        Product product = productRepo.findById(admission.getProduct().getId())
                .orElseThrow(() -> new NotFoundException("This product not found"));

        Stock stock = stockRepo.findById(admission.getStock()
                .getId()).orElseThrow(() -> new NotFoundException("This stock not found"));

        result.setStock(stock);
        result.setQuantity(admission.getQuantity());
        result.setProduct(product);
        result.setPurchasePrice(admission.getPurchasePrice());
        admissionRepo.save(result);

        return result;
    }

    public void deleteAdmissionById(Long id) {
        admissionRepo.deleteById(id);
    }

    public List<Admission> findAllAdmissions(){
        return admissionRepo.findAll();
    }

    public Admission findAdmissionById(Long id){
        return admissionRepo.findById(id).orElse(null);
    }

}
