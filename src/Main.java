public class Main {
    public static void main(String[] args) {
        NaveJogador jogador = NaveJogador.getInstance();

        Observer naveInimiga1 = new NaveInimiga("Nave1", jogador);
        Observer naveInimiga2 = new NaveInimiga("Nave2", jogador);
        Observer naveInimiga3 = new NaveInimiga("Nave3", jogador);

        // loop para simular movimentos aleatórios do jogador
        for (int i = 0; i < 10; i++) {
            jogador.movimentoAleatorio();
            try {
                Thread.sleep(1000); // observando as atualizacoes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}