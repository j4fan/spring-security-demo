package com.j4fan.springsecuritydemo.annotations;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class FieldResourceInjectionTest {

    @Autowired
    private File namedFile;

    @Test
    public void givenResourceAnnotation_WhenOnField_ThenDependencyValid(){
        assertNotNull(namedFile);
        log.info(namedFile.getName());
        assertEquals("namedFile.txt", namedFile.getName());
    }
}
