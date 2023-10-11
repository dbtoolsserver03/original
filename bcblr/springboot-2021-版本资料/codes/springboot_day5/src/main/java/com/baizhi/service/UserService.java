package com.baizhi.service;

public interface UserService {

    void save(String name);

    void delete(Integer id);

    void update(String name);

    String find(String name);

}
