// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TCheliangxinxi;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TCheliangxinxiDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String CHEPAIHAO = "chepaihao";
    public static final String JIASHIYUAN = "jiashiyuan";
    public static final String ZHUANGTAI = "zhuangtai";
    public static final String BEIZHU = "beizhu";
    
    static {
        TCheliangxinxiDAO.log = LogFactory.getLog((Class)TCheliangxinxiDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TCheliangxinxi transientInstance) {
        TCheliangxinxiDAO.log.debug((Object)"saving TCheliangxinxi instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TCheliangxinxiDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TCheliangxinxi persistentInstance) {
        TCheliangxinxiDAO.log.debug((Object)"deleting TCheliangxinxi instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TCheliangxinxiDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TCheliangxinxi findById(final Integer id) {
        TCheliangxinxiDAO.log.debug((Object)("getting TCheliangxinxi instance with id: " + id));
        try {
            final TCheliangxinxi instance = (TCheliangxinxi)this.getHibernateTemplate().get("com.model.TCheliangxinxi", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TCheliangxinxi instance) {
        TCheliangxinxiDAO.log.debug((Object)"finding TCheliangxinxi instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TCheliangxinxiDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TCheliangxinxiDAO.log.debug((Object)"finding all TCheliangxinxi instances");
        try {
            final String queryString = "from TCheliangxinxi";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TCheliangxinxi merge(final TCheliangxinxi detachedInstance) {
        TCheliangxinxiDAO.log.debug((Object)"merging TCheliangxinxi instance");
        try {
            final TCheliangxinxi result = (TCheliangxinxi)this.getHibernateTemplate().merge((Object)detachedInstance);
            TCheliangxinxiDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TCheliangxinxi instance) {
        TCheliangxinxiDAO.log.debug((Object)"attaching dirty TCheliangxinxi instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TCheliangxinxiDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TCheliangxinxi instance) {
        TCheliangxinxiDAO.log.debug((Object)"attaching clean TCheliangxinxi instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TCheliangxinxiDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TCheliangxinxiDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TCheliangxinxiDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TCheliangxinxiDAO)ctx.getBean("TCheliangxinxiDAO");
    }
}
