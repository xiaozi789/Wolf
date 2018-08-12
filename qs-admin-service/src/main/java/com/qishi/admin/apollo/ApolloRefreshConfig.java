package com.qishi.admin.apollo;

import com.ctrip.framework.apollo.ConfigFile;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by sun.yingjie on 2017/10/10.
 */
@Component
public class ApolloRefreshConfig
{
    private static final Logger logger = LoggerFactory.getLogger(ApolloRefreshConfig.class);

    private ConfigFile configFile;

    @Autowired
    private RefreshScope refreshScope;

    public ApolloRefreshConfig() {
        configFile = ConfigService.getConfigFile("application", ConfigFileFormat.Properties);
        print(configFile);
    }

    private void print(ConfigFile configFile) {
        if (!configFile.hasContent()) {
            logger.info("No config file content found for {}", configFile.getNamespace());
            return;
        }
        logger.info("=== Config File Content for {} is as follows: ", configFile.getNamespace());
        logger.info(configFile.getContent());
    }


    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        refreshScope.refreshAll();
        String configFileContent = configFile.getContent();
        logger.info("refresh after applicationConfigFile {}",configFileContent);
    }
}
