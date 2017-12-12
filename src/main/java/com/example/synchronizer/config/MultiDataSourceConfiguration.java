package com.example.synchronizer.config;

import com.example.synchronizer.DynamicRoutingDataSourceResolver;
import com.example.synchronizer.util.Const;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MultiDataSourceConfiguration {

    private StagingDataSourceConfiguration stagingDataSourceConfiguration;
    private ProductionDataSourceConfiguration productionDataSourceConfiguration;

    MultiDataSourceConfiguration(StagingDataSourceConfiguration stagingDataSourceConfiguration, ProductionDataSourceConfiguration productionDataSourceConfiguration) {
        this.stagingDataSourceConfiguration = stagingDataSourceConfiguration;
        this.productionDataSourceConfiguration = productionDataSourceConfiguration;
    }

    @Bean
    public DynamicRoutingDataSourceResolver datasource() {

        DynamicRoutingDataSourceResolver dynamicRoutingDataSourceResolver = new DynamicRoutingDataSourceResolver();

        Map<Object, Object> dataSource = new HashMap<>();
        dataSource.put(Const.STAGING_DATA_SOURCE, getStagingDataSourceConfiguration());
        dataSource.put(Const.PRODUCTION_DATA_SOURCE, getProductionDataSourceConfiguration());

        dynamicRoutingDataSourceResolver.setTargetDataSources(dataSource);
        dynamicRoutingDataSourceResolver.setDefaultTargetDataSource(getStagingDataSourceConfiguration());

        return dynamicRoutingDataSourceResolver;
    }

    private StagingDataSourceConfiguration getStagingDataSourceConfiguration() {
        return stagingDataSourceConfiguration;
    }

    private ProductionDataSourceConfiguration getProductionDataSourceConfiguration() {
        return productionDataSourceConfiguration;
    }

}
