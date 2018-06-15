package com.ttyc.mq.common.config;

import org.apache.http.conn.ssl.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Configuration
public class RestTempLateConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public RestTemplate sslRestTemplate() throws KeyStoreException {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

    @Bean
    public RestTemplate httpsTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        return new RestTemplate(requestFactory);
    }

    /**
     * @author yangjie
     * @description  有需求再扩展，默认的就挺好了
     * @createTime 2018/6/1
     */
    private static class MyResponseErrorHandler implements ResponseErrorHandler {
        private static final Logger logger = LoggerFactory.getLogger(RestTempLateConfig.MyResponseErrorHandler.class);
        @Override
        public void handleError(ClientHttpResponse clienthttpresponse) throws IOException {
            // 设置各种拦截
            if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
                logger.debug(HttpStatus.FORBIDDEN + " response. Throwing authentication exception");
                throw new RuntimeException();
            }
        }
        @Override
        public boolean hasError(ClientHttpResponse clienthttpresponse) throws IOException {

            if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
                logger.debug("Status code: " + clienthttpresponse.getStatusCode());
                logger.debug("Response" + clienthttpresponse.getStatusText());

                if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
                    logger.debug("Call returned a exception 403 forbidden resposne ");
                    return true;
                }
            }
            return false;
        }
    }
}
