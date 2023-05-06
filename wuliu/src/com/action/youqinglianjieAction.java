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
import com.model.TYouqinglianjie;
import com.dao.TYouqinglianjieDAO;
import com.opensymphony.xwork2.ActionSupport;

public class youqinglianjieAction extends ActionSupport
{
    private int id;
    private String wangzhanmingcheng;
    private String wangzhi;
    private String addtime;
    private String message;
    private String path;
    private TYouqinglianjieDAO youqinglianjieDAO;
    
    public String youqinglianjieAdd() {
        final TYouqinglianjie youqinglianjie = new TYouqinglianjie();
        youqinglianjie.setWangzhanmingcheng(this.wangzhanmingcheng);
        youqinglianjie.setWangzhi(this.wangzhi);
        this.youqinglianjieDAO.save(youqinglianjie);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u6dfb\u52a0\u6210\u529f");
        return "msg";
    }
    
    public String youqinglianjieList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        String sql = "from TYouqinglianjie where 1=1 ";
        if (this.wangzhanmingcheng != null) {
            sql = String.valueOf(sql) + " and wangzhanmingcheng like '%" + this.wangzhanmingcheng.trim() + "%'";
        }
        if (this.wangzhi != null) {
            sql = String.valueOf(sql) + " and wangzhi like '%" + this.wangzhi.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List youqinglianjieList = this.youqinglianjieDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * Pagesize.size;
        final int toIndex = Math.min(fromIndex + Pagesize.size, youqinglianjieList.size());
        final List youqinglianjieList2 = youqinglianjieList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(Pagesize.size);
        p.setTotle(youqinglianjieList.size());
        p.setData(youqinglianjieList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String youqinglianjieDel() {
        final String sql = "delete from TYouqinglianjie where id=?";
        final Object[] o = { this.id };
        this.youqinglianjieDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String youqinglianjiePre() {
        final TYouqinglianjie youqinglianjie = this.youqinglianjieDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("youqinglianjie", youqinglianjie);
        return "success";
    }
    
    public String youqinglianjieUpdt() {
        final TYouqinglianjie youqinglianjie = this.youqinglianjieDAO.findById(this.id);
        youqinglianjie.setWangzhanmingcheng(this.wangzhanmingcheng);
        youqinglianjie.setWangzhi(this.wangzhi);
        this.youqinglianjieDAO.attachDirty(youqinglianjie);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getWangzhanmingcheng() {
        return this.wangzhanmingcheng;
    }
    
    public void setWangzhanmingcheng(final String wangzhanmingcheng) {
        this.wangzhanmingcheng = wangzhanmingcheng;
    }
    
    public String getWangzhi() {
        return this.wangzhi;
    }
    
    public void setWangzhi(final String wangzhi) {
        this.wangzhi = wangzhi;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public TYouqinglianjieDAO getYouqinglianjieDAO() {
        return this.youqinglianjieDAO;
    }
    
    public void setYouqinglianjieDAO(final TYouqinglianjieDAO youqinglianjieDAO) {
        this.youqinglianjieDAO = youqinglianjieDAO;
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
