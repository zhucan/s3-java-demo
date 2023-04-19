
package com.example;

import java.net.URI;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.*;

/**
 * The module containing all dependencies required by the {@link Handler}.
 */
public class DependencyFactory {

    private DependencyFactory() {}

    /**
     * @return an instance of S3Client
     */
    public static S3Client s3Client() {
        String ak = "5PQTLJDXUJFDVQQ5BONN";
        String sk = "MdfAOy4ICeAncnqWpXOYnGG5v9tIINHw5cdzuxKp";
        String endpoint = "http://10.3.8.39:80";
        
        AwsCredentials credentials = AwsBasicCredentials.create(ak, sk);
        S3Configuration s3config = S3Configuration.builder().pathStyleAccessEnabled(true)
        .build();

        S3Client s3 = S3Client.builder()
                .endpointOverride(URI.create(endpoint))
                .serviceConfiguration(s3config)
                .region(Region.US_EAST_1) 
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
        
        return s3;
    }
}
