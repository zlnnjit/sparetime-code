/*
 * Copyright © 2019 fnii and others.  All rights reserved.
 */

package top.bcoder.common.util.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zln
 * @date 2019/7/12
 */
public class JacksonUtils {
    private static final AtomicReference<ObjectMapper> MAPPER = new AtomicReference<>(new ObjectMapper());

    static {
        MAPPER.get().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String bean2Json(Object obj) {
        try {
            return MAPPER.get().writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        try {
            return MAPPER.get().readValue(jsonStr, objClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> json2ListBean(String jsonStr, Class<T> objClass)  {
        try {
            return MAPPER.get().readValue(jsonStr, MAPPER.get().getTypeFactory().constructParametricType(List.class, objClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String objectToJson(Object data) {
        String string = null;
        try {
            string = MAPPER.get().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static JsonNode json2Bean(String content) throws IOException {
        return new ObjectMapper().readValue(content, JsonNode.class);
    }

}