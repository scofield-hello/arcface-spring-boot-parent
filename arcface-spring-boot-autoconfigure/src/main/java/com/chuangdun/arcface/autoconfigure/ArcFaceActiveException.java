package com.chuangdun.arcface.autoconfigure;

/**
 * @author Nick
 * 虹软人脸识别引擎激活异常类.
 */
public class ArcFaceActiveException extends RuntimeException{
    public ArcFaceActiveException(String message) {
        super(message);
    }
}
