package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class T01_MemberIBatisTest {

	public static void main(String[] args) {
		// IBatis를 이용하여 DB자료를 처리하는 작업 순서
		// 1. IBatis의 환경설정파일을 읽어와 실행시킨다.
		
		try {
			// 1-1. xml문서 읽어오기
			Charset charset = Charset.forName("UTF-8");		// 실행파일의 인코딩 설정
			Resources.setCharset(charset);
			
			// xml 파일 읽어오는 Reader 객체 생성
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-2. 위에서 읽어온 Reader 객체를 이용하여 실제 작업을 진행할 객체 생성
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			// 모두 읽어온 후 자원 반납
			rd.close();
			
			// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			// 2-1. insert 작업 연습
			System.out.println("insert작업");
			
			// 1) 저장할 데이터를 VO에 담는다.
			MemberVO mv = new MemberVO();
			mv.setMem_id("b001");
			mv.setMem_name("성춘향");
			mv.setMem_tel("01033334444");
			mv.setMem_addr("대전시 중구");
			
			// 2) SqlMapClient 객체 변수를 이용하여 해당 쿼리문을 실행한다.
			// 형식) smc.insert("namespace값.id값", 파라미터클래스);
			//		반환값 : 성공하면 null이 반환된다.
			Object obj = smc.insert("memberTest.insertMember", mv);
			
			if(obj == null) {
				System.out.println("insert 작업 성공");
			} else {
				System.out.println("insert 작업 실패");
			}
			
			// 2-2. update 작업 연습
			MemberVO mv2 = new MemberVO();
			mv2.setMem_id("b001");
			mv2.setMem_name("이원우");
			mv2.setMem_tel("01011112222");
			mv2.setMem_addr("대전시 대흥동");
			
			// update() 메서드의 반환값은 성공한 레코드 수 이다. 구글링 했을때는 
			int cnt = smc.update("memberTest.updateMember", mv2);
			
			if(cnt > 0) {
				System.out.println("update 작업 성공");
			} else {
				System.out.println("update 작업 실패");
			}
			
			// 2-3. delete 작업 연습
			
			// delete 메서드의 반환값 : 성공한 레코드수
			int cnt2 = smc.delete("memberTest.deleteMember", "b001");
			
			if(cnt2 > 0) {
				System.out.println("delete 작업 성공");
			} else {
				System.out.println("delete 작업 실패");
			}
			
			// 2-4. select 작업 연습
			// 1) 응답의 결과가 여러 개일 경우
			/*System.out.println("SELEC 결과가 여러개 인경우");
			
			// 응답 결과가 여러개 일 경우에는 queryForList() 메서드를 사용한다.
			// 이 메서드는 여러 개의 레코드를 VO에 담은 후 VO 데이터를 
			// List에 추가해 주는 작업을 자동으로 수행한다.
			
			List<MemberVO> memList = smc.queryForList("memberTest.getMemberAll");
			System.out.println("==========================");
			for (MemberVO memberVo : memList) {
				System.out.println("ID : " + memberVo.getMem_id());
				System.out.println("이름 : " + memberVo.getMem_name());
				System.out.println("전화 : " + memberVo.getMem_tel());
				System.out.println("주소 : " + memberVo.getMem_addr());
				System.out.println("==========================");
			}*/
			
			System.out.println();
			// 2) 응답 결과가 1개인 경우
			System.out.println("결과가 한개일 경우");
			
			// 응답 결과가 1개가 확실할 경우에는 queryForObject() 메서드를 사용한다.
			MemberVO mv3 = (MemberVO)smc.queryForObject("memberTest.getMember", "b002");
			System.out.println("==========================");
			System.out.println("ID : " + mv3.getMem_id());
			System.out.println("이름 : " + mv3.getMem_name());
			System.out.println("전화 : " + mv3.getMem_tel());
			System.out.println("주소 : " + mv3.getMem_addr());
			System.out.println("==========================");
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
