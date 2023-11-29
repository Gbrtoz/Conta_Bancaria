import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Scanner;

public class Conta {
	
    private int saldo; // Armazenar o saldo da conta

    private Scanner scanner = new Scanner(System.in);

    @Given("^Um cliente com saldo atual de -(\\d+) reais$")
    public void um_cliente_com_saldo_atual_de_reais(int saldoInicial) throws Throwable {
        this.saldo = -saldoInicial; // Configura o saldo inicial da conta
    }

    @Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
    public void um_cliente_especial_com_saldo_atual_de_reais(int saldoInicial) throws Throwable {
        this.saldo = -saldoInicial; // Configura o saldo inicial da conta para cliente especial
    }

    @When("^for solicitado um saque no valor de (\\d+) reais$")
    public void for_solicitado_um_saque_no_valor_de_reais(int valorSaque) throws Throwable {
        if (valorSaque > this.saldo) {
            throw new RuntimeException("Saldo indisponível"); // Lança exceção se o saldo for insuficiente
        }
        this.saldo -= valorSaque; // Realiza o saque
    }

    @Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int novoSaldo) throws Throwable {
        if (this.saldo != novoSaldo) {
            throw new RuntimeException("Erro na atualização do saldo"); // Lança exceção se houver erro na atualização do saldo
        }
    }
    
    @Given("^Um cliente especial com saldo atual de (\\d+) reais$")
    public void um_cliente_especial_com_saldo_atual_de_reais(int saldoInicial) throws Throwable {
        this.saldo = saldoInicial; // Configura o saldo inicial da conta para cliente especial
    }

    @Then("^deve efetuar o saque e atualizar o saldo da conta para (\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int novoSaldo) throws Throwable {
        if (this.saldo != novoSaldo) {
            throw new RuntimeException("Erro na atualização do saldo"); // Lança exceção se houver erro na atualização do saldo
        }
    }
    
    @Then("^check more outcomes$")
    public void check_more_outcomes() throws Throwable {
    }

    @Then("^check more outs$")
    public void check_more_outs() throws Throwable {
    }

    // Entrada do usuário
    public int solicitarEntradaUsuario() {
        System.out.print("Digite um valor: ");
        return scanner.nextInt();
    }
}
