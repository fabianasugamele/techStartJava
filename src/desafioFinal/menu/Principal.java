package desafioFinal.menu;

import desafioFinal.services.Login;
import desafioFinal.utils.Textos;

import java.util.Scanner;

public class Principal extends Menu{
    @Override
    public void showMenu() {
        System.out.println("");
        Textos.mensagemBlue("Escolha uma opção :");
        Textos.mensagemYellow("1 - Cadastrar Conta");
        Textos.mensagemYellow("2 - Acessar Contas");
        Textos.mensagemYellow("3 - Sair");
    }

    public void executaMenu() {
        while (this.opcaoMenu>3 || this.opcaoMenu == 0){
            Textos.mensagemError("Número inválido");
            Textos.mensagemYellow("Digite numero entre 1 e 3 para retornar ao menu");
            this.capturaTeclado(this.teclado);
        }if (this.opcaoMenu == 3){
            Textos.mensagemGreen("Programa Encerrado Com sucesso ");
        }switch (this.opcaoMenu) {
            case 1:
                Menu menu = new Cadastrar();
                menu.showMenu();
                menu.capturaTeclado(this.teclado);
                menu.executaMenu();
                break;
            case 2:
                Login serviceLogin = new Login();
                serviceLogin.accessarConta();
                if(!serviceLogin.isLogged()) {
                    Textos.mensagemError("Autenticação inválida:");
                    Textos.mensagemError(serviceLogin.getMessageError());
                    Menu menuPrincipal = new Principal();
                    menuPrincipal.showMenu();
                    menuPrincipal.capturaTeclado(teclado);
                    menuPrincipal.executaMenu();
                    break;
                }

                Menu menuAcessar = new Acessar(serviceLogin.getConta());
                menuAcessar.showMenu();
                menuAcessar.capturaTeclado(teclado);
                menuAcessar.executaMenu();
                break;
        }
    }
}
