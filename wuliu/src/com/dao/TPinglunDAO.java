// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TPinglun;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TPinglunDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String XINWENID = "xinwenID";
    public static final String PINGLUNNEIRONG = "pinglunneirong";
    public static final String PINGLUNREN = "pinglunren";
    public static final String PINGFEN = "pingfen";
    public static final String BIAO = "biao";
    
    static {
        TPinglunDAO.log = LogFactory.getLog((Class)TPinglunDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TPinglun transientInstance) {
        TPinglunDAO.log.debug((Object)"saving TPinglun instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TPinglunDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TPinglun persistentInstance) {
        TPinglunDAO.log.debug((Object)"deleting TPinglun instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TPinglunDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TPinglun findById(final Integer id) {
        TPinglunDAO.log.debug((Object)("getting TPinglun instance with id: " + id));
        try {
            final TPinglun instance = (TPinglun)this.getHibernateTemplate().get("com.model.TPinglun", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TPinglun instance) {
        TPinglunDAO.log.debug((Object)"finding TPinglun instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TPinglunDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TPinglunDAO.log.debug((Object)"finding all TPinglun instances");
        try {
            final String queryString = "from TPinglun";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TPinglun merge(final TPinglun detachedInstance) {
        TPinglunDAO.log.debug((Object)"merging TPinglun instance");
        try {
            final TPinglun result = (TPinglun)this.getHibernateTemplate().merge((Object)detachedInstance);
            TPinglunDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TPinglun instance) {
        TPinglunDAO.log.debug((Object)"attaching dirty TPinglun instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TPinglunDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TPinglun instance) {
        TPinglunDAO.log.debug((Object)"attaching clean TPinglun instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TPinglunDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TPinglunDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TPinglunDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TPinglunDAO)ctx.getBean("TPinglunDAO");
    }
}
