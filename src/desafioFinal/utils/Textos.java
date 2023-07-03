package desafioFinal.utils;

public class Textos {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void mensagemError(String mensagem) {
        System.out.println(ANSI_RED + mensagem + ANSI_RESET);
    }

    public static void mensagemBlue(String mensagem) {
        System.out.println(ANSI_BLUE + mensagem + ANSI_RESET);
    }

    public static void mensagemYellow(String mensagem) {
        System.out.println(ANSI_YELLOW + mensagem + ANSI_RESET);
    }

    public static void mensagemGreen(String mensagem) {
        System.out.println(ANSI_GREEN + mensagem + ANSI_RESET);
    }
}
