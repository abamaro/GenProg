package seis610.gp.control;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

import seis610.gp.util.Utilities;

public class Data {
	
	public Hashtable<String,String> readSettingFile(File file){
		Utilities.$("read init file '" + file.getPath() + "'");
		Hashtable<String,String> settings = new Hashtable<String,String>();
		try{
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream in	= new DataInputStream(fstream);
			BufferedReader br 	= new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				if(!strLine.equals("")){
					String[] setting = strLine.split("=");				
					String key = setting[0];
					String value = setting[1].replace(";","");
					settings.put(key,value);
				}
			}
			in.close();
			Utilities.$("read init file complete.");
		}
		catch (Exception e){
			System.err.println("Error reading file " + file.getPath());
			System.err.println("=---");
			e.printStackTrace(System.err); 
			System.err.println("---=");
		}
		return settings;
		
	}

	public ArrayList<Double[]> readTrainingFile(File trainingset_file) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
