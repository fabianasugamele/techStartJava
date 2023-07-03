package desafioFinal.conta;

import desafioFinal.usuario.Pessoa;

import java.util.Random;

public class Corrente extends Conta{
    int pix;

    public final static String TIPO = "Conta Corrente";

    public Corrente(Pessoa pessoa) {
        Random random = new Random();
        this.pessoa = pessoa;
        this.agencia = random.nextInt(9000) + 1000;
        this.numeroConta = random.nextInt(90000) + 10000;
        this.tipo = TIPO;
    }

    public int getPix() {
        return pix;
    }

    public void setPix(int pix) {
        this.pix = pix;
    }

    @Override
    public String toString() {
        return "Corrente{" +
                "tipo=" + tipo  +
                ", senha=" + senha +
                ", saldo=" + saldo +
                ", agencia=" + agencia +
                ", numeroConta=" + numeroConta +
                ", pix=" + pix +
                ", pessoa=" + pessoa.toString() +
                '}';
    }
}
