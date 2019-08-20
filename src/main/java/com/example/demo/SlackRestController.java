package com.example.demo;

import com.sun.tools.javac.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
public class SlackRestController implements com.example.demo.RestController<String> {

    private DataSource source;

    public SlackRestController(DataSource source) {
        this.source = source;
    }

    @Override
    @PostMapping
    public ResponseEntity<String> serve(@RequestBody String incomingRequest) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        Pair<String, String> contentHeader = source.getDataTypeAsHttpHeader();
        headers.put(contentHeader.fst, Arrays.asList(contentHeader.snd));
        ResponseEntity<String> response = new ResponseEntity<>(source.getData(), headers, HttpStatus.OK);
        //TODO confirm it's 200 and remove this line
        System.out.println(response.getStatusCode());
        return response;
    }
}
