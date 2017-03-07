package com.limluc.util.tools;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSONUtils {

    public static JSONObject toJsonObject(String jsonString) {
        JSONTokener jsonTokener = new JSONTokener(jsonString);
        return new JSONObject(jsonTokener);
    }

    public static List<Object> extractPathAsList(JSONObject jsonObject, String path) {
        Object object = jsonObject.get(path);
        if (object instanceof JSONArray) {
            return getCollectionFromArray((JSONArray) object);
        } else {
            return getObject(object);
        }
    }

    private static List<Object> getObject(Object object) {
        return Collections.singletonList(object);
    }

    private static List<Object> getCollectionFromArray(JSONArray jsonArray) {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.get(i));
        }
        return list;
    }
}
