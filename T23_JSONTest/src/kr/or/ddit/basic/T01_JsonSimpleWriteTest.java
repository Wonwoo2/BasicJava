package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 *  JSON : JavaScript Object Notation
 *  
 *  - JSON에서 value값으로 가능한 데이터 타입
 *  	1. string
 *  	2. number
 *  	3. object(JSON object)
 *  	4. array
 *  	5. boolean
 *  	6. null
 */
public class T01_JsonSimpleWriteTest {
	public static void main(String[] args) {
		// JSON 데이터 생성
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "홍길동");
		jsonObj.put("job", "학생");
		jsonObj.put("age", 30);
		jsonObj.put("addr", "대전시 동구 대흥동");
		
		// JSONArray 데이터 생성
		JSONArray singerList = new JSONArray();
		JSONObject singer = new JSONObject();
		singer.put("name", "싸이");
		singer.put("gender", "남자");
		singer.put("age", 40);
		singerList.add(singer);
		
		singer = new JSONObject();
		singer.put("name", "비욘세");
		singer.put("gender", "여자");
		singer.put("age", 37);
		singerList.add(singer);
		
		singer = new JSONObject();
		singer.put("name", "본조비");
		singer.put("gender", "남자");
		singer.put("age", 44);
		singerList.add(singer);
		
		jsonObj.put("singerList", singerList);
		
		try {
			FileWriter fw = new FileWriter("e:/D_Other/myJsonFile.txt");
			
			fw.write(jsonObj.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("JSON객체 내용 출력 : " + jsonObj);
	}
}
