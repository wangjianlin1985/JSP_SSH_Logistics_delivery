// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TLiuyanban;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TLiuyanbanDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String CHENG = "cheng";
    public static final String XINGBIE = "xingbie";
    public static final String QQ = "QQ";
    public static final String YOUXIANG = "youxiang";
    public static final String DIANHUA = "dianhua";
    public static final String NEIRONG = "neirong";
    public static final String HUIFUNEIRONG = "huifuneirong";
    
    static {
        TLiuyanbanDAO.log = LogFactory.getLog((Class)TLiuyanbanDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TLiuyanban transientInstance) {
        TLiuyanbanDAO.log.debug((Object)"saving TLiuyanban instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TLiuyanbanDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TLiuyanban persistentInstance) {
        TLiuyanbanDAO.log.debug((Object)"deleting TLiuyanban instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TLiuyanbanDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TLiuyanban findById(final Integer id) {
        TLiuyanbanDAO.log.debug((Object)("getting TLiuyanban instance with id: " + id));
        try {
            final TLiuyanban instance = (TLiuyanban)this.getHibernateTemplate().get("com.model.TLiuyanban", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TLiuyanban instance) {
        TLiuyanbanDAO.log.debug((Object)"finding TLiuyanban instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TLiuyanbanDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TLiuyanbanDAO.log.debug((Object)"finding all TLiuyanban instances");
        try {
            final String queryString = "from TLiuyanban";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TLiuyanban merge(final TLiuyanban detachedInstance) {
        TLiuyanbanDAO.log.debug((Object)"merging TLiuyanban instance");
        try {
            final TLiuyanban result = (TLiuyanban)this.getHibernateTemplate().merge((Object)detachedInstance);
            TLiuyanbanDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TLiuyanban instance) {
        TLiuyanbanDAO.log.debug((Object)"attaching dirty TLiuyanban instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TLiuyanbanDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TLiuyanban instance) {
        TLiuyanbanDAO.log.debug((Object)"attaching clean TLiuyanban instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TLiuyanbanDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TLiuyanbanDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TLiuyanbanDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TLiuyanbanDAO)ctx.getBean("TLiuyanbanDAO");
    }
}
