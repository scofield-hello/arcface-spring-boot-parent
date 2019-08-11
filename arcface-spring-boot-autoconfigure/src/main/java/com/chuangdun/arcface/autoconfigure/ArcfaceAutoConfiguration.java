package com.chuangdun.arcface.autoconfigure;

import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FunctionConfiguration;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nick
 */
@Configuration
@ConditionalOnClass(FaceEngine.class)
@EnableConfigurationProperties(ArcEngineProperties.class)
public class ArcfaceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public FunctionConfiguration functionConfiguration(ArcEngineProperties properties) {
        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(properties.isAgeDetectEnabled());
        functionConfiguration.setSupportFace3dAngle(properties.isFace3dAngleEnabled());
        functionConfiguration.setSupportFaceDetect(properties.isFaceDetectEnabled());
        functionConfiguration.setSupportFaceRecognition(properties.isFaceRecognitionEnabled());
        functionConfiguration.setSupportGender(properties.isGenderDetectEnabled());
        functionConfiguration.setSupportLiveness(properties.isLivenessEnabled());
        functionConfiguration.setSupportIRLiveness(properties.isIRLivenessEnabled());
        return functionConfiguration;
    }

    @Bean
    @ConditionalOnMissingBean
    public EngineConfiguration engineConfiguration(FunctionConfiguration functionConfiguration) {
        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);
        return engineConfiguration;
    }

    @Bean
    @ConditionalOnMissingBean
    public FaceEngine faceEngine(ArcEngineProperties properties) {
        if (properties.getLocation() == null) {
            throw new NullPointerException("请您先配置face.sdk.location项");
        }
        if (properties.getAppId() == null) {
            throw new NullPointerException("请您先配置face.sdk.app-id项");
        }
        if (properties.getSdkKey() == null) {
            throw new NullPointerException("请您先配置face.sdk.sdk-key项");
        }
        FaceEngine faceEngine = new FaceEngine(properties.getLocation());
        int activeCode = faceEngine.activeOnline(properties.getAppId(),
                properties.getSdkKey());
        if (activeCode != ErrorInfo.MOK.getValue()
                && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            throw new IllegalStateException("虹软人脸引擎激活失败,请检查配置:" + activeCode);
        }
        return faceEngine;
    }
}
