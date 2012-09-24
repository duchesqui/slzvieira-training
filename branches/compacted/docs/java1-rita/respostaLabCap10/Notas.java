class Notas{
	static public void main(String args[])	{
		double nota [][] = new double [5][3];
		int i, j;

		nota[0][0] = 7.5;
		nota[0][1] = 10;
		nota[0][2] = 8;

		nota[1][0] = 5;
		nota[1][1] = 7.8;
		nota[1][2] = 9;

		nota[2][0] = 10;
		nota[2][1] = 9.5;
		nota[2][2] = 8;

		nota[3][0] = 3;
		nota[3][1] = 4.5;
		nota[3][2] = 6;

		nota[4][0] = 10;
		nota[4][1] = 8.8;
		nota[4][2] = 6.6;

		for(i=0;i<5;i++)

			for(j=0;j<3;j++)

			System.out.println("aluno " + i + " nota " + j + " - " + nota[i][j]);
	}
}