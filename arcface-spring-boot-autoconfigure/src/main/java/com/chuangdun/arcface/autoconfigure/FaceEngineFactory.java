package com.chuangdun.arcface.autoconfigure;

import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.enums.ErrorInfo;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nick
 */
public class FaceEngineFactory extends BasePooledObjectFactory<FaceEngine> {
    private static final Logger logger = LoggerFactory.getLogger(FaceEngineFactory.class);

    private final String appId;
    private final String sdkKey;
    private final String sdkLibPath;
    private final EngineConfiguration engineConfiguration;

    public FaceEngineFactory(String sdkLibPath, String appId, String sdkKey, EngineConfiguration engineConfiguration) {
        this.sdkLibPath = sdkLibPath;
        this.appId = appId;
        this.sdkKey = sdkKey;
        this.engineConfiguration = engineConfiguration;
        logger.debug("虹软人脸识别引擎对象工厂实例化成功");
    }

    @Override
    public FaceEngine create() throws Exception {
        FaceEngine faceEngine = new FaceEngine(sdkLibPath);
        int activeCode = faceEngine.activeOnline(appId, sdkKey);
        logger.info("虹软人脸识别SDK引擎激活结果码:{}", activeCode);
        if (activeCode != ErrorInfo.MOK.getValue()
                && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            throw new ArcFaceActiveException("虹软人脸识别SDK引擎激活失败,请检查配置:" + activeCode);
        }
        int initCode = ErrorInfo.MERR_UNKNOWN.getValue();
        for (int retry = 0; retry < 3; retry++) {
            initCode = faceEngine.init(engineConfiguration);
            if (initCode == ErrorInfo.MOK.getValue()) {
                break;
            }
            logger.info("虹软人脸识别SDK引擎初始化结果码:{}", initCode);
        }
        if (initCode != ErrorInfo.MOK.getValue()) {
            throw new ArcFaceInitException("虹软人脸识别SDK引擎初始化失败:" + initCode);
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
        int resultCode = faceEngine.unInit();
        logger.debug("虹软人脸识别SDK引擎实例销毁结果码:{}", resultCode);
        if (resultCode != ErrorInfo.MOK.getValue()){
            logger.warn("虹软人脸识别SDK引擎实例销毁失败:{}", resultCode);
        }
        super.destroyObject(p);
    }
}
