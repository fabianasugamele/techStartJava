package desafioFinal.validators;

import desafioFinal.utils.Textos;

import java.util.Scanner;

public class TecladoValidator {

    public int checkInputTecladoInt(Scanner teclado) {
        while (true) {
            try {
                return teclado.nextInt();
            } catch (Exception e) {
                Textos.mensagemError("O valor deve ser um inteiro. Tente novamente.");
            } finally{
                teclado.nextLine();
            }
        }
    }

    public String checkInputTecladoString(Scanner teclado) {
        String inputString = "";

        while (inputString.isEmpty()) {
            inputString = teclado.nextLine();

            if (inputString.isEmpty()) {
                Textos.mensagemError("O campo não pode ser vazio");
            }
        }

        return inputString;
    }

    public double checkInputTecladoDouble(Scanner teclado) {
        while (true) {
            try {
                return teclado.nextDouble();
            } catch (Exception e) {
                Textos.mensagemError("O valor deve ser um número. Tente novamente.");
            } finally{
                teclado.nextLine();
            }
        }
    }
}
