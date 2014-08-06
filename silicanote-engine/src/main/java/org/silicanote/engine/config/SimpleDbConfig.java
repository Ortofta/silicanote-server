package org.silicanote.engine.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import javax.annotation.PostConstruct;
import org.silicanote.engine.dao.NoteDao;
import org.silicanote.engine.dao.NoteDaoAwsSimpleDbImpl;
import org.silicanote.engine.dao.UserDao;
import org.silicanote.engine.dao.UserDaoAwsSimpleDbImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Markus Svensson
 */
@Configuration
public class SimpleDbConfig {

    @Bean(name = "domainName")
    public String getDomainName() {
        return System.getenv("SDB_DOMAIN");
    }

    @Bean(name = "userDomainName")
    public String getUserDomainName() {
        return System.getenv("SDB_USER_DOMAIN");
    }
    
    @Bean(name = "regionName")
    public String getRegionName() {
        return System.getenv("SDB_REGION");
    }

    @Bean(name = "sdbClient")
    public AmazonSimpleDB getSdbClient() {
        AWSCredentials credentials = new BasicAWSCredentials(System.getenv("AWS_ACCESS_KEY_ID"), System.getenv("AWS_SECRET_KEY"));
        AmazonSimpleDB sdb = new AmazonSimpleDBClient(credentials);
        sdb.setRegion(Region.getRegion(Regions.fromName(getRegionName())));
        return sdb;
    }

    @Bean
    NoteDao getSimpleDbDao() {
        return new NoteDaoAwsSimpleDbImpl();
    }
    
    @Bean(name = "simpleDbUserDao")
    UserDao getUserDao() {
        return new UserDaoAwsSimpleDbImpl();
    }
    
    @PostConstruct
    public void createDomains() {
        getSdbClient().createDomain(new CreateDomainRequest(getDomainName()));
        getSdbClient().createDomain(new CreateDomainRequest(getUserDomainName()));
    }
}
