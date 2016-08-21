/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commenterteam.commenter.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
//import net.sf.json.JSONObject;

/**
 *
 * @author stephen
 */
public class BaiduApi {
    
    public static Map<String, BigDecimal> getLatAndLngByAddress(String addr){
        String address = "";
        String lat = "";
        String lng = "";
        try {  
            address = java.net.URLEncoder.encode(addr,"UTF-8");  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } 
        String url = String.format("http://api.map.baidu.com/geocoder/v2/?"
        +"ak=4rcKAZKG9OIl0wDkICSLx8BA&output=json&address=%s",address);
        URL myURL = null;
        URLConnection httpsConn = null;  
        //进行转码
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {

        }
        try {
            httpsConn = (URLConnection) myURL.openConnection();
            if (httpsConn != null) {
                InputStreamReader insr = new InputStreamReader(
                        httpsConn.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(insr);
                String data = null;
                if ((data = br.readLine()) != null) {
                    lat = data.substring(data.indexOf("\"lat\":") 
                    + ("\"lat\":").length(), data.indexOf("},\"precise\""));
                    lng = data.substring(data.indexOf("\"lng\":") 
                    + ("\"lng\":").length(), data.indexOf(",\"lat\""));
                }
                insr.close();
            }
        } catch (IOException e) {

        }
        Map<String, BigDecimal> map = new HashMap<>();
        map.put("lat", new BigDecimal(lat));
        map.put("lng", new BigDecimal(lng));
        return map;
}
    
//    public static Map<String,Double> getLngAndLat(String address){
//		Map<String,Double> map=new HashMap<String, Double>();
//		 String url = "http://api.map.baidu.com/geocoder/v2/?address="+address+"&output=json&ak=你自己的ak值";
//	        String json = loadJSON(url);
//	        JSONObject obj = JSONObject.fromObject(json);
//	        if(obj.get("status").toString().equals("0")){
//	        	double lng=obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
//	        	double lat=obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
//	        	map.put("lng", lng);
//	        	map.put("lat", lat);
//	        	//System.out.println("经度："+lng+"---纬度："+lat);
//	        }else{
//	        	//System.out.println("未找到相匹配的经纬度！");
//	        }
//		return map;
//	}
//	
//	 public static String loadJSON (String url) {
//	        StringBuilder json = new StringBuilder();
//	        try {
//	            URL oracle = new URL(url);
//	            URLConnection yc = oracle.openConnection();
//	            BufferedReader in = new BufferedReader(new InputStreamReader(
//	                                        yc.getInputStream()));
//	            String inputLine = null;
//	            while ( (inputLine = in.readLine()) != null) {
//	                json.append(inputLine);
//	            }
//	            in.close();
//	        } catch (MalformedURLException e) {
//	        } catch (IOException e) {
//	        }
//	        return json.toString();
//	    }
}

	