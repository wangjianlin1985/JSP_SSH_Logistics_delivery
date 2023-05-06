// 
// 
// 

package com.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.util.Pagination;
import org.apache.struts2.ServletActionContext;
import java.util.Map;
import com.model.TXinwentongzhi;
import com.dao.TXinwentongzhiDAO;
import com.opensymphony.xwork2.ActionSupport;

public class xinwentongzhiAction extends ActionSupport
{
    private int id;
    private String biaoti;
    private String leibie;
    private String neirong;
    private String shouyetupian;
    private String dianjilv;
    private String tianjiaren;
    private String addtime;
    private String message;
    private String path;
    private TXinwentongzhiDAO xinwentongzhiDAO;
    
    public String xinwentongzhiAdd() {
        final TXinwentongzhi xinwentongzhi = new TXinwentongzhi();
        xinwentongzhi.setBiaoti(this.biaoti);
        xinwentongzhi.setLeibie(this.leibie);
        xinwentongzhi.setNeirong(this.neirong);
        xinwentongzhi.setShouyetupian(this.shouyetupian);
        xinwentongzhi.setDianjilv(this.dianjilv);
        xinwentongzhi.setTianjiaren(this.tianjiaren);
        xinwentongzhi.setAddtime(this.addtime);
        this.xinwentongzhiDAO.save(xinwentongzhi);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u6dfb\u52a0\u6210\u529f");
        return "msg";
    }
    
    public String news() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        final String lb = request.getParameter("lb");
        String sql = "from TXinwentongzhi where leibie='" + lb + "' ";
        if (this.biaoti != null) {
            sql = String.valueOf(sql) + " and biaoti like '%" + this.biaoti.trim() + "%'";
        }
        if (this.leibie != null) {
            sql = String.valueOf(sql) + " and leibie like '%" + this.leibie.trim() + "%'";
        }
        if (this.neirong != null) {
            sql = String.valueOf(sql) + " and neirong like '%" + this.neirong.trim() + "%'";
        }
        if (this.shouyetupian != null) {
            sql = String.valueOf(sql) + " and shouyetupian like '%" + this.shouyetupian.trim() + "%'";
        }
        if (this.dianjilv != null) {
            sql = String.valueOf(sql) + " and dianjilv like '%" + this.dianjilv.trim() + "%'";
        }
        if (this.tianjiaren != null) {
            sql = String.valueOf(sql) + " and tianjiaren like '%" + this.tianjiaren.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        final List xinwentongzhiList = this.xinwentongzhiDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, xinwentongzhiList.size());
        final List xinwentongzhiList2 = xinwentongzhiList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(xinwentongzhiList.size());
        p.setData(xinwentongzhiList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String xinwentongzhiList() {
        final HttpServletRequest request = ServletActionContext.getRequest();
        int index = 0;
        if (request.getParameter("index") == null) {
            index = 1;
        }
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        final int hsgpagesize = 20;
        final String lb = request.getParameter("lb");
        String sql = "from TXinwentongzhi where leibie='" + lb + "' ";
        if (this.biaoti != null) {
            sql = String.valueOf(sql) + " and biaoti like '%" + this.biaoti.trim() + "%'";
        }
        if (this.leibie != null) {
            sql = String.valueOf(sql) + " and leibie like '%" + this.leibie.trim() + "%'";
        }
        if (this.neirong != null) {
            sql = String.valueOf(sql) + " and neirong like '%" + this.neirong.trim() + "%'";
        }
        if (this.shouyetupian != null) {
            sql = String.valueOf(sql) + " and shouyetupian like '%" + this.shouyetupian.trim() + "%'";
        }
        if (this.dianjilv != null) {
            sql = String.valueOf(sql) + " and dianjilv like '%" + this.dianjilv.trim() + "%'";
        }
        if (this.tianjiaren != null) {
            sql = String.valueOf(sql) + " and tianjiaren like '%" + this.tianjiaren.trim() + "%'";
        }
        sql = String.valueOf(sql) + " order by id desc";
        System.out.print(sql);
        final List xinwentongzhiList = this.xinwentongzhiDAO.getHibernateTemplate().find(sql);
        final int fromIndex = (index - 1) * hsgpagesize;
        final int toIndex = Math.min(fromIndex + hsgpagesize, xinwentongzhiList.size());
        final List xinwentongzhiList2 = xinwentongzhiList.subList(fromIndex, toIndex);
        final Pagination p = new Pagination();
        p.setIndex(index);
        p.setPageSize(hsgpagesize);
        p.setTotle(xinwentongzhiList.size());
        p.setData(xinwentongzhiList2);
        request.setAttribute("page", (Object)p);
        return "success";
    }
    
    public String xinwentongzhiDel() {
        final String sql = "delete from TXinwentongzhi where id=?";
        final Object[] o = { this.id };
        this.xinwentongzhiDAO.getHibernateTemplate().bulkUpdate(sql, o);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String xinwentongzhiPre() {
        final TXinwentongzhi xinwentongzhi = this.xinwentongzhiDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("xinwentongzhi", xinwentongzhi);
        return "success";
    }
    
    public String ggdetail() {
        final TXinwentongzhi xinwentongzhi = this.xinwentongzhiDAO.findById(this.id);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("ggdetail", xinwentongzhi);
        return "success";
    }
    
    public String xinwentongzhiUpdt() {
        final TXinwentongzhi xinwentongzhi = this.xinwentongzhiDAO.findById(this.id);
        xinwentongzhi.setBiaoti(this.biaoti);
        xinwentongzhi.setLeibie(this.leibie);
        xinwentongzhi.setNeirong(this.neirong);
        xinwentongzhi.setShouyetupian(this.shouyetupian);
        xinwentongzhi.setDianjilv(this.dianjilv);
        xinwentongzhi.setTianjiaren(this.tianjiaren);
        this.xinwentongzhiDAO.attachDirty(xinwentongzhi);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("msg", "\u64cd\u4f5c\u6210\u529f");
        return "msg";
    }
    
    public String getBiaoti() {
        return this.biaoti;
    }
    
    public void setBiaoti(final String biaoti) {
        this.biaoti = biaoti;
    }
    
    public String getLeibie() {
        return this.leibie;
    }
    
    public void setLeibie(final String leibie) {
        this.leibie = leibie;
    }
    
    public String getNeirong() {
        return this.neirong;
    }
    
    public void setNeirong(final String neirong) {
        this.neirong = neirong;
    }
    
    public String getShouyetupian() {
        return this.shouyetupian;
    }
    
    public void setShouyetupian(final String shouyetupian) {
        this.shouyetupian = shouyetupian;
    }
    
    public String getDianjilv() {
        return this.dianjilv;
    }
    
    public void setDianjilv(final String dianjilv) {
        this.dianjilv = dianjilv;
    }
    
    public String getTianjiaren() {
        return this.tianjiaren;
    }
    
    public void setTianjiaren(final String tianjiaren) {
        this.tianjiaren = tianjiaren;
    }
    
    public String getAddtime() {
        return this.addtime;
    }
    
    public void setAddtime(final String addtime) {
        this.addtime = addtime;
    }
    
    public TXinwentongzhiDAO getXinwentongzhiDAO() {
        return this.xinwentongzhiDAO;
    }
    
    public void setXinwentongzhiDAO(final TXinwentongzhiDAO xinwentongzhiDAO) {
        this.xinwentongzhiDAO = xinwentongzhiDAO;
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
