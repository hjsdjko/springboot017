package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KechengxuanzeDao;
import com.entity.KechengxuanzeEntity;
import com.service.KechengxuanzeService;
import com.entity.vo.KechengxuanzeVO;
import com.entity.view.KechengxuanzeView;

@Service("kechengxuanzeService")
public class KechengxuanzeServiceImpl extends ServiceImpl<KechengxuanzeDao, KechengxuanzeEntity> implements KechengxuanzeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengxuanzeEntity> page = this.selectPage(
                new Query<KechengxuanzeEntity>(params).getPage(),
                new EntityWrapper<KechengxuanzeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengxuanzeEntity> wrapper) {
		  Page<KechengxuanzeView> page =new Query<KechengxuanzeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KechengxuanzeVO> selectListVO(Wrapper<KechengxuanzeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KechengxuanzeVO selectVO(Wrapper<KechengxuanzeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KechengxuanzeView> selectListView(Wrapper<KechengxuanzeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengxuanzeView selectView(Wrapper<KechengxuanzeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
