package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller that serves slack slash commands by fielding a post request and responding.
 */
public interface RestController<T> {

    /**
     * Serves incoming slack slash command's post request.
     * @param incomingRequest request body to be handled.
     * @return a response to poster.
     */
    ResponseEntity<T> serve(@RequestBody String incomingRequest);

    /**
     * WIP add a method parameterized by a url for posting to slack webhooks.
     */
}
