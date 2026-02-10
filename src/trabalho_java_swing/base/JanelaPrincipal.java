package trabalho_java_swing.base;

import javax.swing.*;
import java.awt.*;
import trabalho_java_swing.jogos.JanelaJogos;
import trabalho_java_swing.discos.JanelaDiscos;
import trabalho_java_swing.filmes.JanelaFantasia;
import trabalho_java_swing.filmes.JanelaRomance;
import trabalho_java_swing.filmes.JanelaTerror;

class JanelaPrincipal extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel painelPrincipal;
    private JanelaCaixa janelaCaixa; 

    public JanelaPrincipal() {
        setTitle("Videolocadora");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon imagemFundo = new ImageIcon("imagens/fundo.jpg");

        JPanel painelComFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagemFundo.getIconWidth() != -1) {
                    g.drawImage(imagemFundo.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        painelComFundo.setLayout(new BorderLayout());
        setContentPane(painelComFundo);

        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);
        painelPrincipal.setOpaque(false);

        janelaCaixa = new JanelaCaixa();

        JanelaTerror telaTerror = new JanelaTerror();
        telaTerror.setJanelaCaixa(janelaCaixa);

        JanelaRomance telaRomance = new JanelaRomance();
        telaRomance.setJanelaCaixa(janelaCaixa);
        
        JanelaFantasia telaFantasia = new JanelaFantasia();
        telaFantasia.setJanelaCaixa(janelaCaixa);
        
        JanelaJogos telaJogos = new JanelaJogos();
        telaJogos.setJanelaCaixa(janelaCaixa);

        JanelaDiscos telaDiscos = new JanelaDiscos();
        telaDiscos.setJanelaCaixa(janelaCaixa);

        JPanel painelInicio = new JPanel(new BorderLayout());
        painelInicio.setOpaque(false);

        painelPrincipal.add(painelInicio, "INICIO");
        painelPrincipal.add(telaTerror, "TERROR");
        painelPrincipal.add(telaRomance, "ROMANCE");
        painelPrincipal.add(telaFantasia, "FANTASIA");
        painelPrincipal.add(telaJogos, "JOGOS");
        painelPrincipal.add(telaDiscos, "DISCOS");
        painelPrincipal.add(janelaCaixa, "CAIXA"); 

        painelComFundo.add(painelPrincipal, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuAcervo = new JMenu("Acervo");
        JMenu menuLoja = new JMenu("Loja");

        JMenuItem itemInicio = new JMenuItem("Voltar ao Início");
        JMenuItem itemTerror = new JMenuItem("Filmes de Terror");
        JMenuItem itemRomance = new JMenuItem("Filmes de Romance");
        JMenuItem itemFantasia = new JMenuItem("Filmes de Fantasia");
        JMenuItem itemJogos = new JMenuItem("Jogos");
        JMenuItem itemDiscos = new JMenuItem("Discos de Vinil");

        JMenuItem itemCaixa = new JMenuItem("Ir para o Caixa");
        JMenuItem itemSair = new JMenuItem("Sair da Loja");

        menuAcervo.add(itemInicio);
        menuAcervo.addSeparator();
        menuAcervo.add(itemTerror);
        menuAcervo.add(itemRomance);
        menuAcervo.add(itemFantasia);
        menuAcervo.addSeparator();
        menuAcervo.add(itemJogos);
        menuAcervo.addSeparator();
        menuAcervo.add(itemDiscos);

        menuLoja.add(itemCaixa);
        menuLoja.addSeparator();
        menuLoja.add(itemSair);

        menuBar.add(menuAcervo);
        menuBar.add(menuLoja);

        setJMenuBar(menuBar);

        itemInicio.addActionListener(e -> cardLayout.show(painelPrincipal, "INICIO"));
        itemTerror.addActionListener(e -> cardLayout.show(painelPrincipal, "TERROR"));
        itemRomance.addActionListener(e -> cardLayout.show(painelPrincipal, "ROMANCE"));
        itemFantasia.addActionListener(e -> cardLayout.show(painelPrincipal, "FANTASIA"));
        itemJogos.addActionListener(e -> cardLayout.show(painelPrincipal, "JOGOS"));
        itemDiscos.addActionListener(e -> cardLayout.show(painelPrincipal, "DISCOS"));
        itemCaixa.addActionListener(e -> cardLayout.show(painelPrincipal, "CAIXA"));
        itemSair.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}