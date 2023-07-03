package desafioFinal.services;

import desafioFinal.conta.Conta;
import desafioFinal.conta.Corrente;
import desafioFinal.usuario.Pessoa;
import desafioFinal.utils.Textos;
import desafioFinal.validators.TecladoValidator;

import java.util.Scanner;

public class ContaCorrente {

    public void cadastrar() {
        Scanner teclado = new Scanner(System.in);
        TecladoValidator tecladoValidator = new TecladoValidator();
        Pessoa pessoa = new Pessoa();

        System.out.println("Digite seu nome completo");
        String nomeCompleto = tecladoValidator.checkInputTecladoString(teclado);
        pessoa.setNomeCompleto(nomeCompleto);

        System.out.println("Digite seu nome cpf");
        int cpf = tecladoValidator.checkInputTecladoInt(teclado);
        pessoa.setCpf(cpf);

        System.out.println("Digite seu endereço");
        String endereco = tecladoValidator.checkInputTecladoString(teclado);
        pessoa.setEndereco(endereco);

        System.out.println("Digite seu telefone");
        String telefone = tecladoValidator.checkInputTecladoString(teclado);
        pessoa.setTelefone(telefone);

        Corrente contaCorrente = new Corrente(pessoa);
        System.out.println("Digite sua chave Pix");
        int pix = tecladoValidator.checkInputTecladoInt(teclado);
        contaCorrente.setPix(pix);

        System.out.println("Digite uma senha");
        int senha = tecladoValidator.checkInputTecladoInt(teclado);
        contaCorrente.setSenha(senha);

        System.out.println("Digite o saldo");
        double saldo = tecladoValidator.checkInputTecladoDouble(teclado);
        contaCorrente.setSaldo(saldo);

        Conta.contas.add(contaCorrente);

        Textos.mensagemGreen("Cadastro efetuado com sucesso!");
        System.out.println(contaCorrente);
    }
}
