package com.csair.bi.es;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticSearchFactory {

	
	
	public void restClientTest(){
		
		RestClient restClient = RestClient.builder(new HttpHost("10.95.68.183", 9200))
		        .setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
		            @Override
		            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
		                return requestConfigBuilder.setConnectTimeout(5000)
		                        .setSocketTimeout(60000);
		            }
		        })
		        .setMaxRetryTimeoutMillis(60000)
		        .build();
		
		
		
	}
	
	public void test(){
		
		try {
			
			Settings settings = Settings.builder()
			        .put("cluster.name", "oa-test-app").build();
			TransportClient client = new PreBuiltTransportClient(settings)
			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.95.68.183"), 9300));
			
			
			XContentBuilder builder = XContentFactory.jsonBuilder()
				    .startObject()
				        .field("user", "kimchy")
				        .field("postDate", new Date())
				        .field("message", "trying out Elasticsearch")
				    .endObject();
			
			
			IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
			        .setSource(builder)
			        .get();
			 
			System.out.println(response.getId());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String[] args){
		ElasticSearchFactory esf = new ElasticSearchFactory();
		esf.test();
		
	}
}
