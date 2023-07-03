package desafioFinal.conta.movimentacoes;

import desafioFinal.conta.Conta;
import desafioFinal.conta.Exceptions.TransacoesException;

public class Transacoes {
    Conta conta;
    public Transacoes(Conta conta) {
        this.conta = conta;
    }

    public void depositar (double valor) {
        Extrato extrato = new Extrato(this.conta);
        double saldo = extrato.getSaldo();
        double newSaldo = valor + saldo;
        this.conta.setSaldo(newSaldo);
    }

    public void sacar(double valor) throws TransacoesException {
        Extrato extrato = new Extrato(this.conta);
        double saldoAtual = extrato.getSaldo();
        if (valor > saldoAtual) {
            throw new TransacoesException("Saldo insuficiente");
        }
        saldoAtual = saldoAtual - valor;
        this.conta.setSaldo(saldoAtual);
    }
}
