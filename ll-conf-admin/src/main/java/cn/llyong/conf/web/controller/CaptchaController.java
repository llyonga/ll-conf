package cn.llyong.conf.web.controller;

import cn.llyong.conf.web.common.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019-12-04
 * @time: 2:03 下午
 * @version: 1.0
 */
@Controller
public class CaptchaController {

    @RequestMapping("captcha")
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*
             1.生成验证码
             2.把验证码上的文本存在session中
             3.把验证码图片发送给客户端
             */
        CaptchaUtil captchaUtil = new CaptchaUtil();
        BufferedImage image = captchaUtil.getImage();
        request.getSession().setAttribute("captcha", captchaUtil.getText());
        captchaUtil.output(image, response.getOutputStream());
    }
}
