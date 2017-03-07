package com.concisebox.util;

import org.json.JSONObject;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JSONUtilsTest {
    @Test
    public void shouldReturnList() throws Exception {
        JSONObject jsonObject = IOUtils.asJsonObject("/test.json");

        List<Object> actual = JSONUtils.extractPathAsList(jsonObject, "list");

        assertEquals(3, actual.size());
        assertEquals("two", ((JSONObject) actual.get(2)).get("listName"));
    }

    @Test
    public void shouldReturnObject() throws Exception {
        JSONObject jsonObject = IOUtils.asJsonObject("/test.json");
        List<Object> actual = JSONUtils.extractPathAsList(jsonObject, "object");

        assertEquals(1, actual.size());

        Object jsonObjectActual = actual.get(0);

        assertTrue(jsonObjectActual instanceof JSONObject);
        assertEquals("child1", ((JSONObject) jsonObjectActual).get("objectChild1"));
    }

    @Test
    public void shouldReturnString() throws Exception {
        JSONObject jsonObject = IOUtils.asJsonObject("/test.json");
        List<Object> actual = JSONUtils.extractPathAsList(jsonObject, "string");

        assertEquals("test.json", actual.get(0));
    }
}