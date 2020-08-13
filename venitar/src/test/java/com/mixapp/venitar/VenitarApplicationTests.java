package com.mixapp.venitar;

import com.mixapp.venitar.configuration.TestAppConfiguration;
import com.mixapp.venitar.configurations.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestAppConfiguration.class)
class VenitarApplicationTests {

    @Test
    void contextLoads() {
    }


}
