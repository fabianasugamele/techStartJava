package desafioFinal.services;

import desafioFinal.conta.Conta;
import desafioFinal.validators.TecladoValidator;

import java.util.Scanner;

public class Login {

    desafioFinal.conta.Login login = new desafioFinal.conta.Login();

    public void accessarConta() {
        Scanner teclado = new Scanner(System.in);
        TecladoValidator tecladoValidator = new TecladoValidator();

        System.out.println("Acesso a conta:");
        System.out.println("Digite sua agência");
        int agencia = tecladoValidator.checkInputTecladoInt(teclado);
        System.out.println("Digite o número da sua conta");
        int conta = tecladoValidator.checkInputTecladoInt(teclado);
        System.out.println("Digite sua senha");
        int senha = tecladoValidator.checkInputTecladoInt(teclado);
        this.login.logar(agencia,conta,senha);
    }

    public boolean isLogged() {
        return this.login.isLogged();
    }

    public String getMessageError() {
        return this.login.getMessageError();
    }

    public Conta getConta() {
        return this.login.getContaLogada();
    }
}
