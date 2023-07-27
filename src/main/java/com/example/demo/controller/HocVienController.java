package com.example.demo.controller;

import com.example.demo.DTO.HocVienDTO;
import com.example.demo.service.HocVienService;
import com.example.demo.service.impl.HocVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hocvien")
public class HocVienController {

    private final HocVienService hocVienService;

    @Autowired
    public HocVienController(HocVienService hocVienService) {
        this.hocVienService = hocVienService;
    }

    @PostMapping
    public ResponseEntity<HocVienDTO> createHocVien(@RequestBody HocVienDTO hocVienDTO) {
        HocVienDTO createdHocVien = hocVienService.createHocVien(hocVienDTO);
        return new ResponseEntity<>(createdHocVien, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocVienDTO> getHocVienById(@PathVariable Long id) {
        HocVienDTO hocVienDTO = hocVienService.getHocVienById(id);
        if (hocVienDTO != null) {
            return new ResponseEntity<>(hocVienDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HocVienDTO> updateHocVien(@PathVariable Long id, @RequestBody HocVienDTO hocVienDTO) {
        HocVienDTO updatedHocVien = hocVienService.updateHocVien(id, hocVienDTO);
        if (updatedHocVien != null) {
            return new ResponseEntity<>(updatedHocVien, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHocVien(@PathVariable Long id) {
        boolean isDeleted = hocVienService.deleteHocVien(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<List<HocVienDTO>> findHocVienByName(@RequestParam String name) {
        List<HocVienDTO> hocVienDTOs = hocVienService.findHocVienByName(name);
        return new ResponseEntity<>(hocVienDTOs, HttpStatus.OK);
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<List<HocVienDTO>> findHocVienByEmail(@RequestParam String email) {
        List<HocVienDTO> hocVienDTOs = hocVienService.findHocVienByEmail(email);
        return new ResponseEntity<>(hocVienDTOs, HttpStatus.OK);
    }
}
