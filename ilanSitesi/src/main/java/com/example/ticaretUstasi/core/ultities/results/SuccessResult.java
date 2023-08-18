package com.example.ticaretUstasi.core.ultities.results;

public class SuccessResult extends Result{
    private Object data;

    public SuccessResult( Object data,String message) {
        super(true,message);
        this.data = data;

    }

    public SuccessResult(boolean success, String message, Object data) {
        super(success, message);
        this.data = data;
    }

    public SuccessResult(boolean success) {
        super(success);
    }
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
