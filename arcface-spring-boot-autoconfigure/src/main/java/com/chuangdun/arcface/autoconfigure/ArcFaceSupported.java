package com.chuangdun.arcface.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Nick
 */
public class ArcFaceSupported implements Condition {
    private static final Logger logger = LoggerFactory.getLogger(ArcFaceSupported.class);

    private static final String ENV_PROPERTY_OS_NAME = "os.name";
    private static final String WINDOWS_OS_NAME = "Win";
    private static final String LINUX_OS_NAME = "Linux";

    private static final String[] SUPPORTED_OS = {WINDOWS_OS_NAME, LINUX_OS_NAME};


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String osName = context.getEnvironment().getProperty(ENV_PROPERTY_OS_NAME);
        for (String supportOsName : SUPPORTED_OS) {
            if (osName.toUpperCase().startsWith(supportOsName.toUpperCase())) {
                logger.info("您当前的操作系统支持使用虹软人脸识别SDK:{}", osName);
                return true;
            }
        }
        logger.info("您当前的操作系统并不支持使用虹软人脸识别SDK:{}", osName);
        return false;
    }
}
