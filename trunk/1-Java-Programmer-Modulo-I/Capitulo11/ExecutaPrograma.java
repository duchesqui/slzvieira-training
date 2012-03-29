public class ExecutaPrograma {

	public static void main(String[] args) {
		
		FiguraGeometrica[] listaFiguras = {
			new Quadrado(4),
			new Triangulo(3, 4),
			new Quadrado(6.5),
			new Circulo(2),
			new Triangulo(6.5, 10)
		};
		
		int totalQuadrados = 0;
		
		for (FiguraGeometrica figura : listaFiguras) {
			System.out.println("Area da figura: " + figura.getArea());
			
			if (figura instanceof Quadrado) {
				totalQuadrados++;
			}
		}
		
		System.out.println();
		System.out.println("Total de quadrados: " + totalQuadrados);
	}
}
