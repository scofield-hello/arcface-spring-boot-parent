package com.chuangdun.arcface.autoconfigure;

public class ArcFaceSdkException extends RuntimeException {
    public ArcFaceSdkException(String errorCode) {
        super("人脸SDK出错:[" + errorCode + "]");
    }

    public ArcFaceSdkException(String errorCode, Throwable cause) {
        super("人脸SDK出错:[" + errorCode + "]", cause);
    }
}
