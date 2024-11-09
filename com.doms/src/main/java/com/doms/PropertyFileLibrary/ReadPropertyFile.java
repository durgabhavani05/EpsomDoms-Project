package com.doms.PropertyFileLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.doms.GenericLibrary.FrameworkConstant;

/**
 * This Class Provides the Reusable Method To Read And Write The Data To The Property File
 * @author bhavani
 */

public class ReadPropertyFile  implements  FrameworkConstant
{
	public FileInputStream fis;
	
	public Properties property;
	
	public FileOutputStream fos;
	
	public String readData(String key)
	{
		//1.Convert the physical file into java Readable file
		
		try 
		{
			fis = new FileInputStream(propertypath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// 2.Create an object for properties class
		
		property = new Properties();
		
		//3. load all the keys/Data
		try
		{
			property.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//4. fetch the Data
		
		String data = property.getProperty(key);
		return data;
	}
	
	public void writeData(String Key, String value)
	{
		//1.Convert the physical file into java Readable file
		
				try 
				{
					fis = new FileInputStream(propertypath);
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
				
				// 2.Create an object for properties class
				
				property = new Properties();
				
				//3. load all the keys/Data
				try
				{
					property.load(fis);
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				
				//4. write the Data
				
				property.put(Key, value);
				
				//5. convert java readable into physical file
	
				try {
					fos = new FileOutputStream(propertypath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// 6. store the  data
				
				try {
					property.store(fos, "Latest key Updated Successfull");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}
}
