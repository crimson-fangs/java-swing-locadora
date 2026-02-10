package trabalho_java_swing.filmes;

import trabalho_java_swing.base.JanelaBaseAcervo;

public class JanelaRomance extends JanelaBaseAcervo {

    public JanelaRomance() {
        super("FILMES DE ROMANCE", "imagens/fundobranco.jpg");

        adicionarItem("Eternal Sunshine", "imagens/eternalsunshine.jpg");
        adicionarItem("Amélie", "imagens/amelie.jpg");
        adicionarItem("Submarine", "imagens/submarine.jpg");
        adicionarItem("Scott Pilgrim", "imagens/scottpilgrim.jpg");
    }
    
}
