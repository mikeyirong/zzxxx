package com.mk.module.sys.service;


import java.util.List;
import java.util.Map;
import com.mk.module.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 */
public interface SysLogService {
	
	SysLogEntity queryObject(Long id);
	
	List<SysLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysLogEntity sysLog);

	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}