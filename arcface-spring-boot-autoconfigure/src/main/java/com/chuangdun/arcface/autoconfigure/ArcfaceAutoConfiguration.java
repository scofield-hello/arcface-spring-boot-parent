package com.chuangdun.arcface.autoconfigure;

import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FunctionConfiguration;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author nick
 */
@Configuration
@ConditionalOnClass(FaceEngine.class)
@ConditionalOnProperty(prefix = "face.sdk", name = "enabled", havingValue = "true", matchIfMissing = true)
@Conditional({SupportiveCondition.class})
@EnableConfigurationProperties(ArcEngineProperties.class)
public class ArcfaceAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ArcfaceAutoConfiguration.class);

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
        functionConfiguration.setSupportIRLiveness(properties.isIrLivenessEnabled());
        logger.debug("虹软人脸识别功能配置类实例化成功.");
        return functionConfiguration;
    }

    @Bean
    @ConditionalOnMissingBean
    public EngineConfiguration engineConfiguration(FunctionConfiguration functionConfiguration) {
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);
        logger.debug("虹软人脸识别引擎配置类实例化成功.");
        return engineConfiguration;
    }

    @Bean
    @ConditionalOnMissingBean
    public FaceEngineFactory faceEngineFactory(ArcEngineProperties properties, EngineConfiguration configuration) {
        if (properties.getLocation() == null) {
            throw new NullPointerException("请您先配置face.sdk.location项");
        }
        if (properties.getAppId() == null) {
            throw new NullPointerException("请您先配置face.sdk.app-id项");
        }
        if (properties.getSdkKey() == null) {
            throw new NullPointerException("请您先配置face.sdk.sdk-key项");
        }
        return new FaceEngineFactory(properties.getLocation(), properties.getAppId(), properties.getSdkKey(), configuration);
    }
}
