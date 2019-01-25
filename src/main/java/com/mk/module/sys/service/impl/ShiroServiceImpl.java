package com.mk.module.sys.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.common.utils.Constant;
import com.mk.module.sys.dao.SysMenuDao;
import com.mk.module.sys.dao.SysUserDao;
import com.mk.module.sys.dao.SysUserTokenDao;
import com.mk.module.sys.entity.SysMenuEntity;
import com.mk.module.sys.entity.SysUserEntity;
import com.mk.module.sys.entity.SysUserTokenEntity;
import com.mk.module.sys.service.ShiroService;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;

    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashMap<Object, Object>());
            permsList = new ArrayList<String>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    public SysUserEntity queryUser(Long userId) {
        return sysUserDao.queryObject(userId);
    }
}
