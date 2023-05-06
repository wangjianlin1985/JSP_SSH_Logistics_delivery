// 
// 
// 

package com.action;

import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TCheliangxinxi;
import com.dao.TCheliangxinxiDAO;
import java.util.List;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class cheliangxinxiAction extends ActionSupport
{
    private int id;
    private String chepaihao;
    private String jiashiyuan;
    private String zhuangtai;
    private String beizhu;
    private String addtime;
    private String message;
    private String path;
    private ResultSet rs;
    private List list;
    private TCheliangxinxiDAO cheliangxinxiDAO;
    
    public String cheliangxinxiAdd() {
        final TCheliangxinxi cheliangxinxi = new TCheliangxinxi();
        cheliangxinxi.setChepaihao(this.chepaihao);
        cheliangxinxi.setJiashiyuan(this.jiashiyuan);
        cheliangxinxi.setZhuangtai(this.zhuangtai);
        cheliangxinxi.setBeizhu(this.beizhu);
        cheliangxinxi.setAddtime(this.addtime);
        this.cheliangxinxiDAO.save(cheliangxinxi);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01');history.back();</script>");
        return "msg";
    }
    
    public String cheliangxinxiList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        String sql = "from TCheliangxinxi where 1=1 ";
        if (this.chepaihao != null) {
            sql = String.valueOf(sql) + " and chepaihao like '%" + this.chepaihao.trim() + "%'";
        }
        if (this.jiashiyuan != null) {
            sql = String.valueOf(sql) + " and jiashiyuan like '%" + this.jiashiyuan.trim() + "%'";
        }
        if (this.zhuangtai != null) {
            sql = String.valueOf(sql) + " and zhuangtai like '%" + this.zhuangtai.trim() + "%'";
        }
        if (this.beizhu != null) {
            sql = String.valueOf(sql) + " and beizhu like '%" + this.beizhu.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List cheliangxinxiList = this.cheliangxinxiDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, cheliangxinxiList.size());
        final List cheliangxinxiList2 = cheliangxinxiList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(cheliangxinxiList.size());
        p.setData(cheliangxinxiList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String cheliangxinxiDel() {
        final String sql = "delete from TCheliangxinxi where id=?";
        final Object[] o = { this.id };
        this.cheliangxinxiDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String cheliangxinxiPre() {
        final TCheliangxinxi cheliangxinxi = this.cheliangxinxiDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("cheliangxinxi", cheliangxinxi);
        return "success";
    }
    
    public String cheliangxinxiUpdt() {
        final TCheliangxinxi cheliangxinxi = this.cheliangxinxiDAO.findById(this.id);
        cheliangxinxi.setChepaihao(this.chepaihao);
        cheliangxinxi.setJiashiyuan(this.jiashiyuan);
        cheliangxinxi.setZhuangtai(this.zhuangtai);
        cheliangxinxi.setBeizhu(this.beizhu);
        this.cheliangxinxiDAO.attachDirty(cheliangxinxi);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getChepaihao() {
        return this.chepaihao;
    }
    
    public void setChepaihao(final String chepaihao) {
        this.chepaihao = chepaihao;
    }
    
    public String getJiashiyuan() {
        return this.jiashiyuan;
    }
    
    public void setJiashiyuan(final String jiashiyuan) {
        this.jiashiyuan = jiashiyuan;
    }
    
    public String getZhuangtai() {
        return this.zhuangtai;
    }
    
    public void setZhuangtai(final String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
    
    public String getBeizhu() {
        return this.beizhu;
    }
    
    public void setBeizhu(final String beizhu) {
        this.beizhu = beizhu;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public TCheliangxinxiDAO getCheliangxinxiDAO() {
        return this.cheliangxinxiDAO;
    }
    
    public void setCheliangxinxiDAO(final TCheliangxinxiDAO cheliangxinxiDAO) {
        this.cheliangxinxiDAO = cheliangxinxiDAO;
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
