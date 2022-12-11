package org.ms.clientprojetservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.clientprojetservice.entities.Adresse;
import org.ms.clientprojetservice.entities.Customer;
import org.ms.clientprojetservice.entities.CustomerCategory;
import org.ms.clientprojetservice.entities.ToDoCustomer;
import org.ms.clientprojetservice.services.AdresseService;
import org.ms.clientprojetservice.services.CategoryService;
import org.ms.clientprojetservice.services.CustomerService;
import org.ms.clientprojetservice.services.ToDoCustomerService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private CustomerService customerService;
    private CategoryService categoryService;
    private AdresseService adresseService;
    private ToDoCustomerService toDoCustomerService;

    @GetMapping("/customers")
    private List<Customer> findAllCustomers(){
        List<Customer> all = customerService.findAll();
        return all;
    }
    @GetMapping("/newcustomers")
    private List<Customer> findNewCustomers(){
        List<Customer> all = customerService.findNewCustomer();
        return all;
    }

    @GetMapping("/customerCategories")
    private List<CustomerCategory> findAllCategory(){
        List<CustomerCategory> all = categoryService.findAll();
        return all;
    }

    @GetMapping("/adresses")
    private List<Adresse> findAllAdresses(){
        List<Adresse> all = adresseService.findAll();
        return all;
    }

    @GetMapping("/todocustomer")
    private List<ToDoCustomer> findAllToDoCustomer(){
        List<ToDoCustomer> all = toDoCustomerService.findAll();
        return all;
    }

    @GetMapping("/customers/{id}")
    private Customer findCustomerById(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        return customer;

    }
    @GetMapping("/customerCategories/{id}")
    private CustomerCategory findCategoryById(@PathVariable Long id){
        CustomerCategory c = categoryService.findById(id);
        return c;

    }
    @GetMapping("/adresses/{id}")
    private Adresse findAdresseById(@PathVariable Long id){
        Adresse c = adresseService.findById(id);
        return c;

    }
    @GetMapping("/todocustomer/{id}")
    private ToDoCustomer findToDoCustomerById(@PathVariable Long id){
        ToDoCustomer c = toDoCustomerService.findById(id);
        return c;

    }


    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer c){
        return customerService.save(c);

    }

    @PostMapping("/customerCategories")
    public CustomerCategory saveCategory(@RequestBody CustomerCategory c){
        return categoryService.save(c);

    }
    @PostMapping("/adresses")
    public Adresse saveAdresse(@RequestBody Adresse c){
        return adresseService.save(c);

    }

    @PostMapping("/toDoCustomers")
    public ToDoCustomer saveToDoCustomer(@RequestBody ToDoCustomer c){
        return toDoCustomerService.save(c);

    }

    @GetMapping("/deleteCustomer/{id}" )
    public void deleteCustomer(@PathVariable Long id) throws IOException {
        customerService.deleteById(id);
    }

    @GetMapping("/deleteCustomerCategory/{id}" )
    public void deleteCustomerCategory(@PathVariable Long id) throws IOException {
        categoryService.deleteById(id);
    }
    @GetMapping("/deleteAdresse/{id}" )
    public void deleteAdresse(@PathVariable Long id) throws IOException {
        adresseService.deleteById(id);
    }

    @GetMapping("/deletetodocustomer/{id}" )
    public void deletetodocustomer(@PathVariable Long id) throws IOException {
        toDoCustomerService.deleteById(id);
    }

    @PutMapping("customers/{customerid}")
    public Customer editCustomer(@PathVariable Long customerid,@RequestBody Customer customer){
        customer.setId(customerid);
        return customerService.update(customer);
    }

    @PutMapping("customerCategories/{categoryid}")
    public CustomerCategory editCustomerCategory( @PathVariable Long categoryid,@RequestBody CustomerCategory customerCategory){
        customerCategory.setId(categoryid);
        return categoryService.save(customerCategory);
    }
    @PutMapping("adresses/{adresseid}")
    public Adresse editAdresse(@PathVariable Long adresseid,@RequestBody Adresse adresse){
       adresse.setId(adresseid);
       return adresseService.save(adresse);
    }
    @PutMapping("todocustomer/{todocustomerid}")
    public ToDoCustomer editToDoCustomer(@PathVariable Long todocustomerid,@RequestBody ToDoCustomer toDoCustomer) {
        toDoCustomer.setId(todocustomerid);
        return toDoCustomerService.save(toDoCustomer);
    }
}
