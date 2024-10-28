public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void addAcoes(Acoes acoes);
    void notificar();
}