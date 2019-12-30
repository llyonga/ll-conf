//package cn.llyong.conf.web.controller;
//
//import cn.llyong.conf.web.common.PageResponse ;
//import cn.llyong.conf.web.common.vo.Result;
////import cn.llyong.conf.web.domain.PmUser;
//import cn.llyong.conf.web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @description:
// * @author: lvyong
// * @date: 2019-12-05
// * @time: 10:21 上午
// * @version: 1.0
// */
//@Controller
//@RequestMapping("user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 跳转到列表页面
//     * @return
//     */
//    @RequestMapping("list")
//    public String list() {
//        return "/user/list";
//    }
//
//    /**
//     * 加载列表数据  user/getUserList?page=1&limit=30
//     * @return
//     */
//    @RequestMapping("getUserList")
//    @ResponseBody
//    public PageResponse<PmUser> getUserList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, PmUser pmUser) {
//        PageResponse<PmUser> pageResponse = userService.getUserList(page, limit, pmUser);
//        return pageResponse;
//    }
//
//    /**
//     * 新增/修改页面
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping("/turn/add")
//    public String turnAdd(Long id, Model model) {
//        if ( null != id) {
//            PmUser pmUser = userService.findById(id);
//            model.addAttribute("pmUser", pmUser);
//        } else {
//            model.addAttribute("pmUser", new PmUser());
//        }
//        return "/user/edit";
//    }
//
//    /**
//     * 保存
//     * @param pmUser
//     * @return
//     */
//    @RequestMapping("save")
//    @ResponseBody
//    public Result save(@RequestBody PmUser pmUser) {
//        Result result = userService.save(pmUser);
//        return result;
//    }
//
//    /**
//     * 删除
//     * @param pmUser
//     * @return
//     */
//    @RequestMapping("del")
//    @ResponseBody
//    public Result del(@RequestBody PmUser pmUser) {
//        Result result = userService.del(pmUser);
//        return result;
//    }
//
//    /**
//     * 批量删除
//     * @param list
//     * @return
//     */
//    @RequestMapping("batchDel")
//    @ResponseBody
//    public Result batchDel(@RequestBody List<PmUser> list) {
//        Result result = userService.batchDel(list);
//        return result;
//    }
//}
//
