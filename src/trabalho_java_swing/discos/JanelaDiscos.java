package trabalho_java_swing.discos;

import java.awt.Dimension;
import trabalho_java_swing.base.JanelaBaseAcervo;

public class JanelaDiscos extends JanelaBaseAcervo {

    public JanelaDiscos() {
        super("DISCOS DE VINIL", "imagens/fundobranco.jpg");

        this.dimensaoCard = new Dimension(220, 300); 
        this.dimensaoImagem = new Dimension(220, 220);

        adicionarItem("Ten", "imagens/pearljamten.jpg");
        adicionarItem("Vol.4", "imagens/vol4.jpg");
        adicionarItem("Floodland", "imagens/floodland.jpg");
    }
}