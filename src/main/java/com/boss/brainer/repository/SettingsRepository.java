package com.boss.brainer.repository;

import com.boss.brainer.domain.mongo.Settings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SettingsRepository extends MongoRepository<Settings, String>{

    Settings findByUserId(String userId);
}
