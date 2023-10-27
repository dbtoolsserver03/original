package com.mapper;

import com.entity.Address;

import java.util.List;
import java.util.Map;

/**
 * 地址 Mapper 接口
 *
 * @author zqd
 *
 * @date 2022-05-09 01:05:24
 */
public interface AddressMapper {
    Address getById(Long id);
}

