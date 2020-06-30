package i_collection;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 *  put()		: 지정된 키와 값을 저장
		 *  get()		: 지정된 키의 값을 반환(없으면 null)
		 *  remove()	: 지정된 키로 저장된 값을 제거
		 *  keySet()	: 저장된 모든 키를 Set으로 반환
		 */
		
		HashMap<String, String> map = new HashMap<>();
		map.put("title", "제목입니다.");
		map.put("content", "내용입니다.");
		map.put("user", "이원우");
		map.put("date", "2020-05-18 10:38");
		
		System.out.println(map.get("title"));
		System.out.println(map.get("content"));
		System.out.println(map.get("user"));
		System.out.println(map.get("date"));
		
		map.put("user", "홍길동");
		System.out.println(map.get("user"));
		
		map.remove("user");
		System.out.println(map.get("user"));
		
		for(String key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		
		HashMap<String, String> dept1 = new HashMap<>();
		dept1.put("DEPTNO", "10");
		dept1.put("DNAME", "ACCOUNTING");
		dept1.put("LOC", "NEW YORK");
		
		HashMap<String, String> dept2 = new HashMap<>();
		dept2.put("DEPTNO", "20");
		dept2.put("DNAME", "RESEARCH");
		dept2.put("LOC", "DALLAS");
		
		HashMap<String, String> dept3 = new HashMap<>();
		dept3.put("DEPTNO", "30");
		dept3.put("DNAME", "SALES");
		dept3.put("LOC", "CHICAGO");
		
		HashMap<String, String> dept4 = new HashMap<>();
		dept4.put("DEPTNO", "40");
		dept4.put("DNAME", "OPERATIONS");
		dept4.put("LOC", "BOSTON");
		
		list.add(dept1);
		list.add(dept2);
		list.add(dept3);
		list.add(dept4);
		
		for (HashMap<String, String> i : list) {
			System.out.println(i);
		}
		
		System.out.println();
		for (int i = 0; i < list.size(); i ++) {
			HashMap<String, String> hm = list.get(i);
			for (String key : hm.keySet()) {
				String value = hm.get(key);
				System.out.println(key + "  " + value);
			}
			System.out.println();
		}
		


	}
}