package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZuoyepigaiEntity;
import com.entity.view.ZuoyepigaiView;

import com.service.ZuoyepigaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作业批改
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
@RestController
@RequestMapping("/zuoyepigai")
public class ZuoyepigaiController {
    @Autowired
    private ZuoyepigaiService zuoyepigaiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuoyepigaiEntity zuoyepigai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			zuoyepigai.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			zuoyepigai.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuoyepigaiEntity> ew = new EntityWrapper<ZuoyepigaiEntity>();

		PageUtils page = zuoyepigaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyepigai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuoyepigaiEntity zuoyepigai, 
		HttpServletRequest request){
        EntityWrapper<ZuoyepigaiEntity> ew = new EntityWrapper<ZuoyepigaiEntity>();

		PageUtils page = zuoyepigaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyepigai), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuoyepigaiEntity zuoyepigai){
       	EntityWrapper<ZuoyepigaiEntity> ew = new EntityWrapper<ZuoyepigaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoyepigai, "zuoyepigai")); 
        return R.ok().put("data", zuoyepigaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuoyepigaiEntity zuoyepigai){
        EntityWrapper< ZuoyepigaiEntity> ew = new EntityWrapper< ZuoyepigaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoyepigai, "zuoyepigai")); 
		ZuoyepigaiView zuoyepigaiView =  zuoyepigaiService.selectView(ew);
		return R.ok("查询作业批改成功").put("data", zuoyepigaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuoyepigaiEntity zuoyepigai = zuoyepigaiService.selectById(id);
        return R.ok().put("data", zuoyepigai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuoyepigaiEntity zuoyepigai = zuoyepigaiService.selectById(id);
        return R.ok().put("data", zuoyepigai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuoyepigaiEntity zuoyepigai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuoyepigai);
        zuoyepigaiService.insert(zuoyepigai);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuoyepigaiEntity zuoyepigai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zuoyepigai);
        zuoyepigaiService.insert(zuoyepigai);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuoyepigaiEntity zuoyepigai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoyepigai);
        zuoyepigaiService.updateById(zuoyepigai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuoyepigaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
