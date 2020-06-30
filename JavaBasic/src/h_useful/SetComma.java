package h_useful;

public class SetComma {

	public static void main(String[] args) {
		// 숫자를 입력 받아 입력 받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		
		String number = useful.ScanUtil.nextLine();
		int count = 0;
		String setComma = " ";
		
		System.out.println(number);
		
		for(int i = number.length() - 1; i >= 0; i --) {
			setComma = number.charAt(i) + setComma;
			count++;
			if(count % 3 == 0 && count != number.length()) {
				setComma = "," + setComma;
			}
			
		}
		System.out.println(setComma);
		

	}

}
