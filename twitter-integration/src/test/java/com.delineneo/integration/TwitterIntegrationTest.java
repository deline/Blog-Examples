package com.delineneo.integration;


import com.delineneo.service.TwitterService;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:twitter-integration.xml")
public class TwitterIntegrationTest
{

    @Resource
    TwitterService service;

    public TwitterIntegrationTest() {
        Logger.getLogger("org.springframework.integration").addAppender(new ConsoleAppender(new SimpleLayout()));
    }


    @Test
    public void canRetrieveTwitterStatuses() throws InterruptedException {

        Thread.sleep(5000);     //let the thread sleep for a bit to allow the poller to run

        assertThat(service.getTweetList().size(), is(3));
    }
}
