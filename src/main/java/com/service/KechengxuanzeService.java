package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KechengxuanzeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KechengxuanzeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KechengxuanzeView;


/**
 * 课程选择
 *
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
public interface KechengxuanzeService extends IService<KechengxuanzeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengxuanzeVO> selectListVO(Wrapper<KechengxuanzeEntity> wrapper);
   	
   	KechengxuanzeVO selectVO(@Param("ew") Wrapper<KechengxuanzeEntity> wrapper);
   	
   	List<KechengxuanzeView> selectListView(Wrapper<KechengxuanzeEntity> wrapper);
   	
   	KechengxuanzeView selectView(@Param("ew") Wrapper<KechengxuanzeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengxuanzeEntity> wrapper);

   	

}

