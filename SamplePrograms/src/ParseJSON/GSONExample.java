package ParseJSON;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class GSONExample {
	public static void main(String[] args) {
		Gson gson=new Gson();
			try {
				JsonReader reader=new JsonReader(new FileReader("covid.json"));
			CovidData data=gson.fromJson(reader, CovidData.class);
			System.out.println(data.getDailyConfirmed());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
