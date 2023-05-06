// 
// 
// 

package com.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import com.util.Pagesize;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TYonghuzhuce;
import com.dao.TYonghuzhuceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class yonghuzhuceAction extends ActionSupport
{
    private int id;
    private String yonghuming;
    private String mima;
    private String xingming;
    private String xingbie;
    private String chushengnianyue;
    private String qq;
    private String youxiang;
    private String dianhua;
    private String shenfenzheng;
    private String touxiang;
    private String dizhi;
    private String beizhu;
    private String issh;
    private String addtime;
    private String message;
    private String path;
    private TYonghuzhuceDAO yonghuzhuceDAO;
    
    public String yonghuzhuceAdd() {
        final TYonghuzhuce yonghuzhuce = new TYonghuzhuce();
        yonghuzhuce.setYonghuming(this.yonghuming);
        yonghuzhuce.setMima(this.mima);
        yonghuzhuce.setXingming(this.xingming);
        yonghuzhuce.setXingbie(this.xingbie);
        yonghuzhuce.setChushengnianyue(this.chushengnianyue);
        yonghuzhuce.setQq(this.qq);
        yonghuzhuce.setYouxiang(this.youxiang);
        yonghuzhuce.setDianhua(this.dianhua);
        yonghuzhuce.setShenfenzheng(this.shenfenzheng);
        yonghuzhuce.setTouxiang(this.touxiang);
        yonghuzhuce.setDizhi(this.dizhi);
        yonghuzhuce.setBeizhu(this.beizhu);
        yonghuzhuce.setIssh("\u5426");
        this.yonghuzhuceDAO.save(yonghuzhuce);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff0c\u8bf7\u5f85\u7ba1\u7406\u5458\u5ba1\u6838\u540e\u65b9\u53ef\u767b\u9646\uff01');location.href='index.action';</script>");
        return "msg";
    }
    
    public String yonghuzhuceList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TYonghuzhuce where 1=1 ";
        if (this.yonghuming != null) {
            sql = String.valueOf(sql) + " and yonghuming like '%" + this.yonghuming.trim() + "%'";
        }
        if (this.mima != null) {
            sql = String.valueOf(sql) + " and mima like '%" + this.mima.trim() + "%'";
        }
        if (this.xingming != null) {
            sql = String.valueOf(sql) + " and xingming like '%" + this.xingming.trim() + "%'";
        }
        if (this.xingbie != null) {
            sql = String.valueOf(sql) + " and xingbie like '%" + this.xingbie.trim() + "%'";
        }
        if (this.chushengnianyue != null) {
            sql = String.valueOf(sql) + " and chushengnianyue like '%" + this.chushengnianyue.trim() + "%'";
        }
        if (this.qq != null) {
            sql = String.valueOf(sql) + " and qq like '%" + this.qq.trim() + "%'";
        }
        if (this.youxiang != null) {
            sql = String.valueOf(sql) + " and youxiang like '%" + this.youxiang.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.shenfenzheng != null) {
            sql = String.valueOf(sql) + " and shenfenzheng like '%" + this.shenfenzheng.trim() + "%'";
        }
        if (this.touxiang != null) {
            sql = String.valueOf(sql) + " and touxiang like '%" + this.touxiang.trim() + "%'";
        }
        if (this.dizhi != null) {
            sql = String.valueOf(sql) + " and dizhi like '%" + this.dizhi.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List yonghuzhuceList = this.yonghuzhuceDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, yonghuzhuceList.size());
        final List yonghuzhuceList2 = yonghuzhuceList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(yonghuzhuceList.size());
        p.setData(yonghuzhuceList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String yonghuzhuceDel() {
        final String sql = "delete from TYonghuzhuce where id=?";
        final Object[] o = { this.id };
        this.yonghuzhuceDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String yonghuzhuceIssh() {
        String sql = "";
        String tt = "\u5426";
        sql = "from TYonghuzhuce where id=?";
        final Object[] o = { this.id };
        final List yonghuzhuceList = this.yonghuzhuceDAO.getHibernateTemplate().find(sql, o);
        if (yonghuzhuceList.size() == 0) {
            System.out.println("sssss");
        }
        else {
            final TYonghuzhuce yonghuzhuce = (TYonghuzhuce) yonghuzhuceList.get(0);
            if (this.yonghuzhuceDAO.findById(yonghuzhuce.getId()).getIssh().equals("\u5426")) {
                tt = "\u662f";
            }
            else {
                tt = "\u5426";
            }
            System.out.println(tt);
            sql = "update TYonghuzhuce set issh=? where id=?";
            final Object[] con = { tt, this.id };
            this.yonghuzhuceDAO.getHibernateTemplate().bulkUpdate(sql, con);
        }
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f');location.href='yonghuzhuceList.action';</script>");
        return "msg";
    }
    
    public String yonghuzhucePre() {
        final TYonghuzhuce yonghuzhuce = this.yonghuzhuceDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("yonghuzhuce", yonghuzhuce);
        return "success";
    }
    
    public String yonghuzhucePre2() {
        int nid = 0;
        final Map session = ActionContext.getContext().getSession();
        if (session.get("userxinxi") != null) {
            final TYonghuzhuce user = (TYonghuzhuce) session.get("userxinxi");
            nid = user.getId();
        }
        final TYonghuzhuce yonghuzhuce = this.yonghuzhuceDAO.findById(nid);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("yonghuzhuce", yonghuzhuce);
        return "success";
    }
    
    public String yonghuzhuceUpdt() {
        final TYonghuzhuce yonghuzhuce = this.yonghuzhuceDAO.findById(this.id);
        yonghuzhuce.setYonghuming(this.yonghuming);
        yonghuzhuce.setMima(this.mima);
        yonghuzhuce.setXingming(this.xingming);
        yonghuzhuce.setXingbie(this.xingbie);
        yonghuzhuce.setChushengnianyue(this.chushengnianyue);
        yonghuzhuce.setQq(this.qq);
        yonghuzhuce.setYouxiang(this.youxiang);
        yonghuzhuce.setDianhua(this.dianhua);
        yonghuzhuce.setShenfenzheng(this.shenfenzheng);
        yonghuzhuce.setTouxiang(this.touxiang);
        yonghuzhuce.setDizhi(this.dizhi);
        yonghuzhuce.setBeizhu(this.beizhu);
        this.yonghuzhuceDAO.attachDirty(yonghuzhuce);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String yonghuzhuceUpdt2() {
        final TYonghuzhuce yonghuzhuce = this.yonghuzhuceDAO.findById(this.id);
        yonghuzhuce.setYonghuming(this.yonghuming);
        yonghuzhuce.setMima(this.mima);
        yonghuzhuce.setXingming(this.xingming);
        yonghuzhuce.setXingbie(this.xingbie);
        yonghuzhuce.setChushengnianyue(this.chushengnianyue);
        yonghuzhuce.setQq(this.qq);
        yonghuzhuce.setYouxiang(this.youxiang);
        yonghuzhuce.setDianhua(this.dianhua);
        yonghuzhuce.setShenfenzheng(this.shenfenzheng);
        yonghuzhuce.setTouxiang(this.touxiang);
        yonghuzhuce.setDizhi(this.dizhi);
        yonghuzhuce.setBeizhu(this.beizhu);
        this.yonghuzhuceDAO.attachDirty(yonghuzhuce);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getYonghuming() {
        return this.yonghuming;
    }
    
    public void setYonghuming(final String yonghuming) {
        this.yonghuming = yonghuming;
    }
    
    public String getMima() {
        return this.mima;
    }
    
    public void setMima(final String mima) {
        this.mima = mima;
    }
    
    public String getXingming() {
        return this.xingming;
    }
    
    public void setXingming(final String xingming) {
        this.xingming = xingming;
    }
    
    public String getXingbie() {
        return this.xingbie;
    }
    
    public void setXingbie(final String xingbie) {
        this.xingbie = xingbie;
    }
    
    public String getChushengnianyue() {
        return this.chushengnianyue;
    }
    
    public void setChushengnianyue(final String chushengnianyue) {
        this.chushengnianyue = chushengnianyue;
    }
    
    public String getQq() {
        return this.qq;
    }
    
    public void setQq(final String qq) {
        this.qq = qq;
    }
    
    public String getYouxiang() {
        return this.youxiang;
    }
    
    public void setYouxiang(final String youxiang) {
        this.youxiang = youxiang;
    }
    
    public String getDianhua() {
        return this.dianhua;
    }
    
    public void setDianhua(final String dianhua) {
        this.dianhua = dianhua;
    }
    
    public String getShenfenzheng() {
        return this.shenfenzheng;
    }
    
    public void setShenfenzheng(final String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }
    
    public String getTouxiang() {
        return this.touxiang;
    }
    
    public void setTouxiang(final String touxiang) {
        this.touxiang = touxiang;
    }
    
    public String getDizhi() {
        return this.dizhi;
    }
    
    public void setDizhi(final String dizhi) {
        this.dizhi = dizhi;
    }
    
    public String getBeizhu() {
        return this.beizhu;
    }
    
    public void setBeizhu(final String beizhu) {
        this.beizhu = beizhu;
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
    
    public TYonghuzhuceDAO getYonghuzhuceDAO() {
        return this.yonghuzhuceDAO;
    }
    
    public void setYonghuzhuceDAO(final TYonghuzhuceDAO yonghuzhuceDAO) {
        this.yonghuzhuceDAO = yonghuzhuceDAO;
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
