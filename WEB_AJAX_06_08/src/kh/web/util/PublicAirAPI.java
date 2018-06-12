package kh.web.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PublicAirAPI {
	public JsonArray getNews(String day) throws Exception {
		String clientId = "75554649426b6368343372654c6c73";
			String apiURL = "http://openAPI.seoul.go.kr:8088/"+clientId+"/json/DailyAverageCityAir/1/5/"+day+"";
			 URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("GET");
	         int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            JsonParser parser = new JsonParser();
	            JsonObject json = parser.parse(response.toString()).getAsJsonObject();
	            json = json.getAsJsonObject("DailyAverageCityAir");
	            JsonArray arr = json.get("row").getAsJsonArray();
	            return arr;
	}
}
