package com.example.mystockv2.controllers;

import com.example.mystockv2.models.Admission;
import com.example.mystockv2.services.AdmissionService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admission")
@RequiredArgsConstructor
public class AdmissionController {
    private final AdmissionService admissionService;

    @PostMapping("/create")
    public ResponseEntity<Admission> addAdmission(@RequestBody Admission admission) throws NotFoundException {
        return new ResponseEntity<>(admissionService.addAdmission(admission), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public void deleteAdmission(@PathVariable Long id) {
        admissionService.deleteAdmissionById(id);
    }

    @GetMapping("/getAdmission")
    public ResponseEntity<List<Admission>> getAdmission() {
        return new ResponseEntity<>(admissionService.findAllAdmissions(), HttpStatus.OK);
    }

    @GetMapping("/getAdmissionById/{id}")
    public ResponseEntity<Admission> getAdmissionById(Long id) {
        return new ResponseEntity<>(admissionService.findAdmissionById(id), HttpStatus.OK);
    }
}
