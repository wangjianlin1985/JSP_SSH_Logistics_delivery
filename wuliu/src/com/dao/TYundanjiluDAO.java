// 
// 
// 

package com.dao;

import org.springframework.context.ApplicationContext;
import org.hibernate.LockMode;
import java.util.List;
import java.io.Serializable;
import com.model.TYundanjilu;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TYundanjiluDAO extends HibernateDaoSupport
{
    private static Log log;
    public static final String KUAIDIDANHAO = "kuaididanhao";
    public static final String MUDEDI = "mudedi";
    public static final String SHOUJIANREN = "shoujianren";
    public static final String SHOUJIANDIANHUA = "shoujiandianhua";
    public static final String YONGHUMING = "yonghuming";
    public static final String XINGMING = "xingming";
    public static final String DIANHUA = "dianhua";
    public static final String WUPINMINGCHENG = "wupinmingcheng";
    public static final String KUAIDIFEIYONG = "kuaidifeiyong";
    public static final String YUNDANZHUANGTAI = "yundanzhuangtai";
    public static final String YUNSONGCHELIANG = "yunsongcheliang";
    public static final String BEIZHU = "beizhu";
    public static final String WANGDIANBIANHAO = "wangdianbianhao";
    
    static {
        TYundanjiluDAO.log = LogFactory.getLog((Class)TYundanjiluDAO.class);
    }
    
    protected void initDao() {
    }
    
    public void save(final TYundanjilu transientInstance) {
        TYundanjiluDAO.log.debug((Object)"saving TYundanjilu instance");
        try {
            this.getHibernateTemplate().save((Object)transientInstance);
            TYundanjiluDAO.log.debug((Object)"save successful");
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"save failed", (Throwable)re);
            throw re;
        }
    }
    
    public void delete(final TYundanjilu persistentInstance) {
        TYundanjiluDAO.log.debug((Object)"deleting TYundanjilu instance");
        try {
            this.getHibernateTemplate().delete((Object)persistentInstance);
            TYundanjiluDAO.log.debug((Object)"delete successful");
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"delete failed", (Throwable)re);
            throw re;
        }
    }
    
    public TYundanjilu findById(final Integer id) {
        TYundanjiluDAO.log.debug((Object)("getting TYundanjilu instance with id: " + id));
        try {
            final TYundanjilu instance = (TYundanjilu)this.getHibernateTemplate().get("com.model.TYundanjilu", (Serializable)id);
            return instance;
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"get failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findByExample(final TYundanjilu instance) {
        TYundanjiluDAO.log.debug((Object)"finding TYundanjilu instance by example");
        try {
            final List results = this.getHibernateTemplate().findByExample((Object)instance);
            TYundanjiluDAO.log.debug((Object)("find by example successful, result size: " + results.size()));
            return results;
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"find by example failed", (Throwable)re);
            throw re;
        }
    }
    
    public List findAll() {
        TYundanjiluDAO.log.debug((Object)"finding all TYundanjilu instances");
        try {
            final String queryString = "from TYundanjilu";
            return this.getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"find all failed", (Throwable)re);
            throw re;
        }
    }
    
    public TYundanjilu merge(final TYundanjilu detachedInstance) {
        TYundanjiluDAO.log.debug((Object)"merging TYundanjilu instance");
        try {
            final TYundanjilu result = (TYundanjilu)this.getHibernateTemplate().merge((Object)detachedInstance);
            TYundanjiluDAO.log.debug((Object)"merge successful");
            return result;
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"merge failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachDirty(final TYundanjilu instance) {
        TYundanjiluDAO.log.debug((Object)"attaching dirty TYundanjilu instance");
        try {
            this.getHibernateTemplate().saveOrUpdate((Object)instance);
            TYundanjiluDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public void attachClean(final TYundanjilu instance) {
        TYundanjiluDAO.log.debug((Object)"attaching clean TYundanjilu instance");
        try {
            this.getHibernateTemplate().lock((Object)instance, LockMode.NONE);
            TYundanjiluDAO.log.debug((Object)"attach successful");
        }
        catch (RuntimeException re) {
            TYundanjiluDAO.log.error((Object)"attach failed", (Throwable)re);
            throw re;
        }
    }
    
    public static TYundanjiluDAO getFromApplicationContext(final ApplicationContext ctx) {
        return (TYundanjiluDAO)ctx.getBean("TYundanjiluDAO");
    }
}
