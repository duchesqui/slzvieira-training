public class ExibeDados {

	public static void main(String[] args) {
		
		Motorista m1 = new Motorista();

		m1.setMatricula(123);
		m1.setNome("Manuel da silva");
		m1.setSalario(2000);
		m1.setCnh("6578985");

		System.out.println("Matricula: " + m1.getMatricula());
		System.out.println("Nome     : " + m1.getNome());
		System.out.println("Salario  : " + m1.getSalario());
		System.out.println("CNH      : " + m1.getCnh());
	}
}
