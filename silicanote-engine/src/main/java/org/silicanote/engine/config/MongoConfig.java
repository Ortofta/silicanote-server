package org.silicanote.engine.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.silicanote.engine.dao.NoteDao;
import org.silicanote.engine.dao.NoteDaoMongoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Markus Svensson
 */
@Configuration
public class MongoConfig {

    @Value("${silicanote.mongodb.host}")
    private String dbHost;

    @Value("${silicanote.mongodb.dbname}")
    private String dbName;
    
    @Value("${silicanote.mongodb.notecollection}")
    private String noteCollectionName;
    
    @Value("${silicanote.mongodb.usercollection}")
    private String userCollectionName;
    
    @Bean
    DB getDb() throws UnknownHostException {
        ServerAddress address = new ServerAddress(dbHost);
        MongoClient client = new MongoClient(address);
        return client.getDB(dbName);
    }
    
    @Bean
    Jongo mongoTemplate(DB db) throws UnknownHostException {
        return new Jongo(db);
    }

    @Bean
    MongoCollection getNoteCollection() throws UnknownHostException {
        return mongoTemplate(getDb()).getCollection(noteCollectionName);
    }
    
    @Bean
    MongoCollection getUserCollection() throws UnknownHostException {
        return mongoTemplate(getDb()).getCollection(userCollectionName);
    }
    
    @Bean
    NoteDao getNoteDao() {
        return new NoteDaoMongoImpl();
    }

}
