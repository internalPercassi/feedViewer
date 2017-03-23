package com.perparser.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

@Service("AmazonParser")
public class AmazonParser extends BaseParser {

	private static final List<String> COLUMN_LIST = Arrays.asList("sku", "upc", "title", "brand", "manufacturer", "product_type", "item_type", "description", "part_number", "catalog_number");
	static final String TYPE = "Amazon";
	private static final String TITLE = "Amazon File View";
	
	@Override
	public JSONObject parseToJson(InputStream stream, String countryCode) throws IOException{
		JSONArray tmplist = null;
		JSONArray list = new JSONArray();
		JSONArray headersList = new JSONArray();
		JSONObject ret = null;
		InputStreamReader exp = new InputStreamReader(stream);
		
		CSVReader csvReader = new CSVReader(exp, '|');

	     String [] nextLine;
	     while ((nextLine = csvReader.readNext()) != null) {
	        // nextLine[] is an array of values from the line
	        System.out.println(nextLine[0] + nextLine[1] + "etc...");
			tmplist = new JSONArray();
			tmplist.add(nextLine[0]);
			tmplist.add(nextLine[1]);
			tmplist.add(nextLine[2]);
			list.add(tmplist);
	     }
		headersList = createHeaderList(COLUMN_LIST);
		ret= createJSON(list, headersList, TYPE, TITLE);
		return ret;
	}
}
