// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TYonghuzhuce;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TYonghuzhuceDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String YONGHUMING = "yonghuming";
    public static final String MIMA = "mima";
    public static final String XINGMING = "xingming";
    public static final String XINGBIE = "xingbie";
    public static final String CHUSHENGNIANYUE = "chushengnianyue";
    public static final String QQ = "qq";
    public static final String YOUXIANG = "youxiang";
    public static final String DIANHUA = "dianhua";
    public static final String SHENFENZHENG = "shenfenzheng";
    public static final String TOUXIANG = "touxiang";
    public static final String DIZHI = "dizhi";
    public static final String BEIZHU = "beizhu";
    public static final String ISSH = "issh";
    
    static {
        TYonghuzhuceDAO.log = LogFactory.getLog((Class)TYonghuzhuceDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TYonghuzhuce transientInstance) {
        TYonghuzhuceDAO.log.debug((Object)"saving TYonghuzhuce instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TYonghuzhuceDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TYonghuzhuce persistentInstance) {
        TYonghuzhuceDAO.log.debug((Object)"deleting TYonghuzhuce instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TYonghuzhuceDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TYonghuzhuce findById(final Integer id) {
        TYonghuzhuceDAO.log.debug((Object)("getting TYonghuzhuce instance with id: " + id));
        try {
            final TYonghuzhuce instance = (TYonghuzhuce)this.getHibernateTemplate().get("com.model.TYonghuzhuce", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TYonghuzhuce instance) {
        TYonghuzhuceDAO.log.debug((Object)"finding TYonghuzhuce instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TYonghuzhuceDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByYonghuming(final String propertyYonghuming, final Object value) {
        TYonghuzhuceDAO.log.debug((Object)("finding TYonghuzhuce instance with yonghuming: " + propertyYonghuming + ", value: " + value));
        try {
            final String queryString = "from TYonghuzhuce as model where model." + propertyYonghuming + "= ?";
            return this.getHibernateTemplate().find(queryString, value);
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"find by property yonghuming failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByYonghuming(final Object yonghuming) {
        return this.findByYonghuming("yonghuming", yonghuming);
    }
    
    public List findAll() {
        TYonghuzhuceDAO.log.debug((Object)"finding all TYonghuzhuce instances");
        try {
            final String queryString = "from TYonghuzhuce";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TYonghuzhuce merge(final TYonghuzhuce detachedInstance) {
        TYonghuzhuceDAO.log.debug((Object)"merging TYonghuzhuce instance");
        try {
            final TYonghuzhuce result = (TYonghuzhuce)this.getHibernateTemplate().merge((Object)detachedInstance);
            TYonghuzhuceDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TYonghuzhuce instance) {
        TYonghuzhuceDAO.log.debug((Object)"attaching dirty TYonghuzhuce instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TYonghuzhuceDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TYonghuzhuce instance) {
        TYonghuzhuceDAO.log.debug((Object)"attaching clean TYonghuzhuce instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TYonghuzhuceDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TYonghuzhuceDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TYonghuzhuceDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TYonghuzhuceDAO)ctx.getBean("TYonghuzhuceDAO");
    }
}
