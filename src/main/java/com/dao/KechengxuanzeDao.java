package com.dao;

import com.entity.KechengxuanzeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechengxuanzeVO;
import com.entity.view.KechengxuanzeView;


/**
 * 课程选择
 * 
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
public interface KechengxuanzeDao extends BaseMapper<KechengxuanzeEntity> {
	
	List<KechengxuanzeVO> selectListVO(@Param("ew") Wrapper<KechengxuanzeEntity> wrapper);
	
	KechengxuanzeVO selectVO(@Param("ew") Wrapper<KechengxuanzeEntity> wrapper);
	
	List<KechengxuanzeView> selectListView(@Param("ew") Wrapper<KechengxuanzeEntity> wrapper);

	List<KechengxuanzeView> selectListView(Pagination page,@Param("ew") Wrapper<KechengxuanzeEntity> wrapper);

	
	KechengxuanzeView selectView(@Param("ew") Wrapper<KechengxuanzeEntity> wrapper);
	

}
