package com.fluytcloud.admin.util;

import java.text.Normalizer;

public class StringUtil {

    private StringUtil() {
    }

    public static String stripAccents(String value) {
        value = Normalizer.normalize(value, Normalizer.Form.NFD);
        value = value.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return value;
    }

}
