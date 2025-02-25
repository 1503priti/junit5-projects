package com.priti.estore.service;
//import static org.junit.jupiter.api.Assertions.*;
import com.priti.estore.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init(){
        // Arrange (Given)
        userService = new UserServiceImpl();
         firstName = "priti";
         lastName = "kumari";
         email = "161099priti@gmail.com";
         password = "12345678";
         repeatPassword = "12345678";
    }

    @DisplayName("User object created")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnsUserObject(){


        // Act (When)
        User user = userService.createUser(firstName,lastName,email,password,repeatPassword);

        // Assert (Then)
        assertNotNull(user, "The createUser() should not have returned null");
        assertEquals(firstName, user.getFirstName(), "User firstname is incorrect");
        assertEquals(lastName, user.getLastName(), "User lastname is incorrect");
        assertEquals(email, user.getEmail(), "User email is incorrect");
        assertNotNull(user.getId(), "User id is missing");
    }
    /*@Test
    void testCreateUser_whenUserCreatedReturnedUserObjectContainFirstName(){
        //Arrange
        UserService userService = new UserServiceImpl();
        String firstName = "priti";
        String lastName = "kumari";
        String email = "161099priti@gmail.com";
        String password = "12345678";
        String repeatPassword = "12345678";

        // Act (When)
        User user = userService.createUser(firstName,lastName,email,password,repeatPassword);

        // Assert (Then)
       assertEquals(firstName, user.getFirstName(), "User firstname is incorrect");

    }*/
    @DisplayName("Empty firstName causes correct exceptions")
    @Test
    void testCreatedUser_whenFirstNameIsEmpty_throwsIllegalArgumentException(){
        //Arrange
        String firstName = "";
        String expectedExceptionMsg = "User first name is empty";
        // Act and Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
       userService.createUser(firstName,lastName,email,password,repeatPassword);
                }, "Empty First name should have caused an Illegal Argument Exception"
                );

        //Assert
        assertEquals(expectedExceptionMsg,thrown.getMessage());
    }

    // test method to validate the empty lastname or empty email or empty password also trigger illegal argument exception.
    // test method to validate the if the password for ex if password and repeated password don't match then exception takes place.
    // test method to validate the password is 8 character length for ex if it alpha numeric and it contains atleast one special character
    // test method to validate the password is longer than 8 character and shorter than 30 character
    // To follow TDD, we can have separate class for validator and in validator class will have methods that validate each of the user properties
    // and then you can inject this validator class into createUser() method
}
