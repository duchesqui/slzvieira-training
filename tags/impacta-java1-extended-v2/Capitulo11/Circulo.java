public class Circulo extends FiguraGeometrica {
	
	private double raio;
	
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double getRaio() {
		return raio;
	}
	
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public double getArea() {
		return raio * raio * Math.PI;
	}
}
