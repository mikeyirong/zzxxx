package com.mk.module.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mk.module.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLogEntity> {
	
}
