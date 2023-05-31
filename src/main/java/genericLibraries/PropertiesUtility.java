package genericLibraries;
/** 
 * this class contains all resuable methods to perform operation 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property; 
		public void propertiesInit(String filepath) {
			FileInputStream fis=null;
			try
			{
			fis=new FileInputStream (filepath);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
	 
			property =new Properties();
	try
	{
	property.load(fis);
	}catch(IOException e) {
		e.printStackTrace();
	} 
		}
	
	/**
	 * this method is used to fetch data from properties file using key
	 * @param key
	 * @return
	 */



	public String readDataFromProperty( String key) {
		return property.getProperty(key);
	}
/**
 * this method is used to write  data to  properties file 
 * @param key
 * @param  value
 * @param filepath
 * @param comments
 * @param fos 
 */
public void writeToProperties(String key,String value,String filePath,String comments, Writer fos) {
	property.put(key, value);
	FileOutputStream  fos1=null;
	
	try {
		 fos1=new FileOutputStream(filePath);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	try
	{
	property .store(fos1,comments);
	}catch(IOException e) {
		e.printStackTrace();
	}
	
}


}

	


