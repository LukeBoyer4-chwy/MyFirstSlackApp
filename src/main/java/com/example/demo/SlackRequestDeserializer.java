package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is hardcoded trash... wip
 */
public class SlackRequestDeserializer {

    private String token;
    private String team_id;
    private String team_domain;
    private String channel_id;
    private String channel_name;
    private String user_id;
    private String user_name;
    private String command;
    private String text;
    private String response_url;
    private String trigger_id;


    public String extractReponseUrl(String requestBody) {
        int start =0;
        Pattern pattern = Pattern.compile("response_url=");
        Matcher matcher = pattern.matcher(requestBody);
        while(matcher.find()) {
            start = matcher.end();
        }
        StringBuilder toRet = new StringBuilder();
        for (int start2 = start ; true ; start2++) {
            if (requestBody.toCharArray()[start2] == '&') {
                break;
            } else {
                toRet.append(requestBody.toCharArray()[start2]);
            }

        } 
        return toRet.toString();
    }






}
