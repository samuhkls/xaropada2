public class NaveInimiga implements Observer {
    private String nome;
    private Subject subject;
    private int contagemAtualizacoes = 0;

    public NaveInimiga(String nome, Subject subject) {
        this.nome = nome;
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update(Acoes acoes) {
        contagemAtualizacoes++;
        System.out.println(nome + " recebeu a ação: " + acoes);


        if (contagemAtualizacoes >= 5) {
            System.out.println(nome + " foi destruída!");
            subject.removeObserver(this);
        }
    }
}
