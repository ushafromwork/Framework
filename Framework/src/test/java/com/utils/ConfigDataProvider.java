package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
  
	Properties pro;
	
	public ConfigDataProvider(){
		
		File src=new File("./config/config.properties");
		
			try {
				FileInputStream fis=new FileInputStream(src);
				
				pro=new Properties();
				pro.load(fis);
			} catch (Exception e) {
				
				System.out.println("unable to load config file"+e.getMessage());
			} 
		
		
	}
	
	public String getDatafromconfig(String  keyToSearch){
		return pro.getProperty(keyToSearch);
	}
	
	
	public String getBrowser(){
		 return pro.getProperty("Browser");
	}
	
	
	public String getqaURL(){
		return pro.getProperty("qaURL");
	}
}
