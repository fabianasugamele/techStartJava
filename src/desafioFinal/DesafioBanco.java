package desafioFinal;

import desafioFinal.conta.Conta;
import desafioFinal.menu.Menu;
import desafioFinal.menu.Principal;

import java.util.Scanner;

public class DesafioBanco {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Menu menu = new Principal();
        menu.showMenu();
        menu.capturaTeclado(teclado);
        menu.executaMenu();

        for (Conta element : Conta.contas) {
            System.out.println(element.toString());
        }
    }
}
