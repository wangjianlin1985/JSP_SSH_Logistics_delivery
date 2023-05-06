// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TXinwentongzhi;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TXinwentongzhiDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String BIAOTI = "biaoti";
    public static final String LEIBIE = "leibie";
    public static final String NEIRONG = "neirong";
    public static final String SHOUYETUPIAN = "shouyetupian";
    public static final String DIANJILV = "dianjilv";
    public static final String TIANJIAREN = "tianjiaren";
    
    static {
        TXinwentongzhiDAO.log = LogFactory.getLog((Class)TXinwentongzhiDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TXinwentongzhi transientInstance) {
        TXinwentongzhiDAO.log.debug((Object)"saving TXinwentongzhi instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TXinwentongzhiDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TXinwentongzhi persistentInstance) {
        TXinwentongzhiDAO.log.debug((Object)"deleting TXinwentongzhi instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TXinwentongzhiDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TXinwentongzhi findById(final Integer id) {
        TXinwentongzhiDAO.log.debug((Object)("getting TXinwentongzhi instance with id: " + id));
        try {
            final TXinwentongzhi instance = (TXinwentongzhi)this.getHibernateTemplate().get("com.model.TXinwentongzhi", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TXinwentongzhi instance) {
        TXinwentongzhiDAO.log.debug((Object)"finding TXinwentongzhi instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TXinwentongzhiDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TXinwentongzhiDAO.log.debug((Object)"finding all TXinwentongzhi instances");
        try {
            final String queryString = "from TXinwentongzhi";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TXinwentongzhi merge(final TXinwentongzhi detachedInstance) {
        TXinwentongzhiDAO.log.debug((Object)"merging TXinwentongzhi instance");
        try {
            final TXinwentongzhi result = (TXinwentongzhi)this.getHibernateTemplate().merge((Object)detachedInstance);
            TXinwentongzhiDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TXinwentongzhi instance) {
        TXinwentongzhiDAO.log.debug((Object)"attaching dirty TXinwentongzhi instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TXinwentongzhiDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TXinwentongzhi instance) {
        TXinwentongzhiDAO.log.debug((Object)"attaching clean TXinwentongzhi instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TXinwentongzhiDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TXinwentongzhiDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TXinwentongzhiDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TXinwentongzhiDAO)ctx.getBean("TXinwentongzhiDAO");
    }
}
