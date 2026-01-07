package com.self.designPattern.singleton.config;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private AppConfig() {}
    public static AppConfig getInstance() {
        return INSTANCE;
    }
}