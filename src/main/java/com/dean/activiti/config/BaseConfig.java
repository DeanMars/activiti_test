package com.dean.activiti.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BaseConfig {


    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }


    @Bean
    public ProcessEngineConfiguration standaloneProcessEngineConfiguration(DataSource dataSource){
        StandaloneProcessEngineConfiguration processEngineConfiguration=new StandaloneProcessEngineConfiguration();
        processEngineConfiguration.setDataSource(dataSource());
        return processEngineConfiguration;
    }


    @Bean
    public ProcessEngine processEngine(ProcessEngineConfiguration processEngineConfiguration){
        return processEngineConfiguration.buildProcessEngine();
    }


    @Bean
    public RepositoryService repositoryService(ProcessEngineConfiguration processEngineConfiguration){
        return processEngineConfiguration.getRepositoryService();
    }


    @Bean
    public RuntimeService runtimeService(ProcessEngineConfiguration processEngineConfiguration){
        return processEngineConfiguration.getRuntimeService();
    }


    @Bean
    public TaskService taskService(ProcessEngineConfiguration processEngineConfiguration){
        return processEngineConfiguration.getTaskService();
    }

}
