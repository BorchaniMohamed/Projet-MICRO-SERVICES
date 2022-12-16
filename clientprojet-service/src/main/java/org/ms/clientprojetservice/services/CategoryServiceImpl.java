package org.ms.clientprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.clientprojetservice.entities.CustomerCategory;
import org.ms.clientprojetservice.repository.AdresseRepository;
import org.ms.clientprojetservice.repository.CustomerCategoryRepository;
import org.ms.clientprojetservice.repository.CustomerRepository;
import org.ms.clientprojetservice.repository.ToDoCustomerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements  CategoryService{
    private CustomerRepository customerRepository;
    private AdresseRepository adresseRepository;
    private ToDoCustomerRepository toDoCustomerRepository;
    private CustomerCategoryRepository customerCategoryRepository;

    @Override
    public void deleteById(Long id) throws IOException {
       customerCategoryRepository.deleteById(id);
    }

    @Override
    public CustomerCategory save(CustomerCategory c) {
        return customerCategoryRepository.save(c);
    }

    @Override
    public CustomerCategory findById(long id) {
        return customerCategoryRepository.findById(id).get();
    }

    @Override
    public List<CustomerCategory> findAll() {
        return customerCategoryRepository.findAll();
    }
}
