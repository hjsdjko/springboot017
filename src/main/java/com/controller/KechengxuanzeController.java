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

import com.entity.KechengxuanzeEntity;
import com.entity.view.KechengxuanzeView;

import com.service.KechengxuanzeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程选择
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
@RestController
@RequestMapping("/kechengxuanze")
public class KechengxuanzeController {
    @Autowired
    private KechengxuanzeService kechengxuanzeService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengxuanzeEntity kechengxuanze,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kechengxuanze.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			kechengxuanze.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengxuanzeEntity> ew = new EntityWrapper<KechengxuanzeEntity>();

		PageUtils page = kechengxuanzeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengxuanze), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengxuanzeEntity kechengxuanze, 
		HttpServletRequest request){
        EntityWrapper<KechengxuanzeEntity> ew = new EntityWrapper<KechengxuanzeEntity>();

		PageUtils page = kechengxuanzeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengxuanze), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengxuanzeEntity kechengxuanze){
       	EntityWrapper<KechengxuanzeEntity> ew = new EntityWrapper<KechengxuanzeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengxuanze, "kechengxuanze")); 
        return R.ok().put("data", kechengxuanzeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengxuanzeEntity kechengxuanze){
        EntityWrapper< KechengxuanzeEntity> ew = new EntityWrapper< KechengxuanzeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengxuanze, "kechengxuanze")); 
		KechengxuanzeView kechengxuanzeView =  kechengxuanzeService.selectView(ew);
		return R.ok("查询课程选择成功").put("data", kechengxuanzeView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengxuanzeEntity kechengxuanze = kechengxuanzeService.selectById(id);
        return R.ok().put("data", kechengxuanze);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengxuanzeEntity kechengxuanze = kechengxuanzeService.selectById(id);
        return R.ok().put("data", kechengxuanze);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengxuanzeEntity kechengxuanze, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengxuanze);
        kechengxuanzeService.insert(kechengxuanze);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengxuanzeEntity kechengxuanze, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengxuanze);
        kechengxuanzeService.insert(kechengxuanze);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengxuanzeEntity kechengxuanze, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengxuanze);
        kechengxuanzeService.updateById(kechengxuanze);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengxuanzeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
