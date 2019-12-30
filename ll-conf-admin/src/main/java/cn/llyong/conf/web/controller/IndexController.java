package cn.llyong.conf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019-12-04
 * @time: 11:02 上午
 * @version: 1.0
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/index", "/"})
    public String index() {
        System.out.println("进入首页....");
        return "index";
    }

    @RequestMapping("/setting/user/password")
    public String password() {
        return "/setting/user/password";
    }

    @RequestMapping("/setting/user/info")
    public String info() {
        return "/setting/user/info";
    }

    @RequestMapping("/index/getMenus")
    @ResponseBody
    public String getMenus() {

        String string = "[\n" +
                "    {\n" +
                "        \"title\": \"首页\",\n" +
                "        \"menuName\": \"home\",\n" +
                "        \"icon\": \"layui-icon-home\",\n" +
                "        \"href\": \"/home/console\",\n" +
                "        \"children\": []\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"系统管理\",\n" +
                "        \"menuName\": \"system\",\n" +
                "        \"icon\": \"layui-icon-app\",\n" +
                "        \"href\": \"\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"title\": \"菜单管理\",\n" +
                "                \"menuName\": \"menu\",\n" +
                "                \"href\": \"/menu\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"title\": \"用户管理\",\n" +
                "                \"menuName\": \"user\",\n" +
                "                \"href\": \"/user/list\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"title\": \"权限管理\",\n" +
                "                \"menuName\": \"role\",\n" +
                "                \"href\": \"\",\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"title\": \"用户权限\",\n" +
                "                        \"menuName\": \"userRole\",\n" +
                "                        \"href\": \"/userRole\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"系统设置\",\n" +
                "        \"menuName\": \"setting\",\n" +
                "        \"icon\": \"layui-icon-util\",\n" +
                "        \"href\": \"\",\n" +
                "        \"children\": [\n" +
                "            {\n" +
                "                \"title\": \"用户资料\",\n" +
                "                \"menuName\": \"info\",\n" +
                "                \"href\": \"/info\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"明细导入\",\n" +
                "        \"menuName\": \"export\",\n" +
                "        \"icon\": \"layui-icon-template-1\",\n" +
                "        \"href\": \"/export\"\n" +
                "    }\n" +
                "]";

        return string;
    }

    @RequestMapping("/home/console")
    public String console() {
        return "/home/console";
    }
}
