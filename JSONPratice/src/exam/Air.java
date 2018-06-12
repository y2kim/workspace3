package exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Air {
	public static void main(String[] args) {
		String clientId = "75554649426b6368343372654c6c73";
		try {
			String apiURL = "http://openAPI.seoul.go.kr:8088/"+clientId+"/json/DailyAverageCityAir/1/5/20171006";
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
	            
//	            for(int i=0;i<arr.size();i++) {
//		            System.out.println(arr.get(i).getAsJsonObject().get("MSRDT_DE"));
//		            System.out.println(arr.get(i).getAsJsonObject().get("MSRSTE_NM"));
//		            System.out.println(arr.get(i).getAsJsonObject().get("PM10"));
//		            System.out.println(arr.get(i).getAsJsonObject().get("PM25"));
//		            System.out.println();
//		            }
	            System.out.println(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
