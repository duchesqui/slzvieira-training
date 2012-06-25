package waitnotify;

public class Conta {

	private int numero;
	private String nome;
	private double saldo;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public synchronized void retirar(double valor) {
		try {
			System.out.println("Realizando a retirada de " + valor);
			while (valor > saldo) {
				System.out.println("Saldo insuficiente. Aguardando o deposito por outro thread...");
				wait();
			}
			saldo -= valor;
			System.out.println("Retirada realizada com sucesso. Saldo atual: " + getSaldo());
		} catch (InterruptedException e) {
			System.out.println("Processo de retirada interrompido.");
			e.printStackTrace();
		}
	}

	public synchronized void depositar(double valor) {
		if (valor < 0) {
			throw new RuntimeException("Valor inválido para depósito.");
		}
		saldo += valor;
		System.out.println("Depósito realizado. Saldo atual: " + getSaldo());
		notify();
	}
}
