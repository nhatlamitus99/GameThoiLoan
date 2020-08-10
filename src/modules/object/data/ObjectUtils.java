package modules.object.data;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by CPU12750-local on 8/6/2020.
 */
public class ObjectUtils {

    public JSONObject loadBaseConfig(String typeCategory, String typeObject) {
        String filename = "res/content/Documents/ConfigJSON/" + typeCategory + ".json";
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            String data = gson.fromJson(reader, Object.class).toString();
            JSONObject jsonObject = new JSONObject(data);
            JSONObject listStorage = jsonObject.getJSONObject(typeObject);
            return listStorage;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public JSONObject loadConfig(String typeCategory, String typeObject, int level) {
        String filename = "res/content/Documents/ConfigJSON/" + typeCategory + ".json";
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            String data = gson.fromJson(reader, Object.class).toString();
            JSONObject jsonObject = new JSONObject(data);
            JSONObject listStorage = jsonObject.getJSONObject(typeObject);
            JSONObject dataStorage = listStorage.getJSONObject(level + "");
            return dataStorage;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


}
