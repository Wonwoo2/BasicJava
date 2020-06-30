package h_useful;

public class StringClassEx {

	public static void main(String[] args) {
		String s = new String("Hello");
		System.out.println(s);
		
		char[] c = { 'H', 'e', 'l', 'l', 'o' };
		s = new String(c);
		System.out.println(s);
		
		String n = "0123456";
		char d = s.charAt(1);
		char d1 = n.charAt(1);
		
		System.out.println(d);
		System.out.println(d1);
		
		int i = "aaa".compareTo("aaa");
		int i2 = "aaa".compareTo("bbb");
		int i3 = "bbb".compareTo("aaa");
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		
		String s2 = s.concat(" World");
		System.out.println(s2);
		
		s = "abcefg";
		boolean b = s.contains("bc");
		System.out.println(b);
		
		String file = "Hello.txt";
		b = file.endsWith("txt");
		System.out.println(b);
		
		s = "Hello";
		b = s.equals("Hello");
		boolean b2 = s.equals("hello");
		System.out.println(b);
		System.out.println(b2);
		
		s = "Hello";
		b = s.equalsIgnoreCase("HELLO");
		b2 = s.equalsIgnoreCase("heLLo");
		
		System.out.println(b);
		System.out.println(b2);
		
		int idx1 = s.indexOf('o');
		int idx2 = s.indexOf('k');
		
		System.out.println(idx1);
		System.out.println(idx2);
		
		idx1 = s.indexOf('e', 0);
		idx2 = s.indexOf('e', 2);
		
		System.out.println(idx1);
		System.out.println(idx2);
		
		s = "ABCDEFG";
		int idx = s.indexOf("CD");
		
		System.out.println(idx);
		
		s = new String("abc");
		s2 = new String("abc");
		b = (s == s2);
		b2 = s.equals(s2);
		boolean b3 = (s.intern() == s2.intern());
		
		System.out.println(b);
		System.out.println(b2);
		System.out.println(b3);
		
		s = "java.lang.Object";
		idx1 = s.lastIndexOf('.');
		idx2 = s.indexOf('.');
		
		System.out.println(idx1);
		System.out.println(idx2);
		
		s = "java.lang.java";
		idx1 = s.lastIndexOf("java");
		idx2 = s.indexOf("java");
		
		System.out.println(idx1);
		System.out.println(idx2);
		
		s = "Hello";
		int length = s.length();
		System.out.println(length);
		
		String s1 = s.replace('H', 'C');
		System.out.println(s1);
		
		s = "Hellollo";
		s1 = s.replace("ll", "LL");
		
		System.out.println(s1);
		
		String ab = "AABBAABB";
		String r = ab.replace("BB", "bb");
		
		System.out.println(r);
		
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		arr = animals.split(",", 2);
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		s = "java.lang.Object";
		b = s.startsWith("java");
		b2 = s.startsWith("lang");
		
		System.out.println(b);
		System.out.println(b2);
		
		String c1 = s.substring(10);
		String p = s.substring(5, 9);
		
		System.out.println(c1);
		System.out.println(p);
		
		s = "Hello";
		s1 = s.toLowerCase();
		
		System.out.println(s1);
		
		s1 = s.toString();
		
		System.out.println(s1);
		
		s1 = s.toUpperCase();
		
		System.out.println(s1);
		
		s = "    Hello World    ";
		s1 = s.trim();
		
		System.out.println(s1);
		
		String q = String.valueOf(true);
		String w = String.valueOf('a');
		String k = String.valueOf(100);
		String l = String.valueOf(100L);
		String f = String.valueOf(10f);
		String t = String.valueOf(10.0);
		
		java.util.Date dd = new java.util.Date();
		String date = String.valueOf(dd);
		
		System.out.println(q);
		System.out.println(w);
		System.out.println(k);
		System.out.println(l);
		System.out.println(l);
		System.out.println(f);
		System.out.println(t);
		System.out.println(date);
		
	}

}
