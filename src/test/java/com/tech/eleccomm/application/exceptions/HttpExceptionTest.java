package com.tech.eleccomm.application.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpHeaders;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class HttpExceptionTest {

    static String EXCEPTION_MESSAGE = "::message::";
    private Throwable THROWABLE = new Throwable();
    private transient HttpHeaders HEADERS;
    static String BODY = "::boyd::";
    static Integer CODE = 0;
    private HttpClientErrorException HTTP_CLIENT_ERROR_EXCEPTION;

    @BeforeEach
    public void init() {
        this.HTTP_CLIENT_ERROR_EXCEPTION = new HttpClientErrorException(HttpStatus.FORBIDDEN);
    }

    @Test
    void MessageParameterTest() {
        HttpException httpException = new HttpException(EXCEPTION_MESSAGE);
        Assertions.assertEquals(httpException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertTrue(Objects.isNull(httpException.getCode()));
        Assertions.assertTrue(Objects.isNull(httpException.getBody()));
        Assertions.assertTrue(Objects.isNull(httpException.getCause()));
    }

    @Test
    void MessageAndThrowableParameterTest() {
        HttpException httpException = new HttpException(EXCEPTION_MESSAGE, THROWABLE);
        Assertions.assertEquals(httpException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertEquals(httpException.getCause(), THROWABLE);
        Assertions.assertTrue(Objects.isNull(httpException.getCode()));
        Assertions.assertTrue(Objects.isNull(httpException.getBody()));
    }

    @Test
    void CodeMessageAndTrowableParameterTest() {
        HttpException httpException = new HttpException(CODE ,EXCEPTION_MESSAGE, THROWABLE);
        Assertions.assertEquals(httpException.getCode(), CODE);
        Assertions.assertEquals(httpException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertEquals(httpException.getCause(), THROWABLE);
        Assertions.assertTrue(Objects.isNull(httpException.getBody()));
        Assertions.assertTrue(Objects.isNull(httpException.getHeaders()));
    }

    @Test
    void CodeMessageBodyAndTrowableParameterTest() {
        HttpException httpException = new HttpException(CODE, EXCEPTION_MESSAGE, BODY, THROWABLE);
        Assertions.assertEquals(httpException.getCode(), CODE);
        Assertions.assertEquals(httpException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertEquals(httpException.getBody(), BODY);
        Assertions.assertEquals(httpException.getCause(), THROWABLE);
        Assertions.assertTrue(Objects.isNull(httpException.getHeaders()));
    }

    @Test
    void CodeMessageBodyHeadersAndTrowableParameterTest() {
        HttpException httpException = new HttpException(CODE, EXCEPTION_MESSAGE, BODY, HEADERS, THROWABLE);
        Assertions.assertEquals(httpException.getCode(), CODE);
        Assertions.assertEquals(httpException.getMessage(), EXCEPTION_MESSAGE);
        Assertions.assertEquals(httpException.getBody(), BODY);
        Assertions.assertEquals(httpException.getCause(), THROWABLE);
        Assertions.assertTrue(Objects.isNull(httpException.getHeaders()));
    }

}