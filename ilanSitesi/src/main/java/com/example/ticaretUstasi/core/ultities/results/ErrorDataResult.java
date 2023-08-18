package com.example.ticaretUstasi.core.ultities.results;

public class ErrorDataResult <T> extends DataResult{
    public ErrorDataResult(T data) {
        super(data, false);
    }

    public ErrorDataResult() {
        super(null, false);
    }
}
