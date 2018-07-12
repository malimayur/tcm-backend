package com.tcm.test;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tcm.model.Customer;

public class RestfulClient {
	RestTemplate restTemplate;
    public RestfulClient(){
    restTemplate = new RestTemplate();
   // restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    
    //@Test
    public void getEntity(){
    	String plainCreds = "test:test";
    	byte[] plainCredsBytes = plainCreds.getBytes();
    	byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    	String base64Creds = new String(base64CredsBytes);

    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Authorization", "Basic " + base64Creds);
    	HttpEntity<String> request = new HttpEntity<String>(headers);
        System.out.println("Begin /GET request!");
        //String getUrl = "http://localhost:8080/get?id=1&name='Mary'&age=20";
        String getUrl = "http://localhost:8090/tcm/findbylastname/m";
        /*ResponseEntity<Customer> getResponse = restTemplate.getForEntity(getUrl, Customer.class);*/
        ResponseEntity<Customer[]> getResponse = restTemplate.exchange(getUrl, HttpMethod.GET, request, Customer[].class);
        if(getResponse.getBody() != null){
            System.out.println("Response for Get Request: " + getResponse.getBody().toString());
            Customer[] customer = getResponse.getBody();
            System.out.println("First name is::" +customer[0].getFirstName());
        }else{
            System.out.println("Response for Get Request: NULL");
        }
    }
}
