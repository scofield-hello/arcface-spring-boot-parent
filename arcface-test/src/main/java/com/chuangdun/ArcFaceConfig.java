package com.chuangdun;

import com.arcsoft.face.FaceEngine;
import com.chuangdun.arcface.autoconfigure.FaceEnginePool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArcFaceConfig {
    private static final Logger logger = LoggerFactory.getLogger(ArcFaceConfig.class);

    @Bean
    public FaceEngine faceEngine(FaceEnginePool faceEnginePool){
        FaceEngine engine = null;
        try {
            engine = faceEnginePool.borrowObject();
            logger.debug("face engine instance:{}", engine);
            faceEnginePool.returnObject(engine);
        } catch (Exception e){
            logger.error("发生错误了", e);
        }
        return engine;
    }
}
