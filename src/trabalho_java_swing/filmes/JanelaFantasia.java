package trabalho_java_swing.filmes;

import trabalho_java_swing.base.JanelaBaseAcervo;

public class JanelaFantasia extends JanelaBaseAcervo {

    public JanelaFantasia() {
        super("FILMES DE FANTASIA", "imagens/fundobranco.jpg");

        adicionarItem("Ponyo", "imagens/ponyo.jpg");
        adicionarItem("Beetlejuice", "imagens/beetlejuice.jpg");
        adicionarItem("Spirited Away", "imagens/spiritedaway.jpg");
        adicionarItem("Coraline", "imagens/coraline.jpg");
    }
    
}