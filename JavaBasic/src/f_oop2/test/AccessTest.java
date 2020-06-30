package f_oop2.test;

import f_oop2.AccessModifier;

public class AccessTest extends AccessModifier {
	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
		AccessTest at = new AccessTest();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		System.out.println(at.protectedVar);
		at.protectedMethod();
	}
}
