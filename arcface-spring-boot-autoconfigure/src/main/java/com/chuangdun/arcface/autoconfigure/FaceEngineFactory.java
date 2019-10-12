package com.chuangdun.arcface.autoconfigure;

import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.enums.ErrorInfo;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class FaceEngineFactory extends BasePooledObjectFactory<FaceEngine> {

    private String appId;
    private String sdkKey;
    private String sdkLibPath;
    private EngineConfiguration engineConfiguration;


    public FaceEngineFactory(String sdkLibPath, String appId, String sdkKey, EngineConfiguration engineConfiguration) {
        this.sdkLibPath = sdkLibPath;
        this.appId = appId;
        this.sdkKey = sdkKey;
        this.engineConfiguration = engineConfiguration;

    }


    @Override
    public FaceEngine create() throws Exception {
        FaceEngine faceEngine = new FaceEngine(sdkLibPath);
        int activeCode = faceEngine.activeOnline(appId, sdkKey);
        if (activeCode != ErrorInfo.MOK.getValue()
                && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            throw new IllegalStateException("虹软人脸引擎激活失败,请检查配置:" + activeCode);
        }
        int initCode = ErrorInfo.MERR_UNKNOWN.getValue();
        for (int retry = 0; retry < 3; retry++) {
            initCode = faceEngine.init(engineConfiguration);
            if (initCode == ErrorInfo.MOK.getValue()) {
                break;
            }
        }
        if (initCode != ErrorInfo.MOK.getValue()) {
            throw new ArcFaceSdkException("人脸比对引擎初始化失败:" + initCode);
        }
        return faceEngine;
    }

    @Override
    public PooledObject<FaceEngine> wrap(FaceEngine faceEngine) {
        return new DefaultPooledObject<>(faceEngine);
    }


    @Override
    public void destroyObject(PooledObject<FaceEngine> p) throws Exception {
        FaceEngine faceEngine = p.getObject();
        int unInitCode = faceEngine.unInit();
        System.out.println("faceEngineUnInitCode:" + unInitCode);
        super.destroyObject(p);
    }
}
