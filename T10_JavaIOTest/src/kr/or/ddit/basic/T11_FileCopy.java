package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11_FileCopy {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("e:/D_Other/Tulips.jpg");
			fos = new FileOutputStream("e:/D_Other/CopyTulips.jpg");

			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			
			System.out.println("파일 복사 완료");
			fis.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
