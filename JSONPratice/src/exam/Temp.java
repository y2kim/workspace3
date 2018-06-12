package exam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Temp {
	public static void main(String[] args) {
		 String clientId = "VXVimDdDPZeLRSwugDCH";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "XIv6rdisT9";//애플리케이션 클라이언트 시크릿값";
	        try {
	            String text = URLEncoder.encode("JAVA", "UTF-8");
	            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
	            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
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
	            JsonArray arr = json.get("item").getAsJsonArray();
	            for(int i=0;i<arr.size();i++) {
	            System.out.println(arr.get(i).getAsJsonObject().get("title"));
	            System.out.println(arr.get(i).getAsJsonObject().get("description"));
	            System.out.println(arr.get(i).getAsJsonObject().get("bloggername"));
	            System.out.println(arr.get(i).getAsJsonObject().get("postdate"));
	            System.out.println();
	            }
	          // System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	}
}
