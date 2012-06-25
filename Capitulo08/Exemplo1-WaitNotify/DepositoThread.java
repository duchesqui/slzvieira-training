package waitnotify;

import javax.swing.JOptionPane;

public class DepositoThread extends Thread {

	private Conta conta;

	public DepositoThread(Conta conta) {
		this.conta = conta;
	}

	public void run() {

		String stringValor = null;
		double valor = 0;

		for (;;) {
			try {
				stringValor = JOptionPane.showInputDialog(null, "Digite o valor para depósito:");
				if (stringValor == null) {
					break;
				}
				valor = Double.parseDouble(stringValor);
				conta.depositar(valor);
			} catch (RuntimeException re) {
				System.out.println("Valor invalido para deposito: " + stringValor);
			}
		}
		
		System.out.println("Operacoes de deposito concluidas.");
	}
}
