package com.anyly.service.sys.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.anyly.mapper.SysConfigMapper;
import com.anyly.model.SysConfigDO;
import com.anyly.service.sys.SysConfigService;
import com.anyly.service.sys.bo.SysConfigBO;
import com.anyly.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    SysConfigMapper sysConfigMapper;
    @Override
    public List<SysConfigBO> select() {
        List<SysConfigDO> sysConfigDOS =sysConfigMapper.select();
        List<SysConfigBO> sysConfigBOList =BeanCopyUtil.listCopy(sysConfigDOS,SysConfigBO.class);
        return sysConfigBOList;
    }
}
