package com.example.demo;

import com.sun.tools.javac.util.Pair;
import org.springframework.context.annotation.Bean;

interface DataSource {
    /**
     * An http header as a pair describing this content.
     * @return A pair representing key and value of http header.
     */
    Pair<String, String> getDataTypeAsHttpHeader();

    /**
     * Get data from source to be sent as payload to a slack application through a slack interfacing class.
     * @return data as a string.
     */
    String getData();

}
