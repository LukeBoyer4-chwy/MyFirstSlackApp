package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;

@RestController
@RequestMapping
public class RainingController {

    WeatherGetter dataSource = new WeatherGetter();

    SlackRequestDeserializer make = new SlackRequestDeserializer();

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> isRaining(@RequestBody String stuff) throws Exception {
        System.out.println("afgaG");
        stuff = URLDecoder.decode(stuff, "UTF-8");
        // this cannot contain a plain text body appparantly
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("Content-Type", Arrays.asList("text/plain"));
        ResponseEntity<String> dds = new ResponseEntity<>("stuf", headers, HttpStatus.ACCEPTED);

        System.out.println(dds.getStatusCode().toString() + dds.getHeaders());

        return dds;

    }


}
