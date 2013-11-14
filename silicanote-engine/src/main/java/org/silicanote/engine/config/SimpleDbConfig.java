package org.silicanote.engine.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
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
        return System.getProperty("SDB_DOMAIN", "SilicaNoteDataStore");
    }
    
    @Bean(name = "regionName")
    public String getRegionName() {
        return System.getProperty("SDB_REGION", Regions.AP_NORTHEAST_1.getName());
    }
    
    @Bean(name = "sdbClient")
    public AmazonSimpleDB getSdbClient() {
        AWSCredentials credentials = new BasicAWSCredentials(System.getProperty("AWS_ACCESS_KEY_ID"), System.getProperty("AWS_SECRET_KEY"));
        AmazonSimpleDB sdb = new AmazonSimpleDBClient(credentials);
        sdb.setRegion(Region.getRegion(Regions.fromName(getRegionName())));
        return sdb;
    }
}
