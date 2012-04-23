class TestaToString{
	
	public static void main(String args[]){
		Pessoa j = new Pessoa();
		Pessoa m = new Pessoa();

		j.sexo = 'm';
		j.idade = 45;
		j.nome = "João";

		System.out.println("Objeto j: " + j);
		System.out.println("Nome de j: " + j.nome);
		System.out.println("Sexo de j= "+ j.sexo);
		System.out.println("Idade de j= "+ j.idade);
		System.out.println();

		
		m.sexo = 'f';
		m.idade = 25;
		m.nome = "Maria";

		System.out.println("Objeto m: " + m);
		System.out.println("Nome de m: " + m.nome);
		System.out.println("Sexo de m= "+ m.sexo);
		System.out.println("Idade de m= "+ m.idade);
		System.out.println();
		
	}
}