public class UsaCalculadora {

	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		
		System.out.println("Soma:          " + calc.soma(35, 7));
		System.out.println("Subtracao:     " + calc.subtrai(35, 7));
		System.out.println("Multiplicacao: " + calc.multiplica(35, 7));
		System.out.println("Divisao:       " + calc.divide(35, 7));
	}
}
