// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TShoucangjilu;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TShoucangjiluDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String USERNAME = "username";
    public static final String XWID = "xwid";
    public static final String ZIDUAN = "ziduan";
    public static final String BIAO = "biao";
    
    static {
        TShoucangjiluDAO.log = LogFactory.getLog((Class)TShoucangjiluDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TShoucangjilu transientInstance) {
        TShoucangjiluDAO.log.debug((Object)"saving TShoucangjilu instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TShoucangjiluDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TShoucangjilu persistentInstance) {
        TShoucangjiluDAO.log.debug((Object)"deleting TShoucangjilu instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TShoucangjiluDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TShoucangjilu findById(final Integer id) {
        TShoucangjiluDAO.log.debug((Object)("getting TShoucangjilu instance with id: " + id));
        try {
            final TShoucangjilu instance = (TShoucangjilu)this.getHibernateTemplate().get("com.model.TShoucangjilu", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TShoucangjilu instance) {
        TShoucangjiluDAO.log.debug((Object)"finding TShoucangjilu instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TShoucangjiluDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TShoucangjiluDAO.log.debug((Object)"finding all TShoucangjilu instances");
        try {
            final String queryString = "from TShoucangjilu";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TShoucangjilu merge(final TShoucangjilu detachedInstance) {
        TShoucangjiluDAO.log.debug((Object)"merging TShoucangjilu instance");
        try {
            final TShoucangjilu result = (TShoucangjilu)this.getHibernateTemplate().merge((Object)detachedInstance);
            TShoucangjiluDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TShoucangjilu instance) {
        TShoucangjiluDAO.log.debug((Object)"attaching dirty TShoucangjilu instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TShoucangjiluDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TShoucangjilu instance) {
        TShoucangjiluDAO.log.debug((Object)"attaching clean TShoucangjilu instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TShoucangjiluDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TShoucangjiluDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TShoucangjiluDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TShoucangjiluDAO)ctx.getBean("TShoucangjiluDAO");
    }
}
