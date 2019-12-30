package cn.llyong.conf.web.common;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description:  自定义错误页面
 * @author: llyong
 * @date: 2019/12/11
 * @time: 10:34
 * @version: 1.0
 */
@Component
public class ErrorPageResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView();
        switch (status) {
            case NOT_FOUND:
                mv.setViewName("redirect:/error/404.html");
                break;
            default:
                mv.setViewName("redirect:/error/5xx.html");
        }
        return mv;
    }
}