package kr.or.ddit.basic;

public class T06_EnumPlanet {
	public enum Planet {
		수성(2439), 금성(6052), 지구(6371), 화성(3390),
		목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
		
		private int r;

		Planet(int r) {
			this.r = r;
		}

		public int getR() {
			return r;
		}
		
		public double planetArea(int r) {
			return 4 * Math.PI * Math.pow(r, 2);
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("행성의 반지름(KM)");
		System.out.println("===========================");
		for (Planet planet : Planet.values()) {
			System.out.println(planet.name() + " : " + planet.planetArea(planet.getR()));
		}
	}
}