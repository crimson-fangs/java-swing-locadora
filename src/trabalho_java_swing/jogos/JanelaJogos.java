package trabalho_java_swing.jogos;

import trabalho_java_swing.base.JanelaBaseAcervo;

public class JanelaJogos extends JanelaBaseAcervo {

    public JanelaJogos() {
        super("JOGOS", "imagens/fundobranco.jpg");

        adicionarItem("Quake", "imagens/quake.jpg");
        adicionarItem("Crash Bandicoot", "imagens/crashbandicoot.jpg");
        adicionarItem("Half-Life", "imagens/halflife.jpg");
        adicionarItem("Banjo-Kazooie", "imagens/banjokazooie.jpg");
    }
}