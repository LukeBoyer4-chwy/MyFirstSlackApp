package com.example.demo;
import com.sun.tools.javac.util.Pair;
import org.springframework.context.annotation.Bean;

/**
 * A class for supplying sourcing data to a slack application. This is a mock, ideally this class will get interesting
 * data from an api preform some manipulations and return to slack interfacing class.
 */
public class PlainTextMockDataSource implements DataSource {


    @Override
    public Pair<String, String> getDataTypeAsHttpHeader() {
        return new Pair<>("Content-Type", "text/plain");
    }

    @Override
    public String getData() {
        return "This is a mocked plain text data source";
    }
}
