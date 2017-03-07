package com.limluc.util.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CollectionUtils {

    public static <T> Set<T> asSet(T... a) {
        return new HashSet<T>(
                Arrays.asList(a)
        );
    }
}
