package desafioFinal.conta;

public class Login {

    boolean isLogged = false;

    Conta contaLogada;

    String messageError;

    public Login logar(int agencia, int numeroConta, int senha) {
        for (Conta conta : Conta.contas) {
            if (conta.getAgencia() == agencia && conta.getNumeroConta() == numeroConta && conta.getSenha() == senha) {
                this.contaLogada = conta;
                this.isLogged = true;
                return this;
            }
        }

        if (Conta.contas.stream().noneMatch(c -> c.getAgencia() == agencia)) {
            this.isLogged = false;
            this.messageError = "Agência não encontrada";
            return this;
        } else if (Conta.contas.stream().noneMatch(c -> c.getNumeroConta() == numeroConta)) {
            this.messageError = "Conta não encontrada";
            return this;
        } else if (Conta.contas.stream().noneMatch(c -> c.getSenha() == senha)) {
            this.messageError = "Senha inválida";
            return this;
        }

        return this;
    }

    public boolean isLogged() {
        return this.isLogged;
    }

    public Conta getContaLogada() {
        return this.contaLogada;
    }

    public String getMessageError() {
        return this.messageError;
    }
}
