package com.mk.module.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mk.module.sys.entity.SysUserTokenEntity;

/**
 * 系统用户Token
 * 
 */
@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserTokenEntity> {
    
    SysUserTokenEntity queryByUserId(Long userId);

    SysUserTokenEntity queryByToken(String token);
	
}
