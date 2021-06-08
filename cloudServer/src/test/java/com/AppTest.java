package com;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }

    @Test

    public void getSpringVersion() {
        String version = SpringVersion.getVersion();

        String version1 = SpringBootVersion.getVersion();

        System.out.println(version);

        System.out.println(version1);

    }

}

