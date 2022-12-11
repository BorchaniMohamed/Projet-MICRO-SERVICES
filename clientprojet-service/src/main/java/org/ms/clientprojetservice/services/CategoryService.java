package org.ms.clientprojetservice.services;

import org.ms.clientprojetservice.entities.CustomerCategory;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    void deleteById(Long id) throws IOException;
    CustomerCategory save(CustomerCategory c);
    CustomerCategory findById(long id);
    List<CustomerCategory> findAll();
}
