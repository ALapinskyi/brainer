package com.boss.brainer.service;

import com.boss.brainer.domain.mongo.Settings;

public interface SettingsService {

    Settings findByUserId(String userId);

    Settings saveSettings(Settings settings);
}
