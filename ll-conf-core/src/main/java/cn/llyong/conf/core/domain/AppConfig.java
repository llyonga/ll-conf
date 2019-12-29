package cn.llyong.conf.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @description:
 * @author: llyong
 * @date: 2019/12/29
 * @time: 11:38
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "app_config")
public class AppConfig {

    private String _id;

    @Field("key")
    private String key;

    @Field("value")
    private String value;
}
