package cn.llyong.conf.web.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: llyong
 * @date: 2019/12/18
 * @time: 18:50
 * @version: 1.0
 */
@Slf4j
public class UserUtil {

    /**
     * 实体对象赋值  创建人和创建时间
     *
     * @param source
     */
    public static void setCreatorData(Object source) {
        Class<?> tClass = source.getClass();
        try {
            tClass.getMethod("setCreator", String.class).invoke(source, "admin");
        } catch (Exception e) {
            log.error("创建人赋值失败-->{}", e.getMessage());
        }
        try {
            tClass.getMethod("setCreateTime", Timestamp.class).invoke(source, Timestamp.valueOf(LocalDateTime.now()));
        } catch (Exception e) {
            log.error("创建时间赋值失败-->{}", e.getMessage());
        }
    }

    /**
     * 实体对象赋值  修改人和修改时间
     *
     * @param source
     */
    public static void setModifierData(Object source) {
        Class<?> tClass = source.getClass();
        try {
            tClass.getMethod("setModifier", String.class).invoke(source, "admin");
        } catch (Exception e) {
            log.error("修改人赋值失败-->{}", e.getMessage());
            System.out.println("修改人赋值失败" + e.getMessage());
        }
        try {
            tClass.getMethod("setModifyTime", Timestamp.class).invoke(source, Timestamp.valueOf(LocalDateTime.now()));
        } catch (Exception e) {
            log.error("修改时间赋值失败-->{}", e.getMessage());
        }
    }

}
