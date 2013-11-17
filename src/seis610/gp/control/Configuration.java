package seis610.gp.control;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import seis610.gp.control.Data;

public class Configuration {

	File settings_file;
	File trainingset_file;
	Hashtable<String,String> 	settings;
	ArrayList<Double[]> 		training_set;
	
	public Configuration(File[] file){
		this.settings_file 		= file[0];
		this.trainingset_file	= file[1];
		initialize();
	}
	private void initialize(){
		Data data 		= new Data();
		settings 		= data.readSettingFile(settings_file);
		training_set	= data.readTrainingFile(trainingset_file);
	}
	
}

