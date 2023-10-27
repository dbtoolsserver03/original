package com.boot.mapper;


import com.boot.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressMapper {

    @Select({"select id,addTime,address from t_address where id = #{id}"})
    Address getById(Long id);

}

