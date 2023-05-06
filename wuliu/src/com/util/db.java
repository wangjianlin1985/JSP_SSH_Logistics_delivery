// 
// 
// 

package com.util;

import java.util.Locale;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;

public class db
{
    private String dbDriver;
    private String sConnStr;
    private String date;
    private List list;
    public Connection connect;
    public ResultSet rs;
    public String nsa;
    public String nmm;
    
    public db() {
        this.dbDriver = "com.mysql.jdbc.Driver";
        this.sConnStr = "jdbc:mysql://localhost:3306/s2shkdxxglxt6147AHY3mysql?useUnicode=true&amp;amp;amp;amp;amp;characterEncoding=gb2312";
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.connect = null;
        this.rs = null;
        this.nsa = "root";
        this.nmm = "123456";
        try {
            Class.forName(this.dbDriver).newInstance();
        }
        catch (Exception ex) {
            System.out.println("12121");
        }
    }
    
    public ResultSet executeQuery(final String sql) {
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return this.rs;
    }
    
    public String hsggetoption(final String ntable, final String nzd) {
        final StringBuffer imgStr = new StringBuffer();
        imgStr.append("");
        String sql = "";
        sql = "select " + nzd + " from " + ntable + " order by id desc";
        System.out.print(sql);
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            while (this.rs.next()) {
                imgStr.append("<option value='" + this.rs.getString(1) + "'>" + this.rs.getString(1) + "</option>\n");
            }
            return imgStr.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return imgStr.toString();
        }
    }
    
    public String hsggetoption2(final String ntable, final String nzd) {
        final StringBuffer imgStr = new StringBuffer();
        imgStr.append("");
        imgStr.append("<option value=''>\u8bf7\u9009\u62e9</option>\n");
        String sql = "";
        sql = "select " + nzd + " from " + ntable + " order by id desc";
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            while (this.rs.next()) {
                imgStr.append("<option value='" + this.rs.getString(1) + "'>" + this.rs.getString(1) + "</option>\n");
            }
            return imgStr.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return imgStr.toString();
        }
    }
    
    public String hsggetoptiond(final String ntable, final String nzd, final String nwbk) {
        final StringBuffer imgStr = new StringBuffer();
        imgStr.append("");
        String sql = "";
        sql = "select " + nzd + " from " + ntable + " order by id desc";
        System.out.print(sql);
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            while (this.rs.next()) {
                imgStr.append("<a onClick=\"hsgxia2shxurxu('" + this.rs.getString(1) + "','" + nwbk + "')\" style='cursor:pointer'>" + this.rs.getString(1) + "</a>\n");
            }
            return imgStr.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return imgStr.toString();
        }
    }
    
    public List getPinglunlist(final String nbiao, final String nid, final int hsgzds) {
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.list = new ArrayList();
            this.rs = stmt.executeQuery("select * from t_pinglun where biao='" + nbiao + "' and xinwenID='" + nid + "' order by id desc");
            while (this.rs.next()) {
                final List list2 = new ArrayList();
                for (int hsgt = 1; hsgt <= hsgzds; ++hsgt) {
                    list2.add(this.rs.getString(hsgt));
                }
                this.list.add(list2);
            }
            return this.list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.list;
        }
    }
    
    public int hsgexecute(final String sql) {
        int i = 0;
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            i = stmt.executeUpdate(sql);
            if (i == 1) {
                return i;
            }
            return i;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 4;
        }
    }
    
    public List hsgselect(final String sql, final int hsgzds) {
        this.list = new ArrayList();
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            while (this.rs.next()) {
                final List list2 = new ArrayList();
                for (int hsgt = 1; hsgt <= hsgzds; ++hsgt) {
                    list2.add(this.rs.getString(hsgt));
                }
                this.list.add(list2);
            }
            return this.list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.list;
        }
    }
    
    public static synchronized String getID() {
        final Random random = new Random();
        final StringBuffer ret = new StringBuffer(20);
        final Date date = new Date();
        final SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.CHINA);
        ret.append(format.format(date));
        final String rand = String.valueOf(Math.abs(random.nextInt()));
        ret.append(rand.substring(0, 4));
        return ret.toString();
    }
    
    public static int getBetweenDayNumber(final String dateA, final String dateB) {
        long dayNumber = 0L;
        final long mins = 60000L;
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            final Date d1 = df.parse(dateA);
            final Date d2 = df.parse(dateB);
            dayNumber = (d2.getTime() - d1.getTime()) / mins;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return (int)dayNumber;
    }
    
    public List getShouyebht() {
        final String sql = "select id,biaoti,shouyetupian from t_xinwentongzhi where leibie='\u53d8\u5e7b\u56fe' order by id desc";
        this.list = new ArrayList();
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            while (this.rs.next()) {
                final List list2 = new ArrayList();
                list2.add(this.rs.getString(1));
                list2.add(this.rs.getString(2));
                list2.add(this.rs.getString(3));
                this.list.add(list2);
            }
            return this.list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.list;
        }
    }
    
    public List getxwlb() {
        final String sql = "select distinct(leibie) as ss from t_xinwentongzhi";
        this.list = new ArrayList();
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            while (this.rs.next()) {
                final List list2 = new ArrayList();
                list2.add(this.rs.getString(1));
                this.list.add(list2);
            }
            return this.list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return this.list;
        }
    }
    
    public String readzd(final String ntable, final String nzd, final String tjzd, final String tjz) {
        final String sql = "select " + nzd + " from " + ntable + " where " + tjzd + "='" + tjz + "' ";
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            final Statement stmt = this.connect.createStatement();
            (this.rs = stmt.executeQuery(sql)).next();
            final String dir = this.rs.getString(1);
            return dir;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String getdate() {
        final String tt = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        return tt;
    }
    
    public String gettime() {
        final String tt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        return tt;
    }
    
    public static synchronized String ensubStr(final Object source, final int length) {
        String msource = filterStrIgnoreCase(source.toString(), "<", ">");
        if (msource.length() > length) {
            msource = String.valueOf(msource.substring(0, length)) + "...";
        }
        return msource;
    }
    
    public static String filterStrIgnoreCase(String source, final String from, final String to) {
        String sourceLowcase = source.toLowerCase();
        String subLowcase2;
        String subLowcase1;
        String sub2 = sub2 = (subLowcase1 = (subLowcase2 = ""));
        int start = 0;
        boolean done = true;
        if (source == null) {
            return null;
        }
        if (from == null || from.equals("") || to == null || to.equals("")) {
            return source;
        }
        while (done) {
            start = sourceLowcase.indexOf(from, start);
            if (start == -1) {
                break;
            }
            subLowcase1 = sourceLowcase.substring(0, start);
            sub2 = source.substring(0, start);
            int end = sourceLowcase.indexOf(to, start);
            if (end == -1) {
                end = sourceLowcase.indexOf("/>", start);
                if (end != -1) {
                    continue;
                }
                done = false;
            }
            else {
                end += to.length();
                subLowcase2 = sourceLowcase.substring(end, source.length());
                sub2 = source.substring(end, source.length());
                sourceLowcase = String.valueOf(subLowcase1) + subLowcase2;
                source = String.valueOf(sub2) + sub2;
            }
        }
        return source;
    }
}
