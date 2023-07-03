package desafioFinal.conta.movimentacoes;

import desafioFinal.conta.Conta;
import desafioFinal.conta.Corrente;
import desafioFinal.conta.Exceptions.PixException;

public class Pix {

    Conta conta;

    public Pix(Conta conta) {
        this.conta = conta;
    }

    public void transferencia(int chavePix, double valor) throws PixException {
        if(!this.conta.getTipo().equals(Corrente.TIPO)) {
            throw new PixException("Opção inválida para seu tipo de conta");
        }

        if(chavePix != ((Corrente)this.conta).getPix()) {
            throw new PixException("Chave Pix inválida");
        }

        Transacoes transacoes = new Transacoes(this.conta);
        transacoes.depositar(valor);

    }

}
