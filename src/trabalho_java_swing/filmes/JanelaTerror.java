package trabalho_java_swing.filmes;

import trabalho_java_swing.base.JanelaBaseAcervo;

public class JanelaTerror extends JanelaBaseAcervo {

    public JanelaTerror() {
        super("FILMES DE TERROR", "imagens/fundobranco.jpg");

        adicionarItem("Tetsuo: Iron Man", "imagens/tetsuo.jpg");
        adicionarItem("The Vampire Doll", "imagens/vampiredoll.jpg");
        adicionarItem("Frankenstein", "imagens/frankenstein.jpg");
        adicionarItem("Dracula", "imagens/dracula.jpg");
    }
}