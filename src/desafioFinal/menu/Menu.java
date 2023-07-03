package desafioFinal.menu;

import desafioFinal.validators.TecladoValidator;

import java.util.Scanner;

public abstract  class Menu {
    Scanner teclado;
    int opcaoMenu;

    public abstract void showMenu();
    public abstract void executaMenu();

    public void capturaTeclado(Scanner teclado) {
        TecladoValidator tecladoValidator = new TecladoValidator();
        this.opcaoMenu =tecladoValidator.checkInputTecladoInt(teclado);
        this.teclado = teclado;
    }

}
