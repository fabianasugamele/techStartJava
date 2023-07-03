package desafioFinal.conta;

import desafioFinal.usuario.Pessoa;

import java.util.Random;

public class Poupanca extends Conta{

    public final static String TIPO = "Conta Poupança";

    public Poupanca(Pessoa pessoa) {
        Random random = new Random();
        this.pessoa = pessoa;
        this.agencia = random.nextInt(9000) + 1000;
        this.numeroConta = random.nextInt(90000) + 10000;
        this.tipo = TIPO;
    }

    @Override
    public String toString() {
        return "Poupanca{" +
                "tipo=" + tipo +
                ", senha=" + senha +
                ", saldo=" + saldo +
                ", agencia=" + agencia +
                ", numeroConta=" + numeroConta +
                ", pessoa=" + pessoa.toString() +
                '}';
    }
}
