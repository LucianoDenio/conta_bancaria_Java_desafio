public class AccountBank {
    private String name;
    private Integer id;
    private Double balance;

    public AccountBank(String name, Integer id, Double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public AccountBank(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(double ammount){
        balance += ammount;
    }

    public boolean withDraw(double ammount){
        boolean haveAmmount;
        if(ammount <= balance){
            balance -= ammount;
            haveAmmount = true;
        }else {
            haveAmmount = false;
        }
        return haveAmmount;
    }

    public void atualizarDeposito(double ammount){
        deposit(ammount);
        System.out.println("Deposito realizado com sucesso! Saldo atualizado: " + String.format("%.2f%n", balance));
    }

    public void atualizarSaque(double ammount) {
        // Chama a função withdraw e verifica o resultado

        if (withDraw(ammount)) {
            // Se for verdadeiro, imprime mensagem de saldo atualizado
            System.out.println("Saque realizado com sucesso! Saldo atualizado: " + String.format("%.2f%n", balance));
        } else {
            // Se for falso, indica que não há saldo suficiente
            System.out.println("Não há saldo suficiente para saque.");
        }

    }


    @Override
    public String toString(){
        String dados;
        dados = String.format("%n*************************** %n%n" +
                "Nome: %s %n" +
                "Número da conta: %d(corrente)%n" +
                "Saldo: %.2f%n%n***************************%n", name,id,balance);
        return dados;
    }
}
