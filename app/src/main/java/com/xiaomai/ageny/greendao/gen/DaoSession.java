package com.xiaomai.ageny.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.xiaomai.ageny.bean.daobean.DeviceDao;

import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig deviceDaoDaoConfig;

    private final DeviceDaoDao deviceDaoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        deviceDaoDaoConfig = daoConfigMap.get(DeviceDaoDao.class).clone();
        deviceDaoDaoConfig.initIdentityScope(type);

        deviceDaoDao = new DeviceDaoDao(deviceDaoDaoConfig, this);

        registerDao(DeviceDao.class, deviceDaoDao);
    }
    
    public void clear() {
        deviceDaoDaoConfig.clearIdentityScope();
    }

    public DeviceDaoDao getDeviceDaoDao() {
        return deviceDaoDao;
    }

}
