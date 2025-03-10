package com.entity.view;

import com.entity.ZuoyepigaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 作业批改
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
@TableName("zuoyepigai")
public class ZuoyepigaiView  extends ZuoyepigaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuoyepigaiView(){
	}
 
 	public ZuoyepigaiView(ZuoyepigaiEntity zuoyepigaiEntity){
 	try {
			BeanUtils.copyProperties(this, zuoyepigaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
