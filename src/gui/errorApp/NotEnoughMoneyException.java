package gui.errorApp;

public class NotEnoughMoneyException extends TransactionException{
	private double money;
	public NotEnoughMoneyException(double money) {
		this.money=money;
		ErrorAplicacionException.getWarning().setContentText("No tienes suficiente dinero, necesitas al menos: --> "
				+ this.money + " <-- para realizar la transaccion.");
	}
	public double getMoney() {
		return this.money;
	}
}
