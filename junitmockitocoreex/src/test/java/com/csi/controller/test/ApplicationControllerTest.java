package com.csi.controller.test;

import com.csi.controller.ApplicationController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationControllerTest {

    ApplicationController applicationController = new ApplicationController();

   /* @Test
    public void addTest() {

        Assert.assertEquals(11, applicationController.add(6, 5));


    }*/
}
