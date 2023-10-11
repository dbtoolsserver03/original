package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 根据条件分页查询
     */
    List<User> findAllByKeywords(int offset, int limit, String id, String name, String phone);

    /**
     * 根据条件查询总条数
     */
    Long findTotalCountsByKeywords(String id, String name, String phone);
}
