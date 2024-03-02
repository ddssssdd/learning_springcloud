package com.sfuhome.service;

import com.sfuhome.entities.Pay;

import java.util.List;

public interface PayService {
    int add(Pay pay);
    int update(Pay pay);
    int delete(Integer id);

    Pay find(Integer id);
    List<Pay> listAll();

}
