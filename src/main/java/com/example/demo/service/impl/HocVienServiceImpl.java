package com.example.demo.service.impl;

import com.example.demo.DTO.HocVienDTO;
import com.example.demo.entity.HocVienEntity;
import com.example.demo.mapper.HocVienMapper;
import com.example.demo.repository.HocVienRepository;
import com.example.demo.service.HocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocVienServiceImpl implements HocVienService {

    private final HocVienRepository hocVienRepository;
    private final HocVienMapper hocVienMapper;

    @Autowired
    public HocVienServiceImpl(HocVienRepository hocVienRepository, HocVienMapper hocVienMapper) {
        this.hocVienRepository = hocVienRepository;
        this.hocVienMapper = hocVienMapper;
    }


    @Override
    public List<HocVienDTO> getAllHocVien() {
        List<HocVienEntity> hocVienEntities = hocVienRepository.findAll();
        return hocVienMapper.entityListToDtoList(hocVienEntities);
    }

    @Override
    public HocVienDTO getHocVienById(Long id) {
        Optional<HocVienEntity> hocVienEntityOptional = hocVienRepository.findById(id);
        return hocVienEntityOptional.map(hocVienMapper::entityToDto).orElse(null);
    }

    @Override
    public HocVienDTO createHocVien(HocVienDTO hocVienDTO) {
        HocVienEntity hocVienEntity = hocVienMapper.dtoToEntity(hocVienDTO);
        HocVienEntity savedHocVien = hocVienRepository.save(hocVienEntity);
        return hocVienMapper.entityToDto(savedHocVien);
    }

    @Override
    public HocVienDTO updateHocVien(Long id, HocVienDTO hocVienDTO) {
        Optional<HocVienEntity> hocVienEntityOptional = hocVienRepository.findById(id);
        if (hocVienEntityOptional.isPresent()) {
            HocVienEntity hocVienEntity = hocVienEntityOptional.get();
            hocVienEntity.setName(hocVienDTO.getName());
            hocVienEntity.setAge(hocVienDTO.getAge());
            hocVienEntity.setGender(hocVienDTO.getGender());
            hocVienEntity.setEmail(hocVienDTO.getEmail());

            HocVienEntity updatedHocVien = hocVienRepository.save(hocVienEntity);
            return hocVienMapper.entityToDto(updatedHocVien);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteHocVien(Long id) {
        Optional<HocVienEntity> hocVienEntityOptional = hocVienRepository.findById(id);
        if (hocVienEntityOptional.isPresent()) {
            hocVienRepository.delete(hocVienEntityOptional.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<HocVienDTO> findHocVienByName(String name) {
        List<HocVienEntity> hocVienEntities = hocVienRepository.findByNameContainingIgnoreCase(name);
        return hocVienMapper.entityListToDtoList(hocVienEntities);
    }

    @Override
    public List<HocVienDTO> findHocVienByEmail(String email) {
        List<HocVienEntity> hocVienEntities = hocVienRepository.findByEmailContainingIgnoreCase(email);
        return hocVienMapper.entityListToDtoList(hocVienEntities);
    }
}
