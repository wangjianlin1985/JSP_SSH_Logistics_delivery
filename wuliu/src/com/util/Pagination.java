// 
// 
// 

package com.util;

import java.util.List;

public class Pagination
{
    private int totle;
    private int pageSize;
    private int totlePage;
    private int index;
    private List data;
    private String path;
    
    public void setTotle(final int totle) {
        this.totle = totle;
    }
    
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    public void setPath(final String path) {
        this.path = path;
    }
    
    public int getTotle() {
        return this.totle;
    }
    
    public int getPageSize() {
        return this.pageSize;
    }
    
    public int getTotlePage() {
        return (this.totle + this.pageSize - 1) / this.pageSize;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public List getData() {
        return this.data;
    }
    
    public void setData(final List data) {
        this.data = data;
    }
    
    public String getPageDisplay() {
        final StringBuffer displayInfo = new StringBuffer();
        if (this.index == 0 || this.pageSize == 0) {
            displayInfo.append("\u6ca1\u6709\u5206\u9875\u7684\u4fe1\u606f!");
        }
        else {
            displayInfo.append("<div>");
            displayInfo.append("\u5171" + this.totle + "\u6761\u8bb0\u5f55&nbsp;&nbsp;&nbsp;&nbsp;\u6bcf\u9875<span style='color:#FF0000'>" + this.pageSize + "</span>\u6761&nbsp;&nbsp;&nbsp;&nbsp;");
            displayInfo.append("\u7b2c<span style='color:#FF0000'>" + this.index + "</span>\u9875/\u5171" + this.getTotlePage() + "\u9875&nbsp;&nbsp;&nbsp;&nbsp;");
            if (this.index == 1) {
                displayInfo.append("\u9996\u9875&nbsp;&nbsp;&nbsp;&nbsp;");
                displayInfo.append("\u4e0a\u4e00\u9875&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            else {
                displayInfo.append("<a style='color: red' href='" + this.path + "index=1'>\u9996\u9875&nbsp;&nbsp;&nbsp;&nbsp;</a>");
                displayInfo.append("<a style='color: red' href='" + this.path + "index=" + (this.index - 1) + "'>\u4e0a\u4e00\u9875&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;");
            }
            if (this.index >= this.getTotlePage()) {
                displayInfo.append("\u4e0b\u4e00\u9875&nbsp;&nbsp;&nbsp;&nbsp;");
                displayInfo.append("\u672b\u9875&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            else {
                displayInfo.append("<a style='color: red' href='" + this.path + "index=" + (this.index + 1) + "'>\u4e0b\u4e00\u9875&nbsp;&nbsp;&nbsp;&nbsp;</a>");
                displayInfo.append("<a style='color: red' href='" + this.path + "index=" + this.getTotlePage() + "'>\u672b\u9875</a>&nbsp;&nbsp;&nbsp;&nbsp;");
            }
            displayInfo.append("</div>");
        }
        return displayInfo.toString();
    }
}
