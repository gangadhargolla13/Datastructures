package com.java.json;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonFileReading {
	public static void main(String[] args) {
		try{
			System.out.println("Process is started");
			JSONParser parser = new JSONParser();
			
			Object obj = parser.parse(new FileReader(
                    "C://Ganga123//gangadhar.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
            //connection
            String name = (String) jsonObject.get("connection");
            System.out.println("Connection name : "+name);
            jsonObject.put("connection", "maprfs://vmy1618:7222");
            //jsonObject.put("connection", "maprfs://vmy1618:7222");
            String name1 = (String) jsonObject.get("connection");
            System.out.println("Connection name : "+name1);
            System.out.println("=========");
            FileWriter file = new FileWriter("C://Ganga123//test1232.json");
            String text1=jsonObject.toJSONString().replace("\\", "");
            file.write(text1);
            file.flush();
            file.close();
            
            System.out.println("Operation is completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
