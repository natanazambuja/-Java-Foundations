class Cartao {
    private int numero;
    private int saldoCredito;
    private int saldoTickets;

    public Cartao(int numero) {
        this.numero = numero;
        this.saldoCredito = 0;
        this.saldoTickets = 0;
    }

    public int getNumero() {
        return numero;
    }

    public int getSaldoCredito() {
        return saldoCredito;
    }

    public int getSaldoTickets() {
        return saldoTickets;
    }

    public void adicionarCredito(int valor) {
        saldoCredito += valor;
    }

    public void removerCredito(int valor) {
        saldoCredito -= valor;
    }

    public void adicionarTickets(int quantidade) {
        saldoTickets += quantidade;
    }

    public void removerTickets(int quantidade) {
        saldoTickets -= quantidade;
    }
}

class Jogo {
    private int creditosNecessarios;

    public Jogo(int creditosNecessarios) {
        this.creditosNecessarios = creditosNecessarios;
    }

    public void jogar(Cartao cartao) {
        if (cartao.getSaldoCredito() >= creditosNecessarios) {
            int ticketsGanhos = (int) (Math.random() * 10);
            System.out.println("Numero do cartao: " + cartao.getNumero());
            System.out.println("Tiquetes ganhos: " + ticketsGanhos);
            cartao.removerCredito(creditosNecessarios);
            cartao.adicionarTickets(ticketsGanhos);
            System.out.println("Novo saldo de tiquetes: " + cartao.getSaldoTickets());
        } else {
            System.out.println("Cartao " + cartao.getNumero() + " tem creditos insuficientes para jogar.");
        }
    }
}

class CategoriaPremio {
    private String nome;
    private int ticketsNecessarios;
    private int quantidade;

    public CategoriaPremio(String nome, int ticketsNecessarios, int quantidade) {
        this.nome = nome;
        this.ticketsNecessarios = ticketsNecessarios;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getTicketsNecessarios() {
        return ticketsNecessarios;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void removerPremio() {
        quantidade--;
    }
}

class Terminal {
    private CategoriaPremio[] categoriasPremio;

    public Terminal() {
        categoriasPremio = new CategoriaPremio[3];
        categoriasPremio[0] = new CategoriaPremio("Premio 1", 5, 10);
        categoriasPremio[1] = new CategoriaPremio("Premio 2", 10, 5);
        categoriasPremio[2] = new CategoriaPremio("Premio 3", 15, 3);
    }

    public void transferirCreditos(Cartao origem, Cartao destino, int quantidade) {
        if (origem.getSaldoCredito() >= quantidade) {
            origem.removerCredito(quantidade);
            destino.adicionarCredito(quantidade);
            System.out.println("Transferencia de creditos concluida: " + quantidade + " creditos transferidos do cartao "
                    + origem.getNumero() + " para o cartao " + destino.getNumero());
            System.out.println("Novo saldo de creditos do cartao " + origem.getNumero() + ": " + origem.getSaldoCredito());
            System.out.println("Novo saldo de creditos do cartao " + destino.getNumero() + ": " + destino.getSaldoCredito());
        } else {
            System.out.println("Cartao " + origem.getNumero() + " tem creditos insuficientes para transferir.");
        }
    }

    public void transferirTickets(Cartao origem, Cartao destino, int quantidade) {
        if (origem.getSaldoTickets() >= quantidade) {
            origem.removerTickets(quantidade);
            destino.adicionarTickets(quantidade);
            System.out.println("Transferencia de tiquetes concluida: " + quantidade + " tíquetes transferidos do cartao "
                    + origem.getNumero() + " para o cartao " + destino.getNumero());
            System.out.println("Novo saldo de tiquetes do cartao " + origem.getNumero() + ": " + origem.getSaldoTickets());
            System.out.println("Novo saldo de tiquetes do cartao " + destino.getNumero() + ": " + destino.getSaldoTickets());
        } else {
            System.out.println("Cartao " + origem.getNumero() + " tem tiquetes insuficientes para transferir.");
        }
    }

    public void trocarTicketsPorPremio(Cartao cartao, int categoriaPremioIndex) {
        if (categoriaPremioIndex >= 0 && categoriaPremioIndex < categoriasPremio.length) {
            CategoriaPremio categoriaPremio = categoriasPremio[categoriaPremioIndex];
            if (cartao.getSaldoTickets() >= categoriaPremio.getTicketsNecessarios()) {
                if (categoriaPremio.getQuantidade() > 0) {
                    cartao.removerTickets(categoriaPremio.getTicketsNecessarios());
                    categoriaPremio.removerPremio();
                    System.out.println("Premio '" + categoriaPremio.getNome() + "' concedido ao cartao "
                            + cartao.getNumero());
                    System.out.println("Novo saldo de tiquetes do cartao " + cartao.getNumero() + ": "
                            + cartao.getSaldoTickets());
                    System.out.println("Quantidade restante do premio '" + categoriaPremio.getNome() + "': "
                            + categoriaPremio.getQuantidade());
                } else {
                    System.out.println("Terminal sem estoque do premio '" + categoriaPremio.getNome() + "'.");
                }
            } else {
                System.out.println(
                        "Cartao " + cartao.getNumero() + " tem tiquetes insuficientes para trocar por este premio.");
            }
        } else {
            System.out.println("Categoria de premio invalida.");
        }
    }
}

public class App {
    public static void main(String[] args) {
        // Instanciando objetos
        Cartao cartao1 = new Cartao(1);
        Cartao cartao2 = new Cartao(2);
        Jogo jogo = new Jogo(5);
        Terminal terminal = new Terminal();

        // Carregando creditos nos cartoes
        cartao1.adicionarCredito(10);
        cartao2.adicionarCredito(20);

        // Jogando um grupo de jogos usando os dois cartoes
        jogo.jogar(cartao1);
        jogo.jogar(cartao2);

        // Transferindo saldo de creditos e tiquetes do Cartao 1 para o Cartao 2
        terminal.transferirCreditos(cartao1, cartao2, 5);
        terminal.transferirTickets(cartao1, cartao2, 3);

        // Solicitando premios usando o Cartao 2
        terminal.trocarTicketsPorPremio(cartao2, 1);

        // Tentando jogar um jogo e solicitar um premio usando o Cartao 1
        jogo.jogar(cartao1);
        terminal.trocarTicketsPorPremio(cartao1, 0);
    }
}
       