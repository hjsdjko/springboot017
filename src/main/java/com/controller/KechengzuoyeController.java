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

import com.entity.KechengzuoyeEntity;
import com.entity.view.KechengzuoyeView;

import com.service.KechengzuoyeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程作业
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
@RestController
@RequestMapping("/kechengzuoye")
public class KechengzuoyeController {
    @Autowired
    private KechengzuoyeService kechengzuoyeService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengzuoyeEntity kechengzuoye,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kechengzuoye.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			kechengzuoye.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengzuoyeEntity> ew = new EntityWrapper<KechengzuoyeEntity>();

		PageUtils page = kechengzuoyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengzuoye), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengzuoyeEntity kechengzuoye, 
		HttpServletRequest request){
        EntityWrapper<KechengzuoyeEntity> ew = new EntityWrapper<KechengzuoyeEntity>();

		PageUtils page = kechengzuoyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengzuoye), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengzuoyeEntity kechengzuoye){
       	EntityWrapper<KechengzuoyeEntity> ew = new EntityWrapper<KechengzuoyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengzuoye, "kechengzuoye")); 
        return R.ok().put("data", kechengzuoyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengzuoyeEntity kechengzuoye){
        EntityWrapper< KechengzuoyeEntity> ew = new EntityWrapper< KechengzuoyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengzuoye, "kechengzuoye")); 
		KechengzuoyeView kechengzuoyeView =  kechengzuoyeService.selectView(ew);
		return R.ok("查询课程作业成功").put("data", kechengzuoyeView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengzuoyeEntity kechengzuoye = kechengzuoyeService.selectById(id);
        return R.ok().put("data", kechengzuoye);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengzuoyeEntity kechengzuoye = kechengzuoyeService.selectById(id);
        return R.ok().put("data", kechengzuoye);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengzuoyeEntity kechengzuoye, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengzuoye);
        kechengzuoyeService.insert(kechengzuoye);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengzuoyeEntity kechengzuoye, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengzuoye);
        kechengzuoyeService.insert(kechengzuoye);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengzuoyeEntity kechengzuoye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengzuoye);
        kechengzuoyeService.updateById(kechengzuoye);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengzuoyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
