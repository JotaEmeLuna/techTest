package com.tech.eleccomm.application.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class NotFoundExceptionTest {

    static String EXCEPTION_MESSAGE = "::message::";
    private Throwable THROWABLE = new Throwable();
    static String BODY = "::boyd::";

    @Test
    void NonParameterTest() {
        NotFoundException notFoundException = new NotFoundException();
        Assertions.assertEquals(notFoundException.getCode(), HttpStatus.NOT_FOUND.value());
        Assertions.assertTrue(Objects.isNull(notFoundException.getMessage()));
        Assertions.assertTrue(Objects.isNull(notFoundException.getCause()));
        Assertions.assertTrue(Objects.isNull(notFoundException.getHeaders()));
        Assertions.assertTrue(Objects.isNull(notFoundException.getBody()));
    }

    @Test
    void MessageParameterTest() {
        NotFoundException notFoundException = new NotFoundException(EXCEPTION_MESSAGE);
        Assertions.assertEquals(notFoundException.getCode(), HttpStatus.NOT_FOUND.value());
        Assertions.assertEquals(notFoundException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertTrue(Objects.isNull(notFoundException.getCause()));
        Assertions.assertTrue(Objects.isNull(notFoundException.getHeaders()));
        Assertions.assertTrue(Objects.isNull(notFoundException.getBody()));
    }

    @Test
    void MessageAndThrowableParameterTest() {
        NotFoundException notFoundException = new NotFoundException(EXCEPTION_MESSAGE, THROWABLE);
        Assertions.assertEquals(notFoundException.getCode(), HttpStatus.NOT_FOUND.value());
        Assertions.assertEquals(notFoundException.getCause(), THROWABLE);
        Assertions.assertEquals(notFoundException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertTrue(Objects.isNull(notFoundException.getHeaders()));
        Assertions.assertTrue(Objects.isNull(notFoundException.getBody()));
    }

    @Test
    void MessageBodyAndThrowableParameterTest() {
        NotFoundException notFoundException = new NotFoundException(EXCEPTION_MESSAGE, BODY, THROWABLE);
        Assertions.assertEquals(notFoundException.getCode(), HttpStatus.NOT_FOUND.value());
        Assertions.assertEquals(notFoundException.getCause(), THROWABLE);
        Assertions.assertEquals(notFoundException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertEquals(notFoundException.getBody(), BODY);
        Assertions.assertTrue(Objects.isNull(notFoundException.getHeaders()));
    }
}