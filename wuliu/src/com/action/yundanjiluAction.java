// 
// 
// 

package com.action;

import java.util.ArrayList;
import com.util.db;
import com.util.Pagesize;
import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TYundanjilu;
import com.dao.TWoyaojijianDAO;
import com.dao.TYundanjiluDAO;
import java.util.List;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class yundanjiluAction extends ActionSupport
{
    private int id;
    private String kuaididanhao;
    private String mudedi;
    private String shoujianren;
    private String shoujiandianhua;
    private String yonghuming;
    private String xingming;
    private String dianhua;
    private String wupinmingcheng;
    private String kuaidifeiyong;
    private String yundanzhuangtai;
    private String yunsongcheliang;
    private String beizhu;
    private String wangdianbianhao;
    private String addtime;
    private String message;
    private String path;
    private ResultSet rs;
    private List list;
    private TYundanjiluDAO yundanjiluDAO;
    private TWoyaojijianDAO woyaojijianDAO;
    
    public String yundanjiluAdd() {
        final TYundanjilu yundanjilu = new TYundanjilu();
        yundanjilu.setKuaididanhao(this.kuaididanhao);
        yundanjilu.setMudedi(this.mudedi);
        yundanjilu.setShoujianren(this.shoujianren);
        yundanjilu.setShoujiandianhua(this.shoujiandianhua);
        yundanjilu.setYonghuming(this.yonghuming);
        yundanjilu.setXingming(this.xingming);
        yundanjilu.setDianhua(this.dianhua);
        yundanjilu.setWupinmingcheng(this.wupinmingcheng);
        yundanjilu.setKuaidifeiyong(this.kuaidifeiyong);
        yundanjilu.setYundanzhuangtai(this.yundanzhuangtai);
        yundanjilu.setYunsongcheliang(this.yunsongcheliang);
        yundanjilu.setBeizhu(this.beizhu);
        yundanjilu.setWangdianbianhao(this.wangdianbianhao);
        yundanjilu.setAddtime(this.addtime);
        this.yundanjiluDAO.save(yundanjilu);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01');history.back();</script>");
        return "msg";
    }
    
    public String yundanjiluList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TYundanjilu where 1=1 ";
        if (this.kuaididanhao != null) {
            sql = String.valueOf(sql) + " and kuaididanhao like '%" + this.kuaididanhao.trim() + "%'";
        }
        if (this.mudedi != null) {
            sql = String.valueOf(sql) + " and mudedi like '%" + this.mudedi.trim() + "%'";
        }
        if (this.shoujianren != null) {
            sql = String.valueOf(sql) + " and shoujianren like '%" + this.shoujianren.trim() + "%'";
        }
        if (this.shoujiandianhua != null) {
            sql = String.valueOf(sql) + " and shoujiandianhua like '%" + this.shoujiandianhua.trim() + "%'";
        }
        if (this.yonghuming != null) {
            sql = String.valueOf(sql) + " and yonghuming like '%" + this.yonghuming.trim() + "%'";
        }
        if (this.xingming != null) {
            sql = String.valueOf(sql) + " and xingming like '%" + this.xingming.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.wupinmingcheng != null) {
            sql = String.valueOf(sql) + " and wupinmingcheng like '%" + this.wupinmingcheng.trim() + "%'";
        }
        if (this.kuaidifeiyong != null) {
            sql = String.valueOf(sql) + " and kuaidifeiyong like '%" + this.kuaidifeiyong.trim() + "%'";
        }
        if (this.yundanzhuangtai != null) {
            sql = String.valueOf(sql) + " and yundanzhuangtai like '%" + this.yundanzhuangtai.trim() + "%'";
        }
        if (this.yunsongcheliang != null) {
            sql = String.valueOf(sql) + " and yunsongcheliang like '%" + this.yunsongcheliang.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List yundanjiluList = this.yundanjiluDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, yundanjiluList.size());
        final List yundanjiluList2 = yundanjiluList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(yundanjiluList.size());
        p.setData(yundanjiluList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String ydjlList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TYundanjilu where 1=1 ";
        if (this.kuaididanhao == null) {
            sql = String.valueOf(sql) + " and kuaididanhao = 'zzzzzzzzzzzzzzzzzz'";
        }
        if (this.kuaididanhao != null) {
            sql = String.valueOf(sql) + " and kuaididanhao like '%" + this.kuaididanhao.trim() + "%'";
        }
        if (this.mudedi != null) {
            sql = String.valueOf(sql) + " and mudedi like '%" + this.mudedi.trim() + "%'";
        }
        if (this.shoujianren != null) {
            sql = String.valueOf(sql) + " and shoujianren like '%" + this.shoujianren.trim() + "%'";
        }
        if (this.shoujiandianhua != null) {
            sql = String.valueOf(sql) + " and shoujiandianhua like '%" + this.shoujiandianhua.trim() + "%'";
        }
        if (this.yonghuming != null) {
            sql = String.valueOf(sql) + " and yonghuming like '%" + this.yonghuming.trim() + "%'";
        }
        if (this.xingming != null) {
            sql = String.valueOf(sql) + " and xingming like '%" + this.xingming.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.wupinmingcheng != null) {
            sql = String.valueOf(sql) + " and wupinmingcheng like '%" + this.wupinmingcheng.trim() + "%'";
        }
        if (this.kuaidifeiyong != null) {
            sql = String.valueOf(sql) + " and kuaidifeiyong like '%" + this.kuaidifeiyong.trim() + "%'";
        }
        if (this.yundanzhuangtai != null) {
            sql = String.valueOf(sql) + " and yundanzhuangtai like '%" + this.yundanzhuangtai.trim() + "%'";
        }
        if (this.yunsongcheliang != null) {
            sql = String.valueOf(sql) + " and yunsongcheliang like '%" + this.yunsongcheliang.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List yundanjiluList = this.yundanjiluDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, yundanjiluList.size());
        final List yundanjiluList2 = yundanjiluList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(yundanjiluList.size());
        p.setData(yundanjiluList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String yundanjiluList3() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TYundanjilu where wangdianbianhao='" + (String)request.getSession().getAttribute("username") + "' ";
        if (this.kuaididanhao != null) {
            sql = String.valueOf(sql) + " and kuaididanhao like '%" + this.kuaididanhao.trim() + "%'";
        }
        if (this.mudedi != null) {
            sql = String.valueOf(sql) + " and mudedi like '%" + this.mudedi.trim() + "%'";
        }
        if (this.shoujianren != null) {
            sql = String.valueOf(sql) + " and shoujianren like '%" + this.shoujianren.trim() + "%'";
        }
        if (this.shoujiandianhua != null) {
            sql = String.valueOf(sql) + " and shoujiandianhua like '%" + this.shoujiandianhua.trim() + "%'";
        }
        if (this.yonghuming != null) {
            sql = String.valueOf(sql) + " and yonghuming like '%" + this.yonghuming.trim() + "%'";
        }
        if (this.xingming != null) {
            sql = String.valueOf(sql) + " and xingming like '%" + this.xingming.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.wupinmingcheng != null) {
            sql = String.valueOf(sql) + " and wupinmingcheng like '%" + this.wupinmingcheng.trim() + "%'";
        }
        if (this.kuaidifeiyong != null) {
            sql = String.valueOf(sql) + " and kuaidifeiyong like '%" + this.kuaidifeiyong.trim() + "%'";
        }
        if (this.yundanzhuangtai != null) {
            sql = String.valueOf(sql) + " and yundanzhuangtai like '%" + this.yundanzhuangtai.trim() + "%'";
        }
        if (this.yunsongcheliang != null) {
            sql = String.valueOf(sql) + " and yunsongcheliang like '%" + this.yunsongcheliang.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List yundanjiluList = this.yundanjiluDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, yundanjiluList.size());
        final List yundanjiluList2 = yundanjiluList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(yundanjiluList.size());
        p.setData(yundanjiluList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String yundanjiluList2() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TYundanjilu where wangdianbianhao='" + (String)request.getSession().getAttribute("username") + "' ";
        if (this.kuaididanhao != null) {
            sql = String.valueOf(sql) + " and kuaididanhao like '%" + this.kuaididanhao.trim() + "%'";
        }
        if (this.mudedi != null) {
            sql = String.valueOf(sql) + " and mudedi like '%" + this.mudedi.trim() + "%'";
        }
        if (this.shoujianren != null) {
            sql = String.valueOf(sql) + " and shoujianren like '%" + this.shoujianren.trim() + "%'";
        }
        if (this.shoujiandianhua != null) {
            sql = String.valueOf(sql) + " and shoujiandianhua like '%" + this.shoujiandianhua.trim() + "%'";
        }
        if (this.yonghuming != null) {
            sql = String.valueOf(sql) + " and yonghuming like '%" + this.yonghuming.trim() + "%'";
        }
        if (this.xingming != null) {
            sql = String.valueOf(sql) + " and xingming like '%" + this.xingming.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.wupinmingcheng != null) {
            sql = String.valueOf(sql) + " and wupinmingcheng like '%" + this.wupinmingcheng.trim() + "%'";
        }
        if (this.kuaidifeiyong != null) {
            sql = String.valueOf(sql) + " and kuaidifeiyong like '%" + this.kuaidifeiyong.trim() + "%'";
        }
        if (this.yundanzhuangtai != null) {
            sql = String.valueOf(sql) + " and yundanzhuangtai like '%" + this.yundanzhuangtai.trim() + "%'";
        }
        if (this.yunsongcheliang != null) {
            sql = String.valueOf(sql) + " and yunsongcheliang like '%" + this.yunsongcheliang.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List yundanjiluList = this.yundanjiluDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, yundanjiluList.size());
        final List yundanjiluList2 = yundanjiluList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(yundanjiluList.size());
        p.setData(yundanjiluList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String yundanjiluDel() {
        final String sql = "delete from TYundanjilu where id=?";
        final Object[] o = { this.id };
        this.yundanjiluDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String yundanjiluPre() {
        final TYundanjilu yundanjilu = this.yundanjiluDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("yundanjilu", yundanjilu);
        return "success";
    }
    
    public String yundanjiluDetail() {
        final TYundanjilu yundanjilu = this.yundanjiluDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("yundanjilu", yundanjilu);
        return "success";
    }
    
    public String ydjlDetail() {
        final TYundanjilu yundanjilu = this.yundanjiluDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("yundanjilu", yundanjilu);
        return "success";
    }
    
    public List getLbdqYundanjilu(final int id, final int hsgzds) {
        final String sql = "select mudedi,shoujianren,shoujiandianhua,yonghuming,xingming,dianhua,wupinmingcheng from t_woyaojijian where id = " + id;
        final db dbo = new db();
        this.list = new ArrayList();
        try {
            this.rs = dbo.executeQuery(sql);
            while (this.rs.next()) {
                for (int hsgt = 1; hsgt <= hsgzds; ++hsgt) {
                    this.list.add(this.rs.getString(hsgt));
                }
            }
            return this.list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.list;
        }
    }
    
    public String yundanjiluUpdt() {
        final TYundanjilu yundanjilu = this.yundanjiluDAO.findById(this.id);
        yundanjilu.setKuaididanhao(this.kuaididanhao);
        yundanjilu.setMudedi(this.mudedi);
        yundanjilu.setShoujianren(this.shoujianren);
        yundanjilu.setShoujiandianhua(this.shoujiandianhua);
        yundanjilu.setYonghuming(this.yonghuming);
        yundanjilu.setXingming(this.xingming);
        yundanjilu.setDianhua(this.dianhua);
        yundanjilu.setWupinmingcheng(this.wupinmingcheng);
        yundanjilu.setKuaidifeiyong(this.kuaidifeiyong);
        yundanjilu.setYundanzhuangtai(this.yundanzhuangtai);
        yundanjilu.setYunsongcheliang(this.yunsongcheliang);
        yundanjilu.setBeizhu(this.beizhu);
        yundanjilu.setWangdianbianhao(this.wangdianbianhao);
        this.yundanjiluDAO.attachDirty(yundanjilu);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getKuaididanhao() {
        return this.kuaididanhao;
    }
    
    public void setKuaididanhao(final String kuaididanhao) {
        this.kuaididanhao = kuaididanhao;
    }
    
    public String getMudedi() {
        return this.mudedi;
    }
    
    public void setMudedi(final String mudedi) {
        this.mudedi = mudedi;
    }
    
    public String getShoujianren() {
        return this.shoujianren;
    }
    
    public void setShoujianren(final String shoujianren) {
        this.shoujianren = shoujianren;
    }
    
    public String getShoujiandianhua() {
        return this.shoujiandianhua;
    }
    
    public void setShoujiandianhua(final String shoujiandianhua) {
        this.shoujiandianhua = shoujiandianhua;
    }
    
    public String getYonghuming() {
        return this.yonghuming;
    }
    
    public void setYonghuming(final String yonghuming) {
        this.yonghuming = yonghuming;
    }
    
    public String getXingming() {
        return this.xingming;
    }
    
    public void setXingming(final String xingming) {
        this.xingming = xingming;
    }
    
    public String getDianhua() {
        return this.dianhua;
    }
    
    public void setDianhua(final String dianhua) {
        this.dianhua = dianhua;
    }
    
    public String getWupinmingcheng() {
        return this.wupinmingcheng;
    }
    
    public void setWupinmingcheng(final String wupinmingcheng) {
        this.wupinmingcheng = wupinmingcheng;
    }
    
    public String getKuaidifeiyong() {
        return this.kuaidifeiyong;
    }
    
    public void setKuaidifeiyong(final String kuaidifeiyong) {
        this.kuaidifeiyong = kuaidifeiyong;
    }
    
    public String getYundanzhuangtai() {
        return this.yundanzhuangtai;
    }
    
    public void setYundanzhuangtai(final String yundanzhuangtai) {
        this.yundanzhuangtai = yundanzhuangtai;
    }
    
    public String getYunsongcheliang() {
        return this.yunsongcheliang;
    }
    
    public void setYunsongcheliang(final String yunsongcheliang) {
        this.yunsongcheliang = yunsongcheliang;
    }
    
    public String getBeizhu() {
        return this.beizhu;
    }
    
    public void setBeizhu(final String beizhu) {
        this.beizhu = beizhu;
    }
    
    public String getWangdianbianhao() {
        return this.wangdianbianhao;
    }
    
    public void setWangdianbianhao(final String wangdianbianhao) {
        this.wangdianbianhao = wangdianbianhao;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public TYundanjiluDAO getYundanjiluDAO() {
        return this.yundanjiluDAO;
    }
    
    public void setYundanjiluDAO(final TYundanjiluDAO yundanjiluDAO) {
        this.yundanjiluDAO = yundanjiluDAO;
    }
    
    public TWoyaojijianDAO getWoyaojijianDAO() {
        return this.woyaojijianDAO;
    }
    
    public void setWoyaojijianDAO(final TWoyaojijianDAO woyaojijianDAO) {
        this.woyaojijianDAO = woyaojijianDAO;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public void setPath(final String path) {
        this.path = path;
    }
}
