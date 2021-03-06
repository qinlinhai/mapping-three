package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.SpecialPost;
import com.qwz.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:27
 */
@RestController
public class SpecialPostController extends CommonController {

    @Autowired
    private SpecialPostService specialPostService;

    public BaseService getBaseService() {
        return specialPostService;
    }

    /**
     * @Description: 根据userid查询特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/17 16:29
     **/
    @PostMapping("/selectSpecial")
    public ResultData selectSpecial(@RequestParam("userid") Integer userid,@RequestParam("pageNumber") Integer pageNumber,
                                    @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = specialPostService.selectSpecial(userid, pageNumber, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 根据id查询特殊人员基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:36
     **/
    @PostMapping("/selectIdSpecial")
    public ResultData selectIdSpecial(@RequestParam("id") Long id){
        List<SpecialPost> specialPosts = specialPostService.selectIdSpecial(id);
        if (specialPosts != null && !"".equals(specialPosts)){
            return super.selectSuccess(specialPosts);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 添加特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/20 21:29
     **/
    @PostMapping("/insertSpecial")
    public ResultData insertSpecial(@RequestBody SpecialPost specialPost,@RequestParam("path") String path,
                                    @RequestParam("userid") Long userid){
        Boolean aBoolean = specialPostService.insertSpecial(specialPost, path, userid);
        if (aBoolean){
            return super.addSuccess(aBoolean);
        }else {
            return super.addFailed();
        }
    }

    /**
     * @Description: 修改特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/20 21:30
     **/
    @PostMapping("/updateSpecial")
    public ResultData updateSpecial(@RequestBody SpecialPost specialPost){
        Boolean aBoolean = specialPostService.updateSpecial(specialPost);
        if (aBoolean){
            return super.updateSuccess(aBoolean);
        }else {
            return super.updateFailed();
        }
    }

    /**
     * @Description: 删除特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/20 21:32
     **/
    @PostMapping("/deleteSpecial")
    public ResultData deleteSpecial(@RequestParam("id") Long id){
        Integer integer = specialPostService.deleteSpecial(id);
        if (integer > 0){
            return super.deleteSuccess(integer);
        }else {
            return super.deleteFailed();
        }
    }
}
