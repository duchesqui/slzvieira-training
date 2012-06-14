package br.com.impacta.jdbc.persistence;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}

	public DAOException(String msg, Throwable exception) {
		super(msg, exception);
	}

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable exception) {
		super(exception);
	}
}
