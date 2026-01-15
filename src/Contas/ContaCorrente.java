package Contas;

import UI.Conta;

public class ContaCorrente extends ContaBase{

	public ContaCorrente(String agencia, String nConta, String nomeTitular, Double saldo) {
		super(agencia, nConta, nomeTitular, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositar(double valor) {
		if(saldo<0) {
			saldo = valor-saldo;
		}
		else {
			saldo = valor;
		}
		
	}

	@Override
	public boolean sacar(double valor) {
		if(saldo>=valor) {
			return true;
		}
		return false;
	}

	@Override
	public void transferirPara(Conta destino, double valor) {
		// TODO Auto-generated method stub
		
	}
}
