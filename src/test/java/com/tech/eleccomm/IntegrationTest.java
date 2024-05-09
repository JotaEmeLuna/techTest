package com.tech.eleccomm;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tech.eleccomm.application.dto.PriceRateDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    //@Autowired
    private static ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Test case: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     * Price should be 35.50
     * Start date should be 2020-06-14 00:00:00
     * End date should be 2020-12-31 23:59:59
     * @throws JsonProcessingException
     */
    @Test
    void testCase1() throws JsonProcessingException {
        String date = "2020-06-14T10:00:00";
        String product = "35455";
        String brand = "1";
        String url = "http://localhost:"+port+"/api/priceRate?date="+date+"&product="+product+"&brand="+brand;
        String response = this.restTemplate.getForObject(url, String.class);
        boolean isSingleObject = isSingleObject(response);
        PriceRateDto dtoResponse = objectMapper.readValue(response, PriceRateDto.class);


        Assertions.assertTrue(isSingleObject);
        Assertions.assertEquals(0, dtoResponse.getPrice().compareTo(BigDecimal.valueOf(35.50)));
        Assertions.assertTrue(dtoResponse.getStartDate().isEqual(LocalDateTime.parse("2020-06-14T00:00:00")));
        Assertions.assertTrue(dtoResponse.getEndDate().isEqual(LocalDateTime.parse("2020-12-31T23:59:59")));
        Assertions.assertEquals(1, dtoResponse.getBrandId());
        Assertions.assertEquals(35455, dtoResponse.getProductId());
    }

    /**
     * Test case: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     * Price should be 25.45
     * Start date should be 2020-06-14 15:00:00
     * End date should be 2020-06-14 18:30:00
     * @throws JsonProcessingException
     */
    @Test
    void testCase2() throws JsonProcessingException {
        String date = "2020-06-14T16:00:00";
        String product = "35455";
        String brand = "1";
        String url = "http://localhost:"+port+"/api/priceRate?date="+date+"&product="+product+"&brand="+brand;
        String response = this.restTemplate.getForObject(url, String.class);
        boolean isSingleObject = isSingleObject(response);
        PriceRateDto dtoResponse = objectMapper.readValue(response, PriceRateDto.class);


        Assertions.assertTrue(isSingleObject);
        Assertions.assertEquals(0, dtoResponse.getPrice().compareTo(BigDecimal.valueOf(25.45)));
        Assertions.assertTrue(dtoResponse.getStartDate().isEqual(LocalDateTime.parse("2020-06-14T15:00:00")));
        Assertions.assertTrue(dtoResponse.getEndDate().isEqual(LocalDateTime.parse("2020-06-14T18:30:00")));
        Assertions.assertEquals(1, dtoResponse.getBrandId());
        Assertions.assertEquals(35455, dtoResponse.getProductId());
    }

    /**
     * Test case: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     * Price should be 35.50
     * Start date should be 2020-06-14 00:00:00
     * End date should be 2020-12-31 23:59:59
     * @throws JsonProcessingException
     */
    @Test
    void testCase3() throws JsonProcessingException {
        String date = "2020-06-14T21:00:00";
        String product = "35455";
        String brand = "1";
        String url = "http://localhost:"+port+"/api/priceRate?date="+date+"&product="+product+"&brand="+brand;
        String response = this.restTemplate.getForObject(url, String.class);
        boolean isSingleObject = isSingleObject(response);
        PriceRateDto dtoResponse = objectMapper.readValue(response, PriceRateDto.class);


        Assertions.assertTrue(isSingleObject);
        Assertions.assertEquals(0, dtoResponse.getPrice().compareTo(BigDecimal.valueOf(35.50)));
        Assertions.assertTrue(dtoResponse.getStartDate().isEqual(LocalDateTime.parse("2020-06-14T00:00:00")));
        Assertions.assertTrue(dtoResponse.getEndDate().isEqual(LocalDateTime.parse("2020-12-31T23:59:59")));
        Assertions.assertEquals(1, dtoResponse.getBrandId());
        Assertions.assertEquals(35455, dtoResponse.getProductId());
    }

    /**
     * Test case: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
     * Price should be 30.50
     * Start date should be 2020-06-15 00:00:00
     * End date should be 2020-06-15 11:00:00
     * @throws JsonProcessingException
     */
    @Test
    void testCase4() throws JsonProcessingException {
        String date = "2020-06-15T10:00:00";
        String product = "35455";
        String brand = "1";
        String url = "http://localhost:"+port+"/api/priceRate?date="+date+"&product="+product+"&brand="+brand;
        String response = this.restTemplate.getForObject(url, String.class);
        boolean isSingleObject = isSingleObject(response);
        PriceRateDto dtoResponse = objectMapper.readValue(response, PriceRateDto.class);


        Assertions.assertTrue(isSingleObject);
        Assertions.assertEquals(0, dtoResponse.getPrice().compareTo(BigDecimal.valueOf(30.50)));
        Assertions.assertTrue(dtoResponse.getStartDate().isEqual(LocalDateTime.parse("2020-06-15T00:00:00")));
        Assertions.assertTrue(dtoResponse.getEndDate().isEqual(LocalDateTime.parse("2020-06-15T11:00:00")));
        Assertions.assertEquals(1, dtoResponse.getBrandId());
        Assertions.assertEquals(35455, dtoResponse.getProductId());
    }

    /**
     * Test case: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
     * Price should be 38.95
     * Start date should be 2020-06-15 16:00:00
     * End date should be 2020-12-31 23:59:59
     * @throws JsonProcessingException
     */
    @Test
    void testCase5() throws JsonProcessingException {
        String date = "2020-06-16T21:00:00";
        String product = "35455";
        String brand = "1";
        String url = "http://localhost:"+port+"/api/priceRate?date="+date+"&product="+product+"&brand="+brand;
        String response = this.restTemplate.getForObject(url, String.class);
        boolean isSingleObject = isSingleObject(response);
        PriceRateDto dtoResponse = objectMapper.readValue(response, PriceRateDto.class);


        Assertions.assertTrue(isSingleObject);
        Assertions.assertEquals(0, dtoResponse.getPrice().compareTo(BigDecimal.valueOf(38.95)));
        Assertions.assertTrue(dtoResponse.getStartDate().isEqual(LocalDateTime.parse("2020-06-15T16:00:00")));
        Assertions.assertTrue(dtoResponse.getEndDate().isEqual(LocalDateTime.parse("2020-12-31T23:59:59")));
        Assertions.assertEquals(1, dtoResponse.getBrandId());
        Assertions.assertEquals(35455, dtoResponse.getProductId());
    }

    /**
     * Method that checks if json has a single node
     * @param jsonString the json
     * @return true if is a single object
     */
    private static boolean isSingleObject(String jsonString) {
        JsonFactory jsonFactory = new JsonFactory();
        try {
            JsonParser parser = jsonFactory.createParser(jsonString);
            int openBraces = 0;
            int closedBraces = 0;

            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();
                if (token == null) break;

                switch (token) {
                    case START_OBJECT:
                        openBraces++;
                        break;
                    case END_OBJECT:
                        closedBraces++;
                        break;
                }
            }

            if (openBraces > 1 && openBraces == closedBraces) {
                return false;
            }
            else if (openBraces == 1 && closedBraces == 1) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            log.error("Error parsing JSON");
            return false;
        }
    }

}
