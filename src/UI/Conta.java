package UI;

public interface Conta {
	 void depositar(double valor);
	 boolean sacar(double valor);
	 double consultarSaldo();
	 void transferirPara(Conta destino, double valor);
}
