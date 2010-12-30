package com.delineneo.service;


import org.springframework.integration.Message;
import org.springframework.integration.twitter.core.Tweet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: deline
 * Date: 29/12/10
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class TwitterService {

    private List<Tweet> tweetList = new ArrayList<Tweet>();

    public void doSomething(Message<?> message){

        System.out.println(String.format("*** headerField1 value: %s ***", message.getHeaders().get("headerField1")));

        Tweet tweet = (Tweet) message.getPayload();
        System.out.println(String.format("*** Tweet text: %s ***", tweet.getText()));

        tweetList.add(tweet);
    }

    public List<Tweet> getTweetList() {
        return tweetList;
    }
}
