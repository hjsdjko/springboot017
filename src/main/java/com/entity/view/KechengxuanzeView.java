package com.entity.view;

import com.entity.KechengxuanzeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 课程选择
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-29 17:42:54
 */
@TableName("kechengxuanze")
public class KechengxuanzeView  extends KechengxuanzeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KechengxuanzeView(){
	}
 
 	public KechengxuanzeView(KechengxuanzeEntity kechengxuanzeEntity){
 	try {
			BeanUtils.copyProperties(this, kechengxuanzeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
