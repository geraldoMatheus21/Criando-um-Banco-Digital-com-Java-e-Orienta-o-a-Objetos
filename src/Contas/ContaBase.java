package Contas;

public abstract class ContaBase {
package Contas;

	import UI.ContaBancaria;
	

	public abstract class ContaBase implements ContaBancaria {
	    protected String numeroConta;
	    protected String titular;
	    protected double saldo;
	    
	    public ContaBase(String numeroConta, String titular, double saldoInicial) {
	        this.numeroConta = numeroConta;
	        this.titular = titular;
	        this.saldo = saldoInicial;
	    }
	    
	    @Override
	    public void depositar(double valor) {
	        if (valor > 0) {
	            saldo += valor;
	            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
	        } else {
	            System.out.println("Valor de depósito inválido!");
	        }
	    }
	    
	    @Override
	    public void sacar(double valor) throws SaldoInsuficienteException {
	        if (valor <= 0) {
	            System.out.println("Valor de saque inválido!");
	            return;
	        }
	        
	        if (valor > saldo) {
	            throw new SaldoInsuficienteException(
	                "Saldo insuficiente! Saldo atual: R$ " + saldo + 
	                ", Valor do saque: R$ " + valor
	            );
	        }
	        
	        saldo -= valor;
	        System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
	    }
	    
	    @Override
	    public void transferir(double valor, ContaBancaria contaDestino) 
	            throws SaldoInsuficienteException {
	        this.sacar(valor); // Verifica se tem saldo suficiente
	        contaDestino.depositar(valor);
	        System.out.println("Transferência de R$ " + valor + 
	                          " para conta " + contaDestino.getNumeroConta() + 
	                          " realizada com sucesso!");
	    }
	    
	    @Override
	    public double consultarSaldo() {
	        return saldo;
	    }
	    
	    @Override
	    public String getNumeroConta() {
	        return numeroConta;
	    }
	    
	    @Override
	    public String getTitular() {
	        return titular;
	    }
	}
}
