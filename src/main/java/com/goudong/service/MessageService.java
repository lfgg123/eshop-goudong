/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.goudong.service;

import com.goudong.model.Message;

import java.util.List;

/**
 * @author chentl
 * @version MessageService, v0.1 2019/3/29 17:03
 */
public class MessageService {
    private static final Message dao = Message.dao;

    public List<Message> getAll(){
        return dao.findAll();
    }
}
