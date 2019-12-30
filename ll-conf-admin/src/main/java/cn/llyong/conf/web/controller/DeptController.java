//package cn.llyong.conf.web.controller;
//
//import cn.llyong.pms.bo.DeptInfo;
//import cn.llyong.pms.common.vo.Result;
//import cn.llyong.pms.domain.PmDept;
//import cn.llyong.pms.service.DeptService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
///**
// * @description:
// * @author: llyong
// * @date: 2019/12/14
// * @time: 22:06
// * @version: 1.0
// */
//@Slf4j
//@Controller
//@RequestMapping("dept")
//public class DeptController {
//
//    @Autowired
//    private DeptService deptService;
//
//    @RequestMapping("list")
//    public String list() {
//        return "/dept/list";
//    }
//
//    /**
//     * 获取所有的部门树
//     * @return
//     */
//    @RequestMapping("findDeptList")
//    @ResponseBody
//    public List<DeptInfo> findDeptList() {
//        List<DeptInfo> deptList = deptService.findDeptList();
//        return deptList;
//    }
//
//    /**
//     * 编辑页面
//     * @return
//     */
//    @RequestMapping("edit")
//    public String edit(@RequestParam("id") String id, @RequestParam("type") String type, Model model) {
//        PmDept pmDept = deptService.findByDeptId(id);
//        if ("edit".equals(type)) {
//            model.addAttribute("dept", pmDept);
//        } else {
//            PmDept dept = new PmDept();
//            dept.setParentId(pmDept.getDeptId());
//            dept.setParentName(pmDept.getDeptName());
//            dept.setLevel(pmDept.getLevel().intValue() + 1);
//            model.addAttribute("dept", dept);
//        }
//        return "/dept/edit";
//    }
//
//    /**
//     * 保存
//     * @param pmDept
//     * @return
//     */
//    @RequestMapping("save")
//    @ResponseBody
//    public Result save(@RequestBody PmDept pmDept) {
//        Result result = deptService.save(pmDept);
//        return result;
//    }
//
//    /**
//     * 删除
//     * @param dept
//     * @return
//     */
//    @RequestMapping("del")
//    @ResponseBody
//    public Result del(@RequestBody PmDept dept) {
//        Result result = deptService.del(dept);
//        return result;
//    }
//}
