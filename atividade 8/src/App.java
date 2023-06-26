
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Equipe {
    private String nome;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int golsMarcados;
    private int golsSofridos;

    public Equipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void incrementarVitorias() {
        vitorias++;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void incrementarDerrotas() {
        derrotas++;
    }

    public int getEmpates() {
        return empates;
    }

    public void incrementarEmpates() {
        empates++;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void incrementarGolsMarcados(int gols) {
        golsMarcados += gols;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public void incrementarGolsSofridos(int gols) {
        golsSofridos += gols;
    }

    public void imprimirEstatisticas() {
        System.out.println("Equipe: " + nome);
        System.out.println("Vitórias: " + vitorias + ", Derrotas: " + derrotas + ", Empates: " + empates);
        System.out.println("Gols Marcados: " + golsMarcados + ", Gols Sofridos: " + golsSofridos);
        System.out.println();
    }
}

class Jogo {
    private int numeroJogo;
    private Equipe equipeCasa;
    private Equipe equipeVisitante;
    private int temperatura;
    private int golsCasa;
    private int golsVisitante;

    public Jogo(int numeroJogo, Equipe equipeCasa, Equipe equipeVisitante, int temperatura) {
        this.numeroJogo = numeroJogo;
        this.equipeCasa = equipeCasa;
        this.equipeVisitante = equipeVisitante;
        this.temperatura = temperatura;
    }

    public void jogar() {
        Random random = new Random();
        golsCasa = random.nextInt(4);
        golsVisitante = random.nextInt(4);

        equipeCasa.incrementarGolsMarcados(golsCasa);
        equipeCasa.incrementarGolsSofridos(golsVisitante);

        equipeVisitante.incrementarGolsMarcados(golsVisitante);
        equipeVisitante.incrementarGolsSofridos(golsCasa);

        if (golsCasa > golsVisitante) {
            equipeCasa.incrementarVitorias();
            equipeVisitante.incrementarDerrotas();
        } else if (golsCasa < golsVisitante) {
            equipeCasa.incrementarDerrotas();
            equipeVisitante.incrementarVitorias();
        } else {
            equipeCasa.incrementarEmpates();
            equipeVisitante.incrementarEmpates();
        }
    }

    public void imprimirResultado() {
        System.out.println("Jogo #" + numeroJogo);
        System.out.println("Temperatura: " + temperatura + " graus");

        String classificacaoTemperatura;
        if (temperatura >= 40) {
            classificacaoTemperatura = "Calor Extremo";
        } else if (temperatura >= 25) {
            classificacaoTemperatura = "Quente";
        } else if (temperatura >= 5) {
            classificacaoTemperatura = "Temperado";
        } else {
            System.out.println("Rodada adiada devido ao frio extremo.");
            System.out.println();
            return;
        }

        System.out.println("Classificação da Temperatura: " + classificacaoTemperatura);

        System.out.println("Equipe Casa: " + equipeCasa.getNome() + " " + golsCasa + " x " + golsVisitante + " " + equipeVisitante.getNome());
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {
        Scanner  teclado = new Scanner(System.in);
        List<Equipe> equipes = new ArrayList<>();

        equipes.add(new Equipe("Internacional"));
        equipes.add(new Equipe("Cruzeiro de Porto Alegre"));
        equipes.add(new Equipe("Juventude"));
        equipes.add(new Equipe("Brasil de Pelotas"));

        System.out.println("=== Temporada de Futebol ===");
        System.out.println();

        int rodada = 1;
        while (rodada <= 10) {
            System.out.print("Digite a temperatura da rodada " + rodada + ": ");
            int temperatura = teclado.nextInt();
            teclado.nextLine(); 
            System.out.println();

            String classificacaoTemperatura;
            if (temperatura >= 40) {
                System.out.println("Rodada adiada devido ao calor excessivo.");
                System.out.println();
                rodada++;
                continue;
            } else if (temperatura >= 25) {
                classificacaoTemperatura = "Quente";
            } else if (temperatura >= 5) {
                classificacaoTemperatura = "Temperado";
            } else if (temperatura >= 0) {
                System.out.println("Rodada adiada devido ao frio extremo.");
                System.out.println();
                rodada++;
                continue;
            } else {
                System.out.println("Rodada adiada devido ao frio extremo.");
                System.out.println();
                rodada++;
                continue;
            }

            System.out.println("Classificação da Temperatura: " + classificacaoTemperatura);
            System.out.println();

            for (int i = 0; i < equipes.size(); i += 2) {
                Equipe equipeCasa = equipes.get(i);
                Equipe equipeVisitante = equipes.get(i + 1);
                Jogo jogo = new Jogo(rodada, equipeCasa, equipeVisitante, temperatura);
                jogo.jogar();
                jogo.imprimirResultado();
            }

            rodada++;
        }

        System.out.println("Temporada encerrada");
        System.out.println();

        System.out.println("=== Classificação Final ===");
        for (Equipe equipe : equipes) {
            equipe.imprimirEstatisticas();
        }

        Equipe campeao = equipes.get(0);
        for (Equipe equipe : equipes) {
            if (equipe.getVitorias() > campeao.getVitorias()) {
                campeao = equipe;
            }
        }

        System.out.println("O campeão da temporada é: " + campeao.getNome());
    }
}