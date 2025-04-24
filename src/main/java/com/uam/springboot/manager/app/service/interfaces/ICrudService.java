package com.uam.springboot.manager.app.service.interfaces;

import java.util.List;

public interface ICrudService<RQ, RS, ID> {
    RS create(RQ dto);
    RS update(ID id, RQ dto);
    void delete(ID id);
    RS findById(ID id);
    List<RS> findAll();
}