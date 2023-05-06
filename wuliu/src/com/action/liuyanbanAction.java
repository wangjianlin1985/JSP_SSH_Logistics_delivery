// 
// 
// 

package com.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import com.util.Pagesize;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TLiuyanban;
import com.dao.TLiuyanbanDAO;
import com.opensymphony.xwork2.ActionSupport;

public class liuyanbanAction extends ActionSupport
{
    private int id;
    private String cheng;
    private String xingbie;
    private String QQ;
    private String youxiang;
    private String dianhua;
    private String neirong;
    private String huifuneirong;
    private String addtime;
    private String message;
    private String path;
    private TLiuyanbanDAO liuyanbanDAO;
    
    public String liuyanbanAdd() {
        final TLiuyanban liuyanban = new TLiuyanban();
        liuyanban.setCheng(this.cheng);
        liuyanban.setXingbie(this.xingbie);
        liuyanban.setQQ(this.QQ);
        liuyanban.setYouxiang(this.youxiang);
        liuyanban.setDianhua(this.dianhua);
        liuyanban.setNeirong(this.neirong);
        liuyanban.setHuifuneirong(this.huifuneirong);
        liuyanban.setAddtime(this.addtime);
        this.liuyanbanDAO.save(liuyanban);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "<script>javascript:alert('\u64cd\u4f5c\u6210\u529f\uff01');location.href='lyblist.action';</script>");
        return "msg";
    }
    
    public String liuyanbanList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TLiuyanban where 1=1 ";
        if (this.cheng != null) {
            sql = String.valueOf(sql) + " and cheng like '%" + this.cheng.trim() + "%'";
        }
        if (this.xingbie != null) {
            sql = String.valueOf(sql) + " and touxiang like '%" + this.xingbie.trim() + "%'";
        }
        if (this.QQ != null) {
            sql = String.valueOf(sql) + " and QQ like '%" + this.QQ.trim() + "%'";
        }
        if (this.youxiang != null) {
            sql = String.valueOf(sql) + " and youxiang like '%" + this.youxiang.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.neirong != null) {
            sql = String.valueOf(sql) + " and neirong like '%" + this.neirong.trim() + "%'";
        }
        if (this.huifuneirong != null) {
            sql = String.valueOf(sql) + " and huifuneirong like '%" + this.huifuneirong.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List liuyanbanList = this.liuyanbanDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, liuyanbanList.size());
        final List liuyanbanList2 = liuyanbanList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(liuyanbanList.size());
        p.setData(liuyanbanList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String lyblist() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TLiuyanban where 1=1 ";
        if (this.cheng != null) {
            sql = String.valueOf(sql) + " and cheng like '%" + this.cheng.trim() + "%'";
        }
        if (this.xingbie != null) {
            sql = String.valueOf(sql) + " and touxiang like '%" + this.xingbie.trim() + "%'";
        }
        if (this.QQ != null) {
            sql = String.valueOf(sql) + " and QQ like '%" + this.QQ.trim() + "%'";
        }
        if (this.youxiang != null) {
            sql = String.valueOf(sql) + " and youxiang like '%" + this.youxiang.trim() + "%'";
        }
        if (this.dianhua != null) {
            sql = String.valueOf(sql) + " and dianhua like '%" + this.dianhua.trim() + "%'";
        }
        if (this.neirong != null) {
            sql = String.valueOf(sql) + " and neirong like '%" + this.neirong.trim() + "%'";
        }
        if (this.huifuneirong != null) {
            sql = String.valueOf(sql) + " and huifuneirong like '%" + this.huifuneirong.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List liuyanbanList = this.liuyanbanDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, liuyanbanList.size());
        final List liuyanbanList2 = liuyanbanList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(liuyanbanList.size());
        p.setData(liuyanbanList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String liuyanbanDel() {
        final String sql = "delete from TLiuyanban where id=?";
        final Object[] o = { this.id };
        this.liuyanbanDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String liuyanbanPre() {
        final TLiuyanban liuyanban = this.liuyanbanDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("liuyanban", liuyanban);
        return "success";
    }
    
    public String liuyanbanHf() {
        final TLiuyanban liuyanban = this.liuyanbanDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("liuyanban", liuyanban);
        return "success";
    }
    
    public String liuyanbanUpdt() {
        final TLiuyanban liuyanban = this.liuyanbanDAO.findById(this.id);
        liuyanban.setCheng(this.cheng);
        liuyanban.setXingbie(this.xingbie);
        liuyanban.setQQ(this.QQ);
        liuyanban.setYouxiang(this.youxiang);
        liuyanban.setDianhua(this.dianhua);
        liuyanban.setNeirong(this.neirong);
        liuyanban.setHuifuneirong(this.huifuneirong);
        this.liuyanbanDAO.attachDirty(liuyanban);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getCheng() {
        return this.cheng;
    }
    
    public void setCheng(final String cheng) {
        this.cheng = cheng;
    }
    
    public String getXingbie() {
        return this.xingbie;
    }
    
    public void setXingbie(final String xingbie) {
        this.xingbie = xingbie;
    }
    
    public String getQQ() {
        return this.QQ;
    }
    
    public void setQQ(final String QQ) {
        this.QQ = QQ;
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
    
    public String getNeirong() {
        return this.neirong;
    }
    
    public void setNeirong(final String neirong) {
        this.neirong = neirong;
    }
    
    public String getHuifuneirong() {
        return this.huifuneirong;
    }
    
    public void setHuifuneirong(final String huifuneirong) {
        this.huifuneirong = huifuneirong;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public TLiuyanbanDAO getLiuyanbanDAO() {
        return this.liuyanbanDAO;
    }
    
    public void setLiuyanbanDAO(final TLiuyanbanDAO liuyanbanDAO) {
        this.liuyanbanDAO = liuyanbanDAO;
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
