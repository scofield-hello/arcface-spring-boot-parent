package com.chuangdun.arcface.autoconfigure;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author nick
 */
public class SupportiveCondition implements Condition {
    private static final String ENV_PROPERTY_OS_NAME = "os.name";
    private static final String WINDOWS_OS_NAME = "Windows";
    private static final String LINUX_OS_NAME = "Linux";

    private static final String[] SUPPORTED_OS = {WINDOWS_OS_NAME, LINUX_OS_NAME};


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String osName = context.getEnvironment().getProperty(ENV_PROPERTY_OS_NAME);
        for (String supportOsName : SUPPORTED_OS) {
            if (osName.toUpperCase().startsWith(supportOsName.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
