package github;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class api {
    public static void main(String[] args) {
        try {
            URL url=new URL("https://api.thingspeak.com/channels/875453/feeds.json?api_key=1DSQ7R1XTT1OK0Z1&results=20");
            HttpURLConnection u1=(HttpURLConnection)url.openConnection();
            u1.setRequestMethod("GET");
            InputStreamReader is=new InputStreamReader(u1.getInputStream());
            BufferedReader br=new BufferedReader(is);
             String NM="";
             while(NM!=null){
                NM=br.readLine();
           // System.out.println(st);
                 
                br.close();
         JSONParser par=new JSONParser();
         JSONObject ob=(JSONObject)par.parse(NM);
         JSONObject obj=(JSONObject)ob.get("channel");
          System.out.println(obj.get("name"));
          System.out.println(obj.get("id"));
         

         JSONArray arr=(JSONArray)ob.get("feeds");
         for(int i=0;i<arr.size();i++){
           JSONObject obj1=(JSONObject)arr.get(0);
          System.out.println(obj1.get("field1"));
            
        }
            
    
        }
            

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}