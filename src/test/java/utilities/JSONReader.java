package utilities;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import models.PageAddress;
import models.UserModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class JSONReader {

    JsonParser parser = new JsonParser();
    HashMap<?,?> mappedData;



    public HashMap<?,?> reader (String FilePath){
        Gson gson = new Gson();

        try {
        JsonElement JSONData = parser.parse(new FileReader(System.getProperty("user.dir")+ FilePath));
        mappedData = gson.fromJson(JSONData,HashMap.class);


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return mappedData;
    }

    public UserModel getUser(String role) {
        String path = "//Properties//users.json";
        String username = ((LinkedTreeMap<?, ?>) reader(path).get(role)).get("email").toString();
        String password = ((LinkedTreeMap<?, ?>) reader(path).get(role)).get("password").toString();
        UserModel model = new UserModel(username,password);


        return model;
    }

    public PageAddress getAddress(String url) {
        String path = "//Properties//environments.json";
        String address = ((LinkedTreeMap<?, ?>) reader(path).get(url)).get("address").toString();
        PageAddress pageAddress = new PageAddress(address);


        return pageAddress;
    }



}
