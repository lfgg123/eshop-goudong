/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.goudong.service;

import com.goudong.model.Letus;

import java.util.List;

/**
 * @author chentl
 * @version LetusService, v0.1 2019/3/29 17:14
 */
public class LetusService {
    private Letus dao = Letus.dao;

    public List<Letus> getAll(){
        return dao.findAll();
    }
}
