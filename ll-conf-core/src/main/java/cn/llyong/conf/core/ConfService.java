package cn.llyong.conf.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        String s = "{\"name\":\"BeJson\",\"url\":\"http://www.bejson.com\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"科技园路.\",\"city\":\"江苏苏州\",\"country\":\"中国\"},\"links\":[{\"name\":\"Google\",\"url\":\"http://www.google.com\"},{\"name\":\"Baidu\",\"url\":\"http://www.baidu.com\"}]}";
        mongoTemplate.insert(s);
        return "success";
    }
}
