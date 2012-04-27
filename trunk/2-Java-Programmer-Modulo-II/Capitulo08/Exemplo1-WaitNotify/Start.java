package waitnotify;

public class Start {

	public static void main(String[] args) {

		Conta conta = new Conta();
		Thread thread1 = new RetiradaThread(conta, 500);
		Thread thread2 = new DepositoThread(conta);

		thread1.start();
		thread2.start();
	}
}
