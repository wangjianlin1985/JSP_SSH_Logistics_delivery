// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TYouqinglianjie;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TYouqinglianjieDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String WANGZHANMINGCHENG = "wangzhanmingcheng";
    public static final String WANGZHI = "wangzhi";
    
    static {
        TYouqinglianjieDAO.log = LogFactory.getLog((Class)TYouqinglianjieDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TYouqinglianjie transientInstance) {
        TYouqinglianjieDAO.log.debug((Object)"saving TYouqinglianjie instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TYouqinglianjieDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TYouqinglianjie persistentInstance) {
        TYouqinglianjieDAO.log.debug((Object)"deleting TYouqinglianjie instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TYouqinglianjieDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TYouqinglianjie findById(final Integer id) {
        TYouqinglianjieDAO.log.debug((Object)("getting TYouqinglianjie instance with id: " + id));
        try {
            final TYouqinglianjie instance = (TYouqinglianjie)this.getHibernateTemplate().get("com.model.TYouqinglianjie", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TYouqinglianjie instance) {
        TYouqinglianjieDAO.log.debug((Object)"finding TYouqinglianjie instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TYouqinglianjieDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TYouqinglianjieDAO.log.debug((Object)"finding all TYouqinglianjie instances");
        try {
            final String queryString = "from TYouqinglianjie";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TYouqinglianjie merge(final TYouqinglianjie detachedInstance) {
        TYouqinglianjieDAO.log.debug((Object)"merging TYouqinglianjie instance");
        try {
            final TYouqinglianjie result = (TYouqinglianjie)this.getHibernateTemplate().merge((Object)detachedInstance);
            TYouqinglianjieDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TYouqinglianjie instance) {
        TYouqinglianjieDAO.log.debug((Object)"attaching dirty TYouqinglianjie instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TYouqinglianjieDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TYouqinglianjie instance) {
        TYouqinglianjieDAO.log.debug((Object)"attaching clean TYouqinglianjie instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TYouqinglianjieDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TYouqinglianjieDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TYouqinglianjieDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TYouqinglianjieDAO)ctx.getBean("TYouqinglianjieDAO");
    }
}
