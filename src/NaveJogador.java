import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NaveJogador implements Subject {
    private static NaveJogador instanciaUnica;
    private List<Observer> observadores = new LinkedList<>();
    private List<Acoes> listaAcoes = new LinkedList<>();
    private int index = -1;

    private NaveJogador() {}

    public static NaveJogador getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new NaveJogador();
        }
        return instanciaUnica;
    }

    @Override
    public void addObserver(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void addAcoes(Acoes acoes) {
        listaAcoes.add(acoes);
        index++;
        notificar();
    }

    @Override
    public void notificar() {
        for (Observer observer : new LinkedList<>(observadores)) {
            observer.update(listaAcoes.get(index));
        }
    }

    public void movimentoAleatorio() {
        Acoes[] movimentos = Acoes.values();
        Random random = new Random();
        Acoes acaoAleatoria = movimentos[random.nextInt(movimentos.length)];
        addAcoes(acaoAleatoria);
    }
}