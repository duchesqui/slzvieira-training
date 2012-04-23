class Office implements Treinamento{
	String nome;

	public String toString(){
		return( " - Treinamento:  " + nome );
	}

	 public double getPreco(int modulo) {
		 if(modulo == 1)
		 	return(300);
		 else
		 	return(500);
	}

}
