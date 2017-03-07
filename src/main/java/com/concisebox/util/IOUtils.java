package com.concisebox.util;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import static com.concisebox.util.JSONUtils.toJsonObject;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.apache.commons.io.FileUtils.toFile;


public class IOUtils {
    private static final Class<IOUtils> CLASS = IOUtils.class;

    public static JSONObject asJsonObject(String resource) {
        return toJsonObject(asString(resource));
    }

    public static String asString(String resource) {
        return findResource(resource);
    }

    private static String findResource(String resources) {
        try {
            URL resource = CLASS.getResource(resources);
            return readFileToString(toFile(resource));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read File" + resources);
        }
    }

}
