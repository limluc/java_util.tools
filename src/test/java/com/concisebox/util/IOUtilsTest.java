package com.concisebox.util;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IOUtilsTest {

    @Test
    public void shouldReturnFileAsString() throws Exception {
        String actual = IOUtils.asString("/test.txt");
        String expected = "sampleFile";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFileAsJson() throws Exception {
        JSONObject actual = IOUtils.asJsonObject("/test.json");

        assertEquals(3, actual.length());
        assertEquals("test.json", actual.getString("string"));

    }
}