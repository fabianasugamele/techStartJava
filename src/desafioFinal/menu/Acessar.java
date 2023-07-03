package desafioFinal.menu;

import desafioFinal.conta.Conta;
import desafioFinal.conta.Corrente;
import desafioFinal.conta.Exceptions.PixException;
import desafioFinal.conta.Exceptions.TransacoesException;
import desafioFinal.conta.Poupanca;
import desafioFinal.conta.movimentacoes.Extrato;
import desafioFinal.conta.movimentacoes.Pix;
import desafioFinal.conta.movimentacoes.Transacoes;
import desafioFinal.conta.movimentacoes.Transacoes.*;
import desafioFinal.utils.Textos;
import desafioFinal.validators.TecladoValidator;

public class Acessar extends Menu{
    Conta conta;

    Extrato extrato;

    Transacoes transacoes;
    TecladoValidator tecladoValidator;

    public Acessar(Conta conta) {
        super();
        this.conta = conta;
        this.extrato = new Extrato(this.conta);
        this.tecladoValidator = new TecladoValidator();
        this.transacoes = new Transacoes(this.conta);
    }

    @Override
    public void showMenu() {
        System.out.println("");

        if (conta.getTipo().equals(Corrente.TIPO)) {
            Textos.mensagemBlue("Conta corrente: ");
            showMenuContaCorrente();
        }

        if (conta.getTipo().equals(Poupanca.TIPO)) {
            Textos.mensagemBlue("Conta poupanca: ");
            showMenuContaPoupanca();
        }

        Textos.mensagemYellow("6 - Consultar Saldo"); //ambos
        Textos.mensagemYellow("7 - Encerrar conta"); //ambos
        Textos.mensagemYellow("8 - Voltar");
    }


    private void showMenuContaCorrente() {

        Textos.mensagemYellow("1 - Depositar"); //corrente
        Textos.mensagemYellow("2 - Sacar"); //corrente
        Textos.mensagemYellow("3 - Pix"); //corrente
    }

    private void showMenuContaPoupanca() {
        Textos.mensagemYellow("4 - Aplicar"); //poupanca investimento
        Textos.mensagemYellow("5 - Resgatar"); //poupanca
    }

    @Override
    public void executaMenu() {
        while (this.opcaoMenu>8 || this.opcaoMenu == 0){
            Textos.mensagemError("Número inválido");
            Textos.mensagemYellow("Digite numero entre 1 e 3 para retornar ao menu");
            this.capturaTeclado(this.teclado);
        }if (this.opcaoMenu == 8){
            this.geraMenuPrincipal();
        } if(conta.getTipo().equals(Corrente.TIPO) && (this.opcaoMenu == 4 || this.opcaoMenu == 5)) {
            Textos.mensagemError("Opção inválida");
            this.capturaTeclado(this.teclado);
        }
        if(conta.getTipo().equals(Poupanca.TIPO) && (this.opcaoMenu == 1 || this.opcaoMenu == 2 || this.opcaoMenu == 3)) {
            Textos.mensagemError("Opção inválida");
            this.capturaTeclado(this.teclado);
        }

        switch (this.opcaoMenu) {
            case 1:
                Textos.mensagemBlue("Você possui um saldo de: R$" + this.extrato.getSaldo());
                Textos.mensagemYellow("Digite o valor para depositar");
                transacoes.depositar(tecladoValidator.checkInputTecladoDouble(teclado));
                Textos.mensagemBlue("Seu novo saldo é de: R$ " + this.extrato.getSaldo());

                this.geraMenuAcessar();
                break;
            case 2:
                Textos.mensagemBlue("Você possui um saldo de: R$" + this.extrato.getSaldo());
                Textos.mensagemYellow("Digite o valor para sacar");
                try {
                    transacoes.sacar(tecladoValidator.checkInputTecladoDouble(teclado));
                } catch (TransacoesException exception) {
                    Textos.mensagemError(exception.getMessage());
                }

                Textos.mensagemBlue("Seu saldo é de: R$ " + this.extrato.getSaldo());

                this.geraMenuAcessar();
                break;
            case 3:
                Textos.mensagemBlue("Você possui um saldo de: R$" + this.extrato.getSaldo());

                Textos.mensagemYellow("Digite sua chave Pix");
                int chavePix = tecladoValidator.checkInputTecladoInt(teclado);
                Textos.mensagemYellow("Digite o valor de transferencia via Pix");
                double valorPix = tecladoValidator.checkInputTecladoDouble(teclado);

                Pix pix = new Pix(this.conta);
                try {
                    pix.transferencia(chavePix, valorPix);
                }catch (PixException exception) {
                    Textos.mensagemError(exception.getMessage());
                }

                Textos.mensagemBlue("Seu saldo é de: R$ " + this.extrato.getSaldo());

                this.geraMenuAcessar();
                break;
            case 4:
                Textos.mensagemBlue("Você possui um saldo de: R$" + this.extrato.getSaldo());
                Textos.mensagemYellow("Digite o valor para aplicar");
                transacoes.depositar(tecladoValidator.checkInputTecladoDouble(teclado));
                Textos.mensagemBlue("Seu novo saldo é de: R$ " + this.extrato.getSaldo());

                this.geraMenuAcessar();
                break;
            case 5:
                Textos.mensagemBlue("Você possui um saldo de: R$" + this.extrato.getSaldo());
                Textos.mensagemYellow("Digite o valor para resgatar");
                try {
                    transacoes.sacar(tecladoValidator.checkInputTecladoDouble(teclado));
                } catch (TransacoesException exception) {
                    Textos.mensagemError(exception.getMessage());
                }

                Textos.mensagemBlue("Seu saldo é de: R$ " + this.extrato.getSaldo());

                this.geraMenuAcessar();
                break;
            case 6:
                Textos.mensagemBlue("O seu saldo é de: R$ " + this.extrato.getSaldo());
                this.geraMenuAcessar();
                break;
            case 7:
                Textos.mensagemYellow("Deseja realmente encerrar a conta ? (S ou N) ");
                String encerrar = tecladoValidator.checkInputTecladoString(teclado);
                encerrar = encerrar.toLowerCase();
                if(encerrar.equals("s") || encerrar.equals("sim")) {
                    this.conta.removerConta();
                    Textos.mensagemGreen("Conta encerrada com sucesso!!");
                }
                this.geraMenuPrincipal();
                break;
        }
    }

    private void geraMenuAcessar() {
        Menu menuAcessar = new Acessar(this.conta);
        menuAcessar.showMenu();
        menuAcessar.capturaTeclado(teclado);
        menuAcessar.executaMenu();
    }

    private void geraMenuPrincipal() {
        Menu menu = new Principal();
        menu.showMenu();
        menu.capturaTeclado(this.teclado);
        menu.executaMenu();
    }
}
