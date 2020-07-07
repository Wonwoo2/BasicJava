package kr.or.ddit.exam3.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/*
 *  db.properties 파일의 내용으로 DB정보를 설정하는 방법
 *  방법1) Properties 객체 이용하기
 */
public class DBUtil {
	static Properties prop;		// Properties 객체 변수 선언
	
	static{
		prop = new Properties();	// 객체 생성
		
		File f = new File("res/SqlMapConfig.properties");
		
		try {
			FileInputStream fin = new FileInputStream(f);
			
			prop.load(fin);
			
			Class.forName(prop.getProperty("driver"));
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pw"));
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 *  xml 문서를 읽어와 실제 작업을 진행을 위한 객체를 반환하는 메서드
	 */
	public static SqlMapClient readXML(String xml) {
		SqlMapClient smc = null;
		try {
			// xml문서 읽어오기
			Charset charset = Charset.forName("UTF-8");		// 실행파일의 인코딩 설정
			Resources.setCharset(charset);
			
			// xml 파일 읽어오는 Reader 객체 생성
			Reader rd = Resources.getResourceAsReader(xml);
			
			// 위에서 읽어온 Reader 객체를 이용하여 실제 작업을 진행할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			// 모두 읽어온 후 자원 반납
			rd.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return smc;
	}
}
