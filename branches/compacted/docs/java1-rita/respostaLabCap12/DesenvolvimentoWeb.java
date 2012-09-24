class DesenvolvimentoWeb implements Treinamento{
	
	String nome;

	public String toString(){
		return( " - Treinamento:  " + nome );
	}
	
	 public double getPreco(int modulo) {
		 if(modulo == 1)
		 	return(400);
		 else
		 	return(700);
	}

}
