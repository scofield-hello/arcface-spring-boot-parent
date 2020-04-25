package com.chuangdun.arcface.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Nick
 */
public class NonSupportedCondition implements Condition {
    private static final Logger logger = LoggerFactory.getLogger(NonSupportedCondition.class);
    private static final String ENV_PROPERTY_OS_NAME = "os.name";
    private static final String MAC_OS_NAME = "Mac OS X";

    private static final String[] NON_SUPPORTED_OS = {MAC_OS_NAME};


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String osName = context.getEnvironment().getProperty(ENV_PROPERTY_OS_NAME);
        for (String nonSupportOsName : NON_SUPPORTED_OS) {
            if (osName.toUpperCase().startsWith(nonSupportOsName.toUpperCase())) {
                logger.info("您当前的操作系统并不支持使用虹软人脸识别SDK:{}", osName);
                return true;
            }
        }
        logger.info("您当前的操作系统支持使用虹软人脸识别SDK:{}", osName);
        return false;
    }
}
