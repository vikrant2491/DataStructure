package com.vikrant.test.testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;

public class ErrorLogs {

	public static void main(String[] args) throws Exception{
		int count =0;
		FileReader reader = new FileReader(new File("task1.txt"));
		BufferedReader fileReader = new BufferedReader(reader);
		
		FileWriter writer = new FileWriter(new File("output.txt"));
		String line="";
		while((line = fileReader.readLine())!=null){
			if(line.matches("^[\\d]{2}:[\\d]{2}:[\\d]{2}.[\\d]{3}\\s\\[[^\\]]*\\]\\sERROR.*")){
				System.out.println(line);
				System.out.println(line.replaceFirst("^[\\d]{2}:[\\d]{2}:[\\d]{2}.[\\d]{3}\\s\\[[^\\]]*\\]\\sERROR", ""));
				writer.write(line);
				writer.write("\r\n");
				count++;
			}			
		}
		writer.flush();
		writer.close();
		fileReader.close();
		reader.close();
		
		System.out.println(count);

	}

}
