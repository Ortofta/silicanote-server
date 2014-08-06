package org.silicanote.engine.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.silicanote.engine.dao.NoteDao;
import org.silicanote.engine.dao.NoteDaoMongoImpl;
import org.silicanote.engine.dao.UserDao;
import org.silicanote.engine.dao.UserDaoMongoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Markus Svensson
 */
@Configuration
public class MongoConfig {

    @Bean(name = "uri")
    public MongoClientURI getMongoUri() {
        MongoClientURI uri = new MongoClientURI(System.getenv("MONGO_URI"));
        return uri;
    }
    
    @Bean(name = "userCollectionName")
    public String getUserCollectionName() {
        return System.getenv("MONGO_USER_COLLECTION");
    }
    
    @Bean(name = "noteCollectionName")
    public String getNoteCollectionName() {
        return System.getenv("MONGO_NOTE_COLLECTION");
    }
    
    @Bean
    DB getDb() throws UnknownHostException {
        MongoClient client = new MongoClient(getMongoUri());
        return client.getDB(getMongoUri().getDatabase());
    }
    
    @Bean
    Jongo getJango() throws UnknownHostException {
        return new Jongo(getDb());
    }

    @Bean(name = "noteCollection")
    MongoCollection getNoteCollection() throws UnknownHostException {
        return getJango().getCollection(getNoteCollectionName());
    }
    
    @Bean(name = "userCollection")
    MongoCollection getUserCollection() throws UnknownHostException {
        return getJango().getCollection(getUserCollectionName());
    }
    
    @Bean(name = "mongoDao")
    NoteDao getNoteDao() {
        return new NoteDaoMongoImpl();
    }

    @Bean(name = "mongoUserDao")
    UserDao getUSerDao() {
        return new UserDaoMongoImpl();
    }
    
}
