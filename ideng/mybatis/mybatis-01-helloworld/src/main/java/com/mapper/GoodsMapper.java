package com.mapper;

import com.entity.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> getByUserId(Long userId);

}
