package com.chuangdun.arcface.autoconfigure;

/**
 * @author Nick
 * 虹软人脸识别引擎初始化异常类.
 */
public class ArcFaceInitException extends RuntimeException{
    public ArcFaceInitException(String message) {
        super(message);
    }
}
