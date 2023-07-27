package com.example.demo.service;

import com.example.demo.DTO.HocVienDTO;

import java.util.List;

public interface HocVienService {

    List<HocVienDTO> getAllHocVien();

    HocVienDTO getHocVienById(Long id);

    HocVienDTO createHocVien(HocVienDTO hocVienDTO);

    HocVienDTO updateHocVien(Long id, HocVienDTO hocVienDTO);

    boolean deleteHocVien(Long id);

    List<HocVienDTO> findHocVienByName(String name);

    List<HocVienDTO> findHocVienByEmail(String email);
}
