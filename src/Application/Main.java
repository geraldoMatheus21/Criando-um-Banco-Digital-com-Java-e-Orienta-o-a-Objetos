import ContaCorrente;
import ContaPoupanca;
import UI.ContaBancaria;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCÁRIO SIMPLES ===\n");
        
        try {
            // Criando contas
            ContaCorrente contaCorrente = new ContaCorrente(
                "001", "João Silva", 1000.00, 500.00
            );
            
            ContaPoupanca contaPoupanca = new ContaPoupanca(
                "002", "João Silva", 500.00
            );
            
            ContaSalario contaSalario = new ContaSalario(
                "003", "Maria Souza", "12.345.678/0001-90"
            );
            
            // Testando operações
            System.out.println("=== TESTANDO CONTA CORRENTE ===");
            contaCorrente.depositar(200.00);
            System.out.println("Saldo CC: R$ " + contaCorrente.consultarSaldo());
            
            contaCorrente.sacar(1500.00); // Usa cheque especial
            System.out.println("Saldo CC após saque: R$ " + contaCorrente.consultarSaldo());
            
            System.out.println("\n=== TESTANDO CONTA POUPANÇA ===");
            contaPoupanca.depositar(300.00);
            contaPoupanca.aplicarRendimento();
            System.out.println("Saldo CP: R$ " + contaPoupanca.consultarSaldo());
            
            System.out.println("\n=== TESTANDO CONTA SALÁRIO ===");
            contaSalario.receberSalario(3000.00);
            contaSalario.sacar(500.00); // Saque gratuito
            contaSalario.sacar(500.00); // Saque gratuito
            contaSalario.sacar(500.00); // Saque com taxa
            
            System.out.println("\n=== TESTANDO TRANSFERÊNCIA ===");
            contaSalario.transferir(1000.00, contaPoupanca);
            System.out.println("Saldo Conta Salário: R$ " + contaSalario.consultarSaldo());
            System.out.println("Saldo Poupança: R$ " + contaPoupanca.consultarSaldo());
            
            System.out.println("\n=== RESUMO DAS CONTAS ===");
            exibirInformacoesConta(contaCorrente);
            exibirInformacoesConta(contaPoupanca);
            exibirInformacoesConta(contaSalario);
            
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
    
    private static void exibirInformacoesConta(ContaBancaria conta) {
        System.out.println("\nConta: " + conta.getNumeroConta());
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo: R$ " + conta.consultarSaldo());
        
        if (conta instanceof ContaCorrente cc) {
            System.out.println("Tipo: Conta Corrente");
            System.out.println("Limite Cheque Especial: R$ " + cc.getLimiteChequeEspecial());
        } else if (conta instanceof ContaPoupanca cp) {
            System.out.println("Tipo: Conta Poupança");
            System.out.println("Taxa Rendimento: " + cp.getTaxaRendimentoMensal() + "%");
        } else if (conta instanceof ContaSalario cs) {
            System.out.println("Tipo: Conta Salário");
            System.out.println("Empresa: " + cs.getCnpjEmpresa());
            System.out.println("Saques gratuitos restantes: " + cs.getSaquesGratuitos());
        }
    }
}