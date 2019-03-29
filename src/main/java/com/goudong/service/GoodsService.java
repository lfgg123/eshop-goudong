package com.goudong.service;

import com.goudong.model.Goods;

import java.util.List;

/**
 * Created by CTL on 2019/3/28.
 */
public class GoodsService {
    private static Goods dao = Goods.dao;

    public List<Goods> getAll(){
        return dao.findAll();
    }

    public Goods findOne(Long id){
        return dao.findById(id);
    }
}
