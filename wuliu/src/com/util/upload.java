// 
// 
// 

package com.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import java.util.Date;
import java.io.File;
import com.opensymphony.xwork2.ActionSupport;

public class upload extends ActionSupport
{
    private static final int BUFFER_SIZE = 16384;
    private File fujian;
    private String fujianFileName;
    private String fujianContentType;
    
    public String upload() {
        final String newFujianName = String.valueOf(new Date().getTime()) + this.fujianFileName.substring(this.fujianFileName.indexOf("."));
        final String dstPath = String.valueOf(ServletActionContext.getServletContext().getRealPath("upload")) + "\\" + newFujianName;
        final File dstFile = new File(dstPath);
        copy(this.getFujian(), dstFile);
        final Map request = (Map)ServletActionContext.getContext().get((Object)"request");
        request.put("newFujianName", newFujianName);
        request.put("oldFujianName", this.fujianFileName);
        request.put("fujianPath", "upload/" + newFujianName);
        return "success";
    }
    
    private static void copy(final File src, final File dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), 16384);
            out = new BufferedOutputStream(new FileOutputStream(dst), 16384);
            final byte[] buffer = new byte[16384];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            if (in != null) {
                try {
                    in.close();
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return;
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (in != null) {
            try {
                in.close();
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public File getFujian() {
        return this.fujian;
    }
    
    public void setFujian(final File fujian) {
        this.fujian = fujian;
    }
    
    public String getFujianContentType() {
        return this.fujianContentType;
    }
    
    public void setFujianContentType(final String fujianContentType) {
        this.fujianContentType = fujianContentType;
    }
    
    public String getFujianFileName() {
        return this.fujianFileName;
    }
    
    public void setFujianFileName(final String fujianFileName) {
        this.fujianFileName = fujianFileName;
    }
}
