// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TKuaidiwangdian;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TKuaidiwangdianDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String WANGDIANBIANHAO = "wangdianbianhao";
    public static final String MIMA = "mima";
    public static final String WANGDIANMINGCHENG = "wangdianmingcheng";
    public static final String FUZEREN = "fuzeren";
    public static final String LIANXIDIANHUA = "lianxidianhua";
    public static final String WANGDIANDIZHI = "wangdiandizhi";
    public static final String PAISONGFANWEI = "paisongfanwei";
    public static final String WANGDIANJIANJIE = "wangdianjianjie";
    public static final String ISSH = "issh";
    
    static {
        TKuaidiwangdianDAO.log = LogFactory.getLog((Class)TKuaidiwangdianDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TKuaidiwangdian transientInstance) {
        TKuaidiwangdianDAO.log.debug((Object)"saving TKuaidiwangdian instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TKuaidiwangdianDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TKuaidiwangdian persistentInstance) {
        TKuaidiwangdianDAO.log.debug((Object)"deleting TKuaidiwangdian instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TKuaidiwangdianDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TKuaidiwangdian findById(final Integer id) {
        TKuaidiwangdianDAO.log.debug((Object)("getting TKuaidiwangdian instance with id: " + id));
        try {
            final TKuaidiwangdian instance = (TKuaidiwangdian)this.getHibernateTemplate().get("com.model.TKuaidiwangdian", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TKuaidiwangdian instance) {
        TKuaidiwangdianDAO.log.debug((Object)"finding TKuaidiwangdian instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TKuaidiwangdianDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TKuaidiwangdianDAO.log.debug((Object)"finding all TKuaidiwangdian instances");
        try {
            final String queryString = "from TKuaidiwangdian";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TKuaidiwangdian merge(final TKuaidiwangdian detachedInstance) {
        TKuaidiwangdianDAO.log.debug((Object)"merging TKuaidiwangdian instance");
        try {
            final TKuaidiwangdian result = (TKuaidiwangdian)this.getHibernateTemplate().merge((Object)detachedInstance);
            TKuaidiwangdianDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TKuaidiwangdian instance) {
        TKuaidiwangdianDAO.log.debug((Object)"attaching dirty TKuaidiwangdian instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TKuaidiwangdianDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TKuaidiwangdian instance) {
        TKuaidiwangdianDAO.log.debug((Object)"attaching clean TKuaidiwangdian instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TKuaidiwangdianDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TKuaidiwangdianDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TKuaidiwangdianDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TKuaidiwangdianDAO)ctx.getBean("TKuaidiwangdianDAO");
    }
}
