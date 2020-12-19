package com.umeng.zhangwentao.fragment.faxian;

/**
 * 项目名:zhangwentao
 * 包名:com.umeng.zhangwentao.fragment.faxian
 * 创建者: 张文涛
 * 创建时间: 2020/12/17
 */
public class FaXianTuiJianDataBean {

    /**
     * timestamp : 1608204958236
     * status : 404
     * error : Not Found
     * message : No message available
     * path : /serverdemo/tag/queryTagList%20%20
     */

    private long timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
