package com.shedin.apicore.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration("classpath:spring/api-context.xml")
public class CucumberSpringConfiguration {
}