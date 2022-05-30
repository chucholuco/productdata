package com.bharath.springdata.product;

import com.bharath.springdata.product.services.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionManagementApplicationTests {

    @Autowired
    BankAccountService service;

    @Test
    public void testTransfer() {
        service.transfer(500);
    }
}
