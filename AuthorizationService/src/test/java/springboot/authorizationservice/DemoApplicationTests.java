package springboot.authorizationservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {


    @Autowired
    TestRestTemplate restTemplate;


    @Container
    private final GenericContainer<?> prodApp = new GenericContainer<>("prodapp");
    @Container
    private final GenericContainer<?> devApp = new GenericContainer<>("devapp");

    @Test
    void testDev() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity
                ("http://localhost:" + devApp.getMappedPort(8080), String.class);
        Assertions.assertEquals(forEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    void testProd() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity
                ("http://localhost:" + prodApp.getMappedPort(8081), String.class);
        Assertions.assertEquals(forEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }

}
