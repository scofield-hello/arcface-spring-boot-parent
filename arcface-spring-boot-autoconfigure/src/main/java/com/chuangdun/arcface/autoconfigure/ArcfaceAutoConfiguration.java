package com.chuangdun.arcface.autoconfigure;

import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FunctionConfiguration;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
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
@Conditional({ArcFaceSupported.class})
@EnableConfigurationProperties(value = {ArcEngineProperties.class, ArcEnginePoolProperties.class})

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

    @Bean
    @ConditionalOnMissingBean
    public FaceEnginePool faceEnginePool(FaceEngineFactory faceEngineFactory, ArcEnginePoolProperties poolProperties){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(poolProperties.getMaxIdle());
        config.setMaxTotal(poolProperties.getMaxTotal());
        config.setMinIdle(poolProperties.getMinIdle());
        config.setBlockWhenExhausted(poolProperties.isBlockWhenExhausted());

        config.setFairness(poolProperties.isFairness());
        config.setJmxEnabled(poolProperties.isJmxEnabled());
        config.setJmxNameBase(poolProperties.getJmxNameBase());
        config.setJmxNamePrefix(poolProperties.getJmxNamePrefix());
        config.setMaxWaitMillis(poolProperties.getMaxWaitMillis());

        config.setNumTestsPerEvictionRun(poolProperties.getNumTestsPerEvictionRun());
        config.setEvictorShutdownTimeoutMillis(poolProperties.getEvictorShutdownTimeoutMillis());
        config.setMinEvictableIdleTimeMillis(poolProperties.getMinEvictableIdleTimeMillis());
        config.setSoftMinEvictableIdleTimeMillis(poolProperties.getSoftMinEvictableIdleTimeMillis());
        config.setTimeBetweenEvictionRunsMillis(poolProperties.getTimeBetweenEvictionRunsMillis());

        config.setLifo(poolProperties.isLifo());
        config.setTestOnBorrow(poolProperties.isTestOnBorrow());
        config.setTestOnCreate(poolProperties.isTestOnCreate());
        config.setTestOnReturn(poolProperties.isTestOnReturn());
        config.setTestWhileIdle(poolProperties.isTestWhileIdle());

        FaceEnginePool faceEnginePool = new FaceEnginePool(faceEngineFactory, config);
        logger.debug("虹软人脸识别引擎对象池实例化成功.");
        return faceEnginePool;
    }
}
