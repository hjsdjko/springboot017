package com.dao;

import com.entity.TijiaozuoyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TijiaozuoyeVO;
import com.entity.view.TijiaozuoyeView;


/**
 * 提交作业
 * 
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
public interface TijiaozuoyeDao extends BaseMapper<TijiaozuoyeEntity> {
	
	List<TijiaozuoyeVO> selectListVO(@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);
	
	TijiaozuoyeVO selectVO(@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);
	
	List<TijiaozuoyeView> selectListView(@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);

	List<TijiaozuoyeView> selectListView(Pagination page,@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);

	
	TijiaozuoyeView selectView(@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);


    List<Map<String, Object>> xingmingzhuangtaiTypeStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TijiaozuoyeEntity> wrapper);

}
