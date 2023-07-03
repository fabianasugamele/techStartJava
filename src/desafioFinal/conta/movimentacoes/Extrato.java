package desafioFinal.conta.movimentacoes;

import desafioFinal.conta.Conta;

public class Extrato {
    Conta conta;
    public Extrato(Conta conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return this.conta.getSaldo();
    }
}
