package com.elad.CouponSystemV3Spring.mapper;

import java.util.List;

import com.elad.CouponSystemV3Spring.exeptions.CouponSystemException;

public interface Mapper<DAO, DTO> {

    DAO toDao(DTO dto) throws CouponSystemException;

    DTO toDto(DAO dao);

    List<DAO> toDaoList(List<DTO> dtos) throws CouponSystemException;

    List<DTO> toDtoList(List<DAO> daos);
}