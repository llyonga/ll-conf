//package cn.llyong.conf.web.controller;
//
//import cn.llyong.pms.common.vo.Result;
//import cn.llyong.pms.domain.PmUser;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @description:
// * @author: lvyong
// * @date: 2019-12-04
// * @time: 11:12 上午
// * @version: 1.0
// */
//@Slf4j
//@Controller
//public class LoginController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//    /**
//     * 登录
//     * @return
//     */
//    @RequestMapping("login")
//    public String login() {
//        return "login";
//    }
//
//    /**
//     * 注册
//     * @return
//     */
//    @RequestMapping("register")
//    public String register() {
//        return "register";
//    }
//
//    @RequestMapping("logout")
//    @ResponseBody
//    public String logout() {
//        String str = "{\n" +
//                "  \"code\": 0\n" +
//                "  ,\"msg\": \"退出成功\"\n" +
//                "  ,\"data\": null\n" +
//                "}";
//        return str;
//    }
//
//    @RequestMapping("doLogin")
//    @ResponseBody
//    public Result doLogin(HttpServletRequest request, PmUser user) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//
//
//        try{
//            //使用SpringSecurity拦截登陆请求 进行认证和授权
//            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//
//            SecurityContextHolder.getContext().setAuthentication(authenticate);
//            //使用redis session共享
//            HttpSession session = request.getSession();
//            // 这个非常重要，否则验证后将无法登陆
//            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
//        }catch (Exception e){
//            log.error("登录失败-->{}", e.getMessage());
//            return new Result(1, "登录失败");
//        }
//
////        String str = "{\n" +
////                "  \"code\": 0\n" +
////                "  ,\"msg\": \"登入成功\"\n" +
////                "  ,\"data\": {\n" +
////                "    \"access_token\": \"c262e61cd13ad99fc650e6908c7e5e65b63d2f32185ecfed6b801ee3fbdd5c0a\"\n" +
////                "  }\n" +
////                "}";
//        return new Result(0, "登入成功");
//    }
//
//    @RequestMapping("doRegister")
//    @ResponseBody
//    public String doRegister() {
//        String str = "{\n" +
//                "  \"code\": 0\n" +
//                "  ,\"msg\": \"注册成功\"\n" +
//                "  ,\"data\": {\n" +
//                "    \n" +
//                "  }\n" +
//                "}";
//        return str;
//    }
//
//    @RequestMapping("forget")
//    public String forget() {
//        return "forget";
//    }
//
//}
