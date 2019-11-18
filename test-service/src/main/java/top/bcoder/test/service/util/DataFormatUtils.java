/*
 * Copyright © 2019 fnii and others.  All rights reserved.
 */

package top.bcoder.test.service.util;

import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author zln
 * @date 2019/7/17
 */
public class DataFormatUtils {

    /**
     * 格式化map中指定key值
     */
    private static void mapTimeFormat(Map<String, Object> map, String key) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String readAt = map.get(key).toString();
        if (readAt != null) {
            map.put(key, LocalDateTime.parse(readAt, dateTimeFormatter));
        }
    }

    public static void responseTimeFormart(List<Map> res) {
        if (CollectionUtils.isEmpty(res)) {
            return;
        }
        res.forEach(map -> {
            mapTimeFormat(map, "createdTime");
            mapTimeFormat(map, "updatedTime");
        });
    }


}
