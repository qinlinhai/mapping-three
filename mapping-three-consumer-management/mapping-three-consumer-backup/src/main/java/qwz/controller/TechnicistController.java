package qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.service.IProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 19:49
 */
@RestController
public class TechnicistController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectTec")
    @ApiOperation(value = "分页查询技术人员信息",notes = "技术人员信息的查询")
    public ResultData selectTec(@RequestParam Integer userid, @RequestParam Integer pageNumber,
                                @RequestParam Integer pageSize){
        ResultData resultData = iProjectService.selectTec(userid, pageNumber, pageSize);
        return resultData;
    }

    @PostMapping("/selectOneTec")
    public ResultData selectOneTec(@RequestParam Long id){
        ResultData resultData = iProjectService.selectOneTec(id);
        return resultData;
    }
}