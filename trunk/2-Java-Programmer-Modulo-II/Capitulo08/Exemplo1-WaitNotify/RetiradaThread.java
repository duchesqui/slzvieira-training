package waitnotify;

public class RetiradaThread extends Thread {

	private Conta conta;
	private double valor;

	public RetiradaThread(Conta conta, double valor) {
		this.conta = conta;
		this.valor = valor;
	}

	public void run() {
		conta.retirar(valor);
	}
}
