package com.boss.brainer.service;

import com.boss.brainer.domain.mongo.Settings;
import com.boss.brainer.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultSettingsService implements SettingsService {

    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public Settings findByUserId(String userId) {
        return settingsRepository.findByUserId(userId);
    }

    @Override
    public Settings saveSettings(Settings settings) {
        return settingsRepository.save(settings);
    }
}
