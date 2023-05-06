// 
// 
// 

package com.service;

import javax.servlet.http.HttpSession;
import org.directwebremoting.WebContext;
import java.util.List;
import com.model.TKuaidiwangdian;
import com.model.TYonghuzhuce;
import com.model.TAllusers;
import org.directwebremoting.WebContextFactory;
import com.dao.TKuaidiwangdianDAO;
import com.dao.TYonghuzhuceDAO;
import com.dao.TAllusersDAO;

public class loginService
{
    private TAllusersDAO allusersDAO;
    private TYonghuzhuceDAO yonghuzhuceDAO;
    private TKuaidiwangdianDAO kuaidiwangdianDAO;
    
    public TAllusersDAO getAllusersDAO() {
        return this.allusersDAO;
    }
    
    public void setAllusersDAO(final TAllusersDAO allusersDAO) {
        this.allusersDAO = allusersDAO;
    }
    
    public TYonghuzhuceDAO getYonghuzhuceDAO() {
        return this.yonghuzhuceDAO;
    }
    
    public void setYonghuzhuceDAO(final TYonghuzhuceDAO yonghuzhuceDAO) {
        this.yonghuzhuceDAO = yonghuzhuceDAO;
    }
    
    public TKuaidiwangdianDAO getKuaidiwangdianDAO() {
        return this.kuaidiwangdianDAO;
    }
    
    public void setKuaidiwangdianDAO(final TKuaidiwangdianDAO kuaidiwangdianDAO) {
        this.kuaidiwangdianDAO = kuaidiwangdianDAO;
    }
    
    public String login(final String userName, final String userPw, final String userType) {
        try {
            Thread.sleep(700L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = "no";
        if (userType.equals("\u7ba1\u7406\u5458")) {
            final String sql = "from TAllusers where username=? and pwd=?";
            final Object[] con = { userName, userPw };
            final List allusersList = this.allusersDAO.getHibernateTemplate().find(sql, con);
            if (allusersList.size() == 0) {
                result = "no";
            }
            else {
                final WebContext ctx = WebContextFactory.get();
                final HttpSession session = ctx.getSession();
                final TAllusers allusers = (TAllusers) allusersList.get(0);
                session.setAttribute("cx", (Object)allusers.getCx());
                session.setAttribute("userxinxi", (Object)allusers);
                session.setAttribute("username", (Object)userName);
                result = "yes";
            }
        }
        if (userType.equals("\u6ce8\u518c\u7528\u6237")) {
            final String sql = "from TYonghuzhuce where  yonghuming=? and mima=?";
            final Object[] con = { userName, userPw };
            final List yonghuzhuceList = this.yonghuzhuceDAO.getHibernateTemplate().find(sql, con);
            if (yonghuzhuceList.size() == 0) {
                result = "no";
            }
            else {
                final WebContext ctx = WebContextFactory.get();
                final HttpSession session = ctx.getSession();
                final TYonghuzhuce yonghuzhuce = (TYonghuzhuce) yonghuzhuceList.get(0);
                session.setAttribute("cx", (Object)userType);
                session.setAttribute("userxinxi", (Object)yonghuzhuce);
                session.setAttribute("username", (Object)userName);
                result = "yes";
            }
        }
        if (userType.equals("\u5feb\u9012\u7f51\u70b9")) {
            final String sql = "from TKuaidiwangdian where 3=3 and wangdianbianhao=? and mima=?";
            final Object[] con = { userName, userPw };
            final List kuaidiwangdianList = this.kuaidiwangdianDAO.getHibernateTemplate().find(sql, con);
            if (kuaidiwangdianList.size() == 0) {
                result = "no";
            }
            else {
                final WebContext ctx = WebContextFactory.get();
                final HttpSession session = ctx.getSession();
                final TKuaidiwangdian kuaidiwangdian = (TKuaidiwangdian) kuaidiwangdianList.get(0);
                session.setAttribute("cx", (Object)userType);
                session.setAttribute("userxinxi", (Object)kuaidiwangdian);
                session.setAttribute("username", (Object)userName);
                result = "yes";
            }
        }
        return result;
    }
    
    public String yonghuzhucePwEdit(final String userPwNew) {
        System.out.println("DDDD");
        try {
            Thread.sleep(700L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        final WebContext ctx = WebContextFactory.get();
        final HttpSession session = ctx.getSession();
        final TYonghuzhuce yonghuzhuce = (TYonghuzhuce)session.getAttribute("userxinxi");
        yonghuzhuce.setMima(userPwNew);
        this.yonghuzhuceDAO.getHibernateTemplate().update((Object)yonghuzhuce);
        session.setAttribute("yonghuzhuce", (Object)yonghuzhuce);
        return "yes";
    }
    
    public String allusersPwEdit(final String userPwNew) {
        System.out.println("DDDD");
        try {
            Thread.sleep(700L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        final WebContext ctx = WebContextFactory.get();
        final HttpSession session = ctx.getSession();
        final TAllusers allusers = (TAllusers)session.getAttribute("userxinxi");
        allusers.setPwd(userPwNew);
        this.allusersDAO.getHibernateTemplate().update((Object)allusers);
        session.setAttribute("allusers", (Object)allusers);
        return "yes";
    }
    
    public String kuaidiwangdianPwEdit(final String userPwNew) {
        System.out.println("DDDD");
        try {
            Thread.sleep(700L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        final WebContext ctx = WebContextFactory.get();
        final HttpSession session = ctx.getSession();
        final TKuaidiwangdian kuaidiwangdian = (TKuaidiwangdian)session.getAttribute("userxinxi");
        kuaidiwangdian.setMima(userPwNew);
        this.kuaidiwangdianDAO.getHibernateTemplate().update((Object)kuaidiwangdian);
        session.setAttribute("kuaidiwangdian", (Object)kuaidiwangdian);
        return "yes";
    }
    
    public String allusersjiance(final String userName) {
        final String sql = "from TAllusers where username='" + userName + "'";
        final List allusersList = this.allusersDAO.getHibernateTemplate().find(sql);
        if (allusersList.size() > 0) {
            return "Y";
        }
        return "N";
    }
    
    public String jiance(final String userName) {
        final String sql = "from TYonghuzhuce where yonghuming='" + userName + "'";
        final List yonghuzhuceList = this.yonghuzhuceDAO.getHibernateTemplate().find(sql);
        if (yonghuzhuceList.size() > 0) {
            return "Y";
        }
        return "N";
    }
}
