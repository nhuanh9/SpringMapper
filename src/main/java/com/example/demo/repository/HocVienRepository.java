package com.example.demo.repository;

import com.example.demo.entity.HocVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocVienRepository extends JpaRepository<HocVienEntity, Long> {

    List<HocVienEntity> findByNameContainingIgnoreCase(String name);

    List<HocVienEntity> findByEmailContainingIgnoreCase(String email);
}
