class Cap12Lab1{


	public static void main(String arg[])
	{
		Office excel = new Office();
 		DesenvolvimentoWeb flash = new DesenvolvimentoWeb();

 		excel.nome = "Excel ";
 		flash.nome = "Flash ";

		treinaInfo(excel,1);
		treinaInfo(flash,1);
	}



	public static void treinaInfo(Treinamento item, int tipo)
	{
		System.out.println();
		System.out.println("Escola: "  + item.ESCOLA + item + "\nFone: " + item.FONE);
		System.out.println("Este Treinamento custa: " + item.getPreco(tipo));
	}
}
