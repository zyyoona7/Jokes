package com.zyyoona7.jokes.model.bean;

/**
 * Created by zyyoona7 on 2016/6/29.
 * 获取趣图或者文本笑话时BaseBean
 */

public class Result<T> {
    private int error_code;
    private String reason;
    private DataResult<T> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DataResult<T> getResult() {
        return result;
    }

    public void setResult(DataResult<T> result) {
        this.result = result;
    }

    public class DataResult<E> {
        private E data;

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }
}