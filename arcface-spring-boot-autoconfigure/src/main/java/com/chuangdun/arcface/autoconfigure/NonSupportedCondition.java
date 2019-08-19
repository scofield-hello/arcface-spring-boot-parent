package com.chuangdun.arcface.autoconfigure;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author nick
 */
public class NonSupportedCondition implements Condition {
    private static final String ENV_PROPERTY_OS_NAME = "os.name";
    private static final String MAC_OS_NAME = "Mac OS X";

    private static final String[] NON_SUPPORTED_OS = {MAC_OS_NAME};


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String osName = context.getEnvironment().getProperty(ENV_PROPERTY_OS_NAME);
        for (String nonSupportOsName : NON_SUPPORTED_OS) {
            if (osName.toUpperCase().startsWith(nonSupportOsName.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
