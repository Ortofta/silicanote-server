package org.silicanote.engine.config;

import com.mongodb.Mongo;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author Markus Svensson
 */
@Configuration
@EnableMongoRepositories
public class EngineConfig {

    @Value("${silicanote.mongodb.host}")
    private String dbHost;

    @Value("${silicanote.mongodb.dbname}")
    private String dbName;
    
    @Bean
    MongoTemplate mongoTemplate(Mongo mongo) throws UnknownHostException {
        return new MongoTemplate(new Mongo(dbHost), dbName);
    }

}
