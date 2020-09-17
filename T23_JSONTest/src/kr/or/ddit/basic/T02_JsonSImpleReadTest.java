package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class T02_JsonSImpleReadTest {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("e:/D_Other/myJsonFile.txt");
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(fr);
			JSONObject jsonFile = (JSONObject) obj;
			
			String name = (String)jsonFile.get("name");
			String job = (String)jsonFile.get("job");
			long age = (long)jsonFile.get("age");
			String addr = (String)jsonFile.get("addr");
			
			System.out.println("name : " + name);
			System.out.println("job : " + job);
			System.out.println("age : " + age);
			System.out.println("addr : " + addr);
			
			JSONArray singerList = (JSONArray)jsonFile.get("singerList");
			Iterator<JSONObject> it = singerList.iterator();

			JSONObject singer = null;
			while(it.hasNext()) {
				singer = it.next();
				System.out.printf("이름 : %s \t성별 : %s \t나이: %d\n",
									singer.get("name"), singer.get("gender"), singer.get("age"));
			}
			
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}