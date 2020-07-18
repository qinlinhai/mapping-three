package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.CheckpersonMapper;
import com.qwz.model.CheckPerson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/16 16:10
 */
@Service
@Slf4j
public class CheckPersonService extends BaseService<CheckPerson> {

    @Autowired
    private CheckpersonMapper checkpersonMapper;

    /**
     * @Description: 查询抽查人员名单
     * @Author: Bing
     * @Date: 2020/7/16 16:12
     **/
    public PageInfo selectCheckPerson(double random,Integer pageNumber,Integer pageSize){
        //判断前端是否获取值
            //获取表中总数据
            int hang = checkpersonMapper.selectHang();
            //获取应展示的数据条数
            int random1 = (int)Math.ceil(random * hang);
            Integer random2=random1;
            PageHelper.startPage(pageNumber,pageSize);
            List<CheckPerson> checkPeople = checkpersonMapper.selectCheckPerson(random2);
            PageInfo<CheckPerson> checkPersonPageInfo = new PageInfo<CheckPerson>(checkPeople);
            if (null != checkPersonPageInfo && !"".equals(checkPersonPageInfo)){
                return checkPersonPageInfo;
            }
        return null;
    }

    /**
     * @Description: 添加抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:41
     **/
    public Integer insertCheckPerson(CheckPerson checkPerson){
        if (checkPerson != null && !"".equals(checkPerson)){
            int i = checkpersonMapper.insertSelective(checkPerson);
                if (i > 0){
                    return i;
                }
        }
        return -1;
    }

    /**
     * @Description: 修改抽查人员信息
     * @Author: Bing
     * @Date: 2020/7/16 16:50
     **/
    public Integer updateCheckPerson(CheckPerson checkPerson){
        if (checkPerson != null && !"".equals(checkPerson)){
            int i = checkpersonMapper.updateByPrimaryKey(checkPerson);
            if (i > 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * @Description: 删除抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:50
     **/
    public Integer delectCheckPerson(String id){
        return checkpersonMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Description: 批量删除抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:53
     **/
    public Integer delectListCheckPerson(List<Integer> ids){
        Integer integer = super.deleteByIds(ids);
        if (integer > 0){
            return integer;
        }
        return -1;
    }
}
