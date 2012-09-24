class TestaInstanceOf{
	static public void main(String args[]){

		Desenho AR[] = new Desenho[6];

		AR[0] = new Desenho();
		AR[1] = new Triangulo();
		AR[2] = new Quadrado();
		AR[3] = new Quadrado();
		AR[4] = new Triangulo();
		AR[5] = new Triangulo();

		int i;

		for( i=0;i<6;i++)

		if  (AR[i] instanceof Triangulo){
			System.out.println("Este objeto é um triângulo - " + AR[i].getClass());
	}
		else
		System.out.println("Este objeto não é um triângulo - " + AR[i].getClass());

	}


}
