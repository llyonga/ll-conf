package cn.llyong.conf.core;

import cn.llyong.conf.core.domain.AppConfig;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: llyong
 * @date: 2019/12/29
 * @time: 00:33
 * @version: 1.0
 */
@RestController
public class ConfService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("save")
    public String save() {
        AppConfig config = new AppConfig();
        config.setKey("spring.data.mongodb.uri");
        config.setValue("mongodb://114.67.108.221/conf");

        List<AppConfig> list = new ArrayList<>();
        config = new AppConfig();
        config.setKey("spring.jpa.database");
        config.setValue("mysql");
        list.add(config);

        config = new AppConfig();
        config.setKey("spring.jpa.show-sql");
        config.setValue("true");
        list.add(config);

        config = new AppConfig();
        config.setKey("spring.jpa.show-sql.hibernate.ddl-auto");
        config.setValue("none");
        list.add(config);

        String jsonString = JSON.toJSONString(config);
        System.out.println(JSON.toJSONString(list));

//        mongoTemplate.insert(config);
        mongoTemplate.insertAll(list);
        return "success";
    }
}
