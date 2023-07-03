package desafioFinal.conta.movimentacoes;

import desafioFinal.conta.Conta;
import desafioFinal.conta.Exceptions.TransacoesException;

public class Investimento {

    Transacoes transacoes;

    Extrato extrato;
    public Investimento(Conta conta) {
        this.transacoes = new Transacoes(conta);
        this.extrato = new Extrato(conta);
    }

    public void aplicacao(double valorAplicado) {

        double novoSaldo = this.extrato.getSaldo() + valorAplicado;
        double rendimento = novoSaldo * 0.01;
        double valorAtualizado = novoSaldo + rendimento;

        transacoes.depositar(valorAtualizado);
    }

    public void regastar(double valorResgate) throws TransacoesException {
        transacoes.sacar(valorResgate);
    }
}
