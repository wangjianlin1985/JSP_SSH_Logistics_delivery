// 
// 
// 

package com.action;

import com.opensymphony.xwork2.ActionContext;
import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TKuaidiwangdian;
import com.dao.TKuaidiwangdianDAO;
import java.util.List;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class kuaidiwangdianAction extends ActionSupport
{
    private int id;
    private String wangdianbianhao;
    private String mima;
    private String wangdianmingcheng;
    private String fuzeren;
    private String lianxidianhua;
    private String wangdiandizhi;
    private String paisongfanwei;
    private String wangdianjianjie;
    private String issh;
    private String addtime;
    private String message;
    private String path;
    private ResultSet rs;
    private List list;
    private TKuaidiwangdianDAO kuaidiwangdianDAO;
    
    public String kuaidiwangdianAdd() {
        final TKuaidiwangdian kuaidiwangdian = new TKuaidiwangdian();
        kuaidiwangdian.setWangdianbianhao(this.wangdianbianhao);
        kuaidiwangdian.setMima(this.mima);
        kuaidiwangdian.setWangdianmingcheng(this.wangdianmingcheng);
        kuaidiwangdian.setFuzeren(this.fuzeren);
        kuaidiwangdian.setLianxidianhua(this.lianxidianhua);
        kuaidiwangdian.setWangdiandizhi(this.wangdiandizhi);
        kuaidiwangdian.setPaisongfanwei(this.paisongfanwei);
        kuaidiwangdian.setWangdianjianjie(this.wangdianjianjie);
        kuaidiwangdian.setIssh("\u5426");
        kuaidiwangdian.setAddtime(this.addtime);
        this.kuaidiwangdianDAO.save(kuaidiwangdian);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01');history.back();</script>");
        return "msg";
    }
    
    public String kuaidiwangdianList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TKuaidiwangdian where 1=1 ";
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        if (this.mima != null) {
            sql = String.valueOf(sql) + " and mima like '%" + this.mima.trim() + "%'";
        }
        if (this.wangdianmingcheng != null) {
            sql = String.valueOf(sql) + " and wangdianmingcheng like '%" + this.wangdianmingcheng.trim() + "%'";
        }
        if (this.fuzeren != null) {
            sql = String.valueOf(sql) + " and fuzeren like '%" + this.fuzeren.trim() + "%'";
        }
        if (this.lianxidianhua != null) {
            sql = String.valueOf(sql) + " and lianxidianhua like '%" + this.lianxidianhua.trim() + "%'";
        }
        if (this.wangdiandizhi != null) {
            sql = String.valueOf(sql) + " and wangdiandizhi like '%" + this.wangdiandizhi.trim() + "%'";
        }
        if (this.paisongfanwei != null) {
            sql = String.valueOf(sql) + " and paisongfanwei like '%" + this.paisongfanwei.trim() + "%'";
        }
        if (this.wangdianjianjie != null) {
            sql = String.valueOf(sql) + " and wangdianjianjie like '%" + this.wangdianjianjie.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List kuaidiwangdianList = this.kuaidiwangdianDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, kuaidiwangdianList.size());
        final List kuaidiwangdianList2 = kuaidiwangdianList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(kuaidiwangdianList.size());
        p.setData(kuaidiwangdianList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String kdwdList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TKuaidiwangdian where 1=1 ";
        if (this.wangdianbianhao != null) {
            sql = String.valueOf(sql) + " and wangdianbianhao like '%" + this.wangdianbianhao.trim() + "%'";
        }
        if (this.mima != null) {
            sql = String.valueOf(sql) + " and mima like '%" + this.mima.trim() + "%'";
        }
        if (this.wangdianmingcheng != null) {
            sql = String.valueOf(sql) + " and wangdianmingcheng like '%" + this.wangdianmingcheng.trim() + "%'";
        }
        if (this.fuzeren != null) {
            sql = String.valueOf(sql) + " and fuzeren like '%" + this.fuzeren.trim() + "%'";
        }
        if (this.lianxidianhua != null) {
            sql = String.valueOf(sql) + " and lianxidianhua like '%" + this.lianxidianhua.trim() + "%'";
        }
        if (this.wangdiandizhi != null) {
            sql = String.valueOf(sql) + " and wangdiandizhi like '%" + this.wangdiandizhi.trim() + "%'";
        }
        if (this.paisongfanwei != null) {
            sql = String.valueOf(sql) + " and paisongfanwei like '%" + this.paisongfanwei.trim() + "%'";
        }
        if (this.wangdianjianjie != null) {
            sql = String.valueOf(sql) + " and wangdianjianjie like '%" + this.wangdianjianjie.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List kuaidiwangdianList = this.kuaidiwangdianDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, kuaidiwangdianList.size());
        final List kuaidiwangdianList2 = kuaidiwangdianList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(kuaidiwangdianList.size());
        p.setData(kuaidiwangdianList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String kuaidiwangdianDel() {
        final String sql = "delete from TKuaidiwangdian where id=?";
        final Object[] o = { this.id };
        this.kuaidiwangdianDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String kuaidiwangdianIssh() {
        String sql = "";
        String tt = "\u5426";
        sql = "from TKuaidiwangdian where id=?";
        final Object[] o = { this.id };
        final List kuaidiwangdianList = this.kuaidiwangdianDAO.getHibernateTemplate().find(sql, o);
        if (kuaidiwangdianList.size() != 0) {
            final TKuaidiwangdian kuaidiwangdian = (TKuaidiwangdian) kuaidiwangdianList.get(0);
            if (this.kuaidiwangdianDAO.findById(kuaidiwangdian.getId()).getIssh().equals("\u5426")) {
                tt = "\u662f";
            }
            else {
                tt = "\u5426";
            }
            sql = "update TKuaidiwangdian set issh=? where id=?";
            final Object[] con = { tt, this.id };
            this.kuaidiwangdianDAO.getHibernateTemplate().bulkUpdate(sql, con);
        }
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f');location.href='kuaidiwangdianList.action';</script>");
        return "msg";
    }
    
    public String kuaidiwangdianPre() {
        final TKuaidiwangdian kuaidiwangdian = this.kuaidiwangdianDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("kuaidiwangdian", kuaidiwangdian);
        return "success";
    }
    
    public String kuaidiwangdianDetail() {
        final TKuaidiwangdian kuaidiwangdian = this.kuaidiwangdianDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("kuaidiwangdian", kuaidiwangdian);
        return "success";
    }
    
    public String kdwdDetail() {
        final TKuaidiwangdian kuaidiwangdian = this.kuaidiwangdianDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("kuaidiwangdian", kuaidiwangdian);
        return "success";
    }
    
    public String kuaidiwangdianPre2() {
        int nid = 0;
        final Map session = ActionContext.getContext().getSession();
        if (session.get("userxinxi") != null) {
            final TKuaidiwangdian user = (TKuaidiwangdian) session.get("userxinxi");
            nid = user.getId();
        }
        final TKuaidiwangdian kuaidiwangdian = this.kuaidiwangdianDAO.findById(nid);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("kuaidiwangdian", kuaidiwangdian);
        return "success";
    }
    
    public String kuaidiwangdianUpdt2() {
        final TKuaidiwangdian kuaidiwangdian = this.kuaidiwangdianDAO.findById(this.id);
        kuaidiwangdian.setWangdianbianhao(this.wangdianbianhao);
        kuaidiwangdian.setMima(this.mima);
        kuaidiwangdian.setWangdianmingcheng(this.wangdianmingcheng);
        kuaidiwangdian.setFuzeren(this.fuzeren);
        kuaidiwangdian.setLianxidianhua(this.lianxidianhua);
        kuaidiwangdian.setWangdiandizhi(this.wangdiandizhi);
        kuaidiwangdian.setPaisongfanwei(this.paisongfanwei);
        kuaidiwangdian.setWangdianjianjie(this.wangdianjianjie);
        this.kuaidiwangdianDAO.attachDirty(kuaidiwangdian);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01');history.back();</script>");
        return "msg";
    }
    
    public String kuaidiwangdianUpdt() {
        final TKuaidiwangdian kuaidiwangdian = this.kuaidiwangdianDAO.findById(this.id);
        kuaidiwangdian.setWangdianbianhao(this.wangdianbianhao);
        kuaidiwangdian.setMima(this.mima);
        kuaidiwangdian.setWangdianmingcheng(this.wangdianmingcheng);
        kuaidiwangdian.setFuzeren(this.fuzeren);
        kuaidiwangdian.setLianxidianhua(this.lianxidianhua);
        kuaidiwangdian.setWangdiandizhi(this.wangdiandizhi);
        kuaidiwangdian.setPaisongfanwei(this.paisongfanwei);
        kuaidiwangdian.setWangdianjianjie(this.wangdianjianjie);
        this.kuaidiwangdianDAO.attachDirty(kuaidiwangdian);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getWangdianbianhao() {
        return this.wangdianbianhao;
    }
    
    public void setWangdianbianhao(final String wangdianbianhao) {
        this.wangdianbianhao = wangdianbianhao;
    }
    
    public String getMima() {
        return this.mima;
    }
    
    public void setMima(final String mima) {
        this.mima = mima;
    }
    
    public String getWangdianmingcheng() {
        return this.wangdianmingcheng;
    }
    
    public void setWangdianmingcheng(final String wangdianmingcheng) {
        this.wangdianmingcheng = wangdianmingcheng;
    }
    
    public String getFuzeren() {
        return this.fuzeren;
    }
    
    public void setFuzeren(final String fuzeren) {
        this.fuzeren = fuzeren;
    }
    
    public String getLianxidianhua() {
        return this.lianxidianhua;
    }
    
    public void setLianxidianhua(final String lianxidianhua) {
        this.lianxidianhua = lianxidianhua;
    }
    
    public String getWangdiandizhi() {
        return this.wangdiandizhi;
    }
    
    public void setWangdiandizhi(final String wangdiandizhi) {
        this.wangdiandizhi = wangdiandizhi;
    }
    
    public String getPaisongfanwei() {
        return this.paisongfanwei;
    }
    
    public void setPaisongfanwei(final String paisongfanwei) {
        this.paisongfanwei = paisongfanwei;
    }
    
    public String getWangdianjianjie() {
        return this.wangdianjianjie;
    }
    
    public void setWangdianjianjie(final String wangdianjianjie) {
        this.wangdianjianjie = wangdianjianjie;
    }
    
    public String getIssh() {
        return this.issh;
    }
    
    public void setIssh(final String issh) {
        this.issh = issh;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public TKuaidiwangdianDAO getKuaidiwangdianDAO() {
        return this.kuaidiwangdianDAO;
    }
    
    public void setKuaidiwangdianDAO(final TKuaidiwangdianDAO kuaidiwangdianDAO) {
        this.kuaidiwangdianDAO = kuaidiwangdianDAO;
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
