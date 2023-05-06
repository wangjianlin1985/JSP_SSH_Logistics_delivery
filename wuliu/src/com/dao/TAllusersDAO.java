// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TAllusers;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TAllusersDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String USERNAME = "username";
    public static final String PWD = "pwd";
    public static final String CX = "cx";
    
    static {
        TAllusersDAO.log = LogFactory.getLog((Class)TAllusersDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TAllusers transientInstance) {
        TAllusersDAO.log.debug((Object)"saving TAllusers instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TAllusersDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TAllusers persistentInstance) {
        TAllusersDAO.log.debug((Object)"deleting TAllusers instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TAllusersDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TAllusers findById(final Integer id) {
        TAllusersDAO.log.debug((Object)("getting TAllusers instance with id: " + id));
        try {
            final TAllusers instance = (TAllusers)this.getHibernateTemplate().get("com.model.TAllusers", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TAllusers instance) {
        TAllusersDAO.log.debug((Object)"finding TAllusers instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TAllusersDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByProperty(final String propertyName, final Object value) {
        TAllusersDAO.log.debug((Object)("finding TAllusers instance with property: " + propertyName + ", value: " + value));
        try {
            final String queryString = "from TAllusers as model where model." + propertyName + "= ?";
            return this.getHibernateTemplate().find(queryString, value);
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"find by property name failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByUsername(final Object username) {
        return this.findByProperty("username", username);
    }
    
    public List findByPwd(final Object pwd) {
        return this.findByProperty("pwd", pwd);
    }
    
    public List findAll() {
        TAllusersDAO.log.debug((Object)"finding all TAllusers instances");
        try {
            final String queryString = "from TAllusers";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TAllusers merge(final TAllusers detachedInstance) {
        TAllusersDAO.log.debug((Object)"merging TAllusers instance");
        try {
            final TAllusers result = (TAllusers)this.getHibernateTemplate().merge((Object)detachedInstance);
            TAllusersDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TAllusers instance) {
        TAllusersDAO.log.debug((Object)"attaching dirty TAllusers instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TAllusersDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TAllusers instance) {
        TAllusersDAO.log.debug((Object)"attaching clean TAllusers instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TAllusersDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TAllusersDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TAllusersDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TAllusersDAO)ctx.getBean("TAllusersDAO");
    }
}
