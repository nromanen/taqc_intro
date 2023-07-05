package org.example;

import org.exception.EntityAlreadyExistsException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private static AuthService authService;

    @BeforeAll
    static void beforeAll() {
        authService = new AuthService();
    }

    @Test
    @DisplayName("When user with some login already exists in store then EntityAlreadyExistsException is generated")
    void tryRegisterUserThatAlreadyExist() {
        EntityAlreadyExistsException thrown = assertThrows(EntityAlreadyExistsException.class, () -> {
            authService.registration("user1", "pass");
        });
        assertEquals("User with such login already exists", thrown.getMessage());
    }

    @Test
    void RegisterUser() {
        String result = authService.registration("Other user", "qQ1!Qq!1");
        assertTrue(result.isEmpty(), "Register user method should return son non-empty string");
    }
}
