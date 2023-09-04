package com.systechafrica.atmmachine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMMachineTest {
    ATMMachine app = new ATMMachine();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isValidLogin() {

    }

    @Test
    void checkBalance() {
        Assertions.assertEquals(1000, app.checkBalance());
    }

    @Test
    void deposit() {

    }

    @Test
    void withdraw() {
    }

    @Test
    void transfer() {
    }

    @Test
    void initiateTransaction() {
    }
}
