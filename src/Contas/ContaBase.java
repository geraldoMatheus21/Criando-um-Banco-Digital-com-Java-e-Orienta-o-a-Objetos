package Contas;

import UI.Conta;

public abstract class ContaBase implements Conta {
	protected String agencia;
	protected String nConta;
	protected String nomeTitular;
	protected Double saldo;
	
	public ContaBase(String agencia, String nConta, String nomeTitular, Double saldo) {
		this.agencia = agencia;
		this.nConta = nConta;
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
	}
	
	public String getAgencia() {
		return agencia;
	}

	public String getnConta() {
		return nConta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	@Override
	public double consultarSaldo() {
		return saldo;
	}
	
}
