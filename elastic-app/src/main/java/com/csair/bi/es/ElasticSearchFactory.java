package com.csair.bi.es;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticSearchFactory {

	private TransportClient transportClient;

	private RestClient restClient;

	ObjectMapper mapper ;

	public ElasticSearchFactory(){
		transportClientInit();
		restClientInit();
		mapper = new ObjectMapper();
	}
	
	public void restClientInit(){
		
		  restClient = RestClient.builder(new HttpHost("10.95.68.183", 9200))
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


	public void transportClientInit(){

		Settings settings = Settings.builder()
				.put("cluster.name", "oa-test-app").build();
		try{


		transportClient = new PreBuiltTransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.95.68.183"), 9300))
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.95.68.84"), 9300))
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.95.68.85"), 9300));

		} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	public String indexDocument(String index,String type,long id,String filePath) {

		IndexResponse response = null;
//		transportClient.prepareBulk().add(IndexRequestBuilder)
//			response = transportClient.prepareIndexRequest("collectionName").setId(dto.getId())
//					.setSource(XContentFactory.jsonBuilder().jsonBuilder().startObject()
//							.field("file", Base64.encodeFromFile(filePath))
//s							.endObject()).setRefresh(true).execute().actionGet();

		return response.getId();
	}

 	public boolean index(Object object,String index,String type) throws JsonProcessingException {
		// generate json
		byte[] json = mapper.writeValueAsBytes(object);
//		String json = 	mapper.writeValueAsString(object);

		IndexResponse response = transportClient.prepareIndex(index,type).setSource(json, XContentType.JSON).get();
		if(response.status().equals(DocWriteResponse.Result.CREATED)){
			return true;
		}else
			return false;
	}

	public boolean update(Object object,String index,String type,String id) throws JsonProcessingException {
		// generate json
		byte[] json = mapper.writeValueAsBytes(object);
//		String json = 	mapper.writeValueAsString(object);

		UpdateResponse response = transportClient.prepareUpdate(index,type,id).setUpsert(json,XContentType.JSON).get();

		if(response.status().equals(DocWriteResponse.Result.UPDATED)){
			return true;
		}else
			return false;
	}

	public boolean delete(Object object,String index, String type, String id)throws JsonProcessingException {
		// generate json
		byte[] json = mapper.writeValueAsBytes(object);
//		String json = 	mapper.writeValueAsString(object);

		DeleteResponse response = transportClient.prepareDelete(  index,   type,   id).get();
		if(response.status().equals(DocWriteResponse.Result.DELETED)){
			return true;
		}else
			return false;
	}


	public void test(){
		
		try {


			XContentBuilder builder = XContentFactory.jsonBuilder()
				    .startObject()
				        .field("first_name", "leisy")
				        .field("last_name", "lei")
						.field("age",25)
					.field("about", "I love to go rock climbing")
					.field("interests","sports")
				    .endObject();



			IndexResponse response = transportClient.prepareIndex("megacorp", "employee", "1")
					.setSource(builder)
					.get();




			System.out.println(response.toString());
//			IndexResponse response = transportClient.prepareIndex("twitter", "tweet", "2")
//			        .setSource(builder)
//			        .get();


//			GetResponse response = transportClient.prepareGet("megacorp", "employee", "1")
//					.setOperationThreaded(false)
//					.get();
//			response = transportClient.prepareGet("shakespeare","line","14").setOperationThreaded(false).get();


			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	}
	
	
	public static void main(String[] args){
		ElasticSearchFactory esf = new ElasticSearchFactory();
		esf.test();
		
	}
}
