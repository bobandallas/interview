package org.example.service.impl;

import org.example.pojo.dto.RewardResponseDTO.*;
import org.example.pojo.entity.Customer;
import org.example.pojo.entity.Transaction;
import org.example.repository.CustomerRepository;
import org.example.repository.TransactionRepository;
import org.example.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardServiceImpl implements RewardService {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public RewardServiceImpl(CustomerRepository customerRepository,
                             TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> temp = customerRepository.findAll();
        // use h2 database in memory, if not exist record, first time will hardcode two fix records to verify.
        if (temp.isEmpty()) {
            System.out.println("start init()");
            Customer customer1 = new Customer();
            customer1.setName("John");

            Transaction transaction1 = new Transaction();
            transaction1.setDate(new Date());
            transaction1.setAmount(100);
            transaction1.setCustomer(customer1);
            customer1.getTransactions().add(transaction1);

            Transaction transaction2 = new Transaction();
            transaction2.setDate(new Date());
            transaction2.setAmount(120);
            transaction2.setCustomer(customer1);
            customer1.getTransactions().add(transaction2);

            Transaction transaction3 = new Transaction();
            transaction3.setDate(new Date());
            transaction3.setAmount(300);
            transaction3.setCustomer(customer1);
            customer1.getTransactions().add(transaction3);

            Customer customer2 = new Customer();
            customer2.setName("Bob");

            Transaction transaction4 = new Transaction();
            transaction4.setDate(new Date());
            transaction4.setAmount(200);
            transaction4.setCustomer(customer2);
            customer2.getTransactions().add(transaction4);

            Transaction transaction5 = new Transaction();
            transaction5.setDate(new Date());
            transaction5.setAmount(500);
            transaction5.setCustomer(customer2);
            customer2.getTransactions().add(transaction5);

            Transaction transaction6 = new Transaction();
            transaction6.setDate(new Date());
            transaction6.setAmount(450);
            transaction6.setCustomer(customer2);
            customer2.getTransactions().add(transaction6);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            transactionRepository.save(transaction1);
            transactionRepository.save(transaction2);
            transactionRepository.save(transaction3);
            transactionRepository.save(transaction4);
            transactionRepository.save(transaction5);
            transactionRepository.save(transaction6);

            return null;
        }

        // output DTO
        List<CustomerDTO> res = temp.stream()
                                    .map(e -> new CustomerDTO(e))
                                    .collect(Collectors.toList());
        return res;
    }


}
