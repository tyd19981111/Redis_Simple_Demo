package com.tyd.service;

import com.tyd.entity.Province;

import java.util.List;

public interface ProvinceService {

    List<Province> findAll();

    String findAllJson();
}
