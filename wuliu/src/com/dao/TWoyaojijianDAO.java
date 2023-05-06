// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TWoyaojijian;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TWoyaojijianDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String WANGDIANBIANHAO = "wangdianbianhao";
    public static final String WUPINMINGCHENG = "wupinmingcheng";
    public static final String WUPINZHONGLIANG = "wupinzhongliang";
    public static final String MUDEDI = "mudedi";
    public static final String SHOUJIANREN = "shoujianren";
    public static final String SHOUJIANDIANHUA = "shoujiandianhua";
    public static final String BEIZHU = "beizhu";
    public static final String YONGHUMING = "yonghuming";
    public static final String XINGMING = "xingming";
    public static final String DIANHUA = "dianhua";
    public static final String DIZHI = "dizhi";
    public static final String ISSH = "issh";
    
    static {
        TWoyaojijianDAO.log = LogFactory.getLog((Class)TWoyaojijianDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TWoyaojijian transientInstance) {
        TWoyaojijianDAO.log.debug((Object)"saving TWoyaojijian instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TWoyaojijianDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TWoyaojijian persistentInstance) {
        TWoyaojijianDAO.log.debug((Object)"deleting TWoyaojijian instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TWoyaojijianDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TWoyaojijian findById(final Integer id) {
        TWoyaojijianDAO.log.debug((Object)("getting TWoyaojijian instance with id: " + id));
        try {
            final TWoyaojijian instance = (TWoyaojijian)this.getHibernateTemplate().get("com.model.TWoyaojijian", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TWoyaojijian instance) {
        TWoyaojijianDAO.log.debug((Object)"finding TWoyaojijian instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TWoyaojijianDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TWoyaojijianDAO.log.debug((Object)"finding all TWoyaojijian instances");
        try {
            final String queryString = "from TWoyaojijian";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TWoyaojijian merge(final TWoyaojijian detachedInstance) {
        TWoyaojijianDAO.log.debug((Object)"merging TWoyaojijian instance");
        try {
            final TWoyaojijian result = (TWoyaojijian)this.getHibernateTemplate().merge((Object)detachedInstance);
            TWoyaojijianDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TWoyaojijian instance) {
        TWoyaojijianDAO.log.debug((Object)"attaching dirty TWoyaojijian instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TWoyaojijianDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TWoyaojijian instance) {
        TWoyaojijianDAO.log.debug((Object)"attaching clean TWoyaojijian instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TWoyaojijianDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TWoyaojijianDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TWoyaojijianDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TWoyaojijianDAO)ctx.getBean("TWoyaojijianDAO");
    }
}
