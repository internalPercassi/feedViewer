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

@Service("AmazonParser")
public class AmazonParser extends BaseParser{

	private static final List<String> COLUMN_LIST = Arrays.asList();
	static final String TYPE = "Amazon";
	private static final String TITLE = "Amazon File View";
	
	@Override
	public JSONObject parseToJson(InputStream stream, String countryCode) throws IOException{
		JSONArray tmplist = null;
		JSONArray list = new JSONArray();
		JSONArray headersList = new JSONArray();
		JSONObject ret = null;

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			tmplist = new JSONArray();
			tmplist.add(line.substring(0, 2));
			tmplist.add(line.substring(2, 5));
			tmplist.add(line.substring(5, 15));
			tmplist.add(line.substring(15, 18));
			tmplist.add(line.substring(28, 64));
			tmplist.add(line.substring(64, 67));
			tmplist.add(line.substring(150, 160).replaceFirst("^0+(?!$)", ""));
			tmplist.add(line.substring(163, 173).replaceFirst("^0+(?!$)", ""));
			tmplist.add(line.substring(176, 191));
			list.add(tmplist);
		}
		headersList = createHeaderList(COLUMN_LIST);
		ret= createJSON(list, headersList, TYPE, TITLE);
		return ret;
	}
}
