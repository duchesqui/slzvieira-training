public class Operadores {
	
	public static void main(String[] args) {
		
	}
	
	public static String convertToBinary(int value) {
		String result = "00000000000000000000000000000000" + Integer.toBinaryString(value);
		return result.substring(result.length() - 32);
	}
}
