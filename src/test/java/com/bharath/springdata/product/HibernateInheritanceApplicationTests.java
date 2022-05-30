package com.bharath.springdata.product;

import com.bharath.springdata.product.entities.*;
import com.bharath.springdata.product.repos.PaymentRepository;
import com.bharath.springdata.product.repos.PaymentRepository2;
import com.bharath.springdata.product.repos.PaymentRepository3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HibernateInheritanceApplicationTests {

    @Autowired
    PaymentRepository repository;

    @Autowired
    PaymentRepository2 repository2;

    @Autowired
    PaymentRepository3 repository3;

    /**
     * SINGLE_TABLE approach
     */

    @Test
    public void createCreditCardPayment() {
        CreditCard cc = new CreditCard();
        cc.setId(123);
        cc.setAmount(1000);
        cc.setCardNumber("1234567890");

        repository.save(cc);
    }

    @Test
    public void createCheckPayment() {
        Check ch = new Check();
        ch.setId(124);
        ch.setAmount(1000);
        ch.setCheckNumber("1234567890");

        repository.save(ch);
    }

    /**
     * TABLE_PER_CLASS approach
     */

    @Test
    public void createCreditCardPayment2() {
        CreditCard2 cc = new CreditCard2();
        cc.setId(123);
        cc.setAmount(1000);
        cc.setCardNumber("1234567890");

        repository2.save(cc);
    }

    @Test
    public void createCheckPayment2() {
        Check2 ch = new Check2();
        ch.setId(124);
        ch.setAmount(1000);
        ch.setCheckNumber("1234567890");

        repository2.save(ch);
    }

    /**
     * JOINED approach
     */

    @Test
    public void createCreditCardPayment3() {
        CreditCard3 cc = new CreditCard3();
        cc.setId(123);
        cc.setAmount(1000);
        cc.setCardNumber("1234567890");

        repository3.save(cc);
    }

    @Test
    public void createCheckPayment3() {
        Check3 ch = new Check3();
        ch.setId(124);
        ch.setAmount(1000);
        ch.setCheckNumber("1234567890");

        repository3.save(ch);
    }
}
