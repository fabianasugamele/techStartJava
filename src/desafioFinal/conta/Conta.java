package desafioFinal.conta;

import desafioFinal.usuario.Pessoa;

import java.util.ArrayList;

public abstract class Conta {

    int senha = 0;
    double saldo = 0;

    int agencia;

    int numeroConta;

    Pessoa pessoa;

    Login login;

    String tipo;

    public static ArrayList<Conta> contas = new ArrayList<>();

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Login logar() {
        return this.login.logar(this.getAgencia(), this.getNumeroConta(), this.getSenha());
    }

    public void removerConta() { Conta.contas.remove(this);}
}
