//package cn.llyong.conf.web.controller;
//
//import cn.llyong.pms.common.PageResponse;
//import cn.llyong.pms.common.enums.TypeEnum;
//import cn.llyong.pms.common.vo.Result;
//import cn.llyong.pms.domain.PmCode;
//import cn.llyong.pms.domain.PmCode;
//import cn.llyong.pms.domain.PmType;
//import cn.llyong.pms.service.CodeService;
//import cn.llyong.pms.service.TypeService;
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
// * @description:
// * @author: llyong
// * @date: 2019/12/15
// * @time: 16:05
// * @version: 1.0
// */
//@Controller
//@RequestMapping("/dict/code/")
//public class CodeController {
//
//    @Autowired
//    private CodeService codeService;
//    @Autowired
//    private TypeService typeService;
//
//    /**
//     * 列表页面
//     * @return
//     */
//    @RequestMapping("list")
//    public String list(Model model) {
//        List<PmCode> statusList = codeService.codeList(TypeEnum.TYPE_ENUM_STATUS.getType());
//        model.addAttribute("statusList", statusList);
//        List<PmType> typeList = typeService.typeList();
//        model.addAttribute("typeList", typeList);
//        return "/dict/code/list";
//    }
//
//    /**
//     * 列表页面--表数据
//     * @param page
//     * @param limit
//     * @param pmCode
//     * @return
//     */
//    @RequestMapping("getPageList")
//    @ResponseBody
//    public PageResponse<PmCode> getPageList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, PmCode pmCode) {
//        PageResponse<PmCode> pageResponse = codeService.getPageCodeList(page, limit, pmCode);
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
//        List<PmType> list = typeService.typeList();
//        if ( null != id) {
//            PmCode pmCode = codeService.findById(id);
//            model.addAttribute("pmCode", pmCode);
//        } else {
//            model.addAttribute("pmCode", new PmCode());
//        }
//        model.addAttribute("typeList", list);
//        return "/dict/code/edit";
//    }
//
//    /**
//     * 保存
//     * @param pmCode
//     * @return
//     */
//    @RequestMapping("save")
//    @ResponseBody
//    public Result save(@RequestBody PmCode pmCode) {
//        Result result = codeService.save(pmCode);
//        return result;
//    }
//
//    /**
//     * 删除
//     * @param pmCode
//     * @return
//     */
//    @RequestMapping("del")
//    @ResponseBody
//    public Result del(@RequestBody PmCode pmCode) {
//        Result result = codeService.del(pmCode);
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
//    public Result batchDel(@RequestBody List<PmCode> list) {
//        Result result = codeService.batchDel(list);
//        return result;
//    }
//
//    /**
//     * 枚举下拉
//     * @param type
//     * @return
//     */
//    @RequestMapping("getCodeList")
//    @ResponseBody
//    public List<PmCode> getCodeList(String type) {
//        List<PmCode> list = codeService.codeList(type);
//        return list;
//    }
//}
