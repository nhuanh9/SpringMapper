package com.example.demo.mapper;

import com.example.demo.DTO.HocVienDTO;
import com.example.demo.entity.HocVienEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface HocVienMapper {

    HocVienMapper INSTANCE = Mappers.getMapper(HocVienMapper.class);

    @Mapping(source = "ctm", target = "age", dateFormat = "yyyy-MM-dd HH:mm:ss")
    HocVienDTO entityToDto(HocVienEntity entity);

    @Mapping(source = "ctm", target = "age", dateFormat = "yyyy-MM-dd HH:mm:ss")
    List<HocVienDTO> entityListToDtoList(List<HocVienEntity> entityList);

    HocVienEntity dtoToEntity(HocVienDTO dto);
}
