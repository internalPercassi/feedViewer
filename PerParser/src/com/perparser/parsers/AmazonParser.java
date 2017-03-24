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

	private static final List<String> COLUMN_LIST = Arrays.asList("sku", "upc", "title", "brand", "manufacturer",
			"product_type", "item_type", "description", "part_number", "catalog_number");
	static final String TYPE = "Amazon";
	private static final String TITLE = "Amazon File View";

	@Override
	public JSONObject parseToJson(InputStream stream, String countryCode) throws IOException {
		JSONArray list = new JSONArray();
		JSONArray tmplist = new JSONArray();
		JSONArray headersList = new JSONArray();
		JSONObject ret = null;
		InputStreamReader exp = new InputStreamReader(stream);
		int i = 0;
		String thisLine;
		BufferedReader myInput = new BufferedReader(exp);
		while ((thisLine = myInput.readLine()) != null) {
			String[] line = thisLine.split("\\|");
			for (String item : line)
				tmplist.add(item);

			list.add(tmplist);
			i++;
			if(i==2)
				break;
		}

		headersList = createHeaderList(COLUMN_LIST);
		ret = createJSON(list, headersList, TYPE, TITLE);
		return ret;
	}
}
