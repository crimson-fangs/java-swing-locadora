package trabalho_java_swing.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class JanelaBaseAcervo extends JPanel {

    private Image imagemFundo;
    private JPanel painelFilmes;
    private JanelaCaixa janelaCaixa; 
    
    private Color corDestaque = Color.GRAY; 
    private Color corTextoTitulo = Color.BLACK;

    protected Dimension dimensaoCard = new Dimension(180, 320);
    protected Dimension dimensaoImagem = new Dimension(180, 240);

    public JanelaBaseAcervo(String tituloPagina, String caminhoFundo) {
        this(tituloPagina, caminhoFundo, Color.GRAY, Color.BLACK);
    }

    public JanelaBaseAcervo(String tituloPagina, String caminhoFundo, Color corDestaque, Color corTextoTitulo) {
        this.corDestaque = corDestaque;
        this.corTextoTitulo = corTextoTitulo;
        
        setLayout(new BorderLayout());

        try {
            imagemFundo = new ImageIcon(caminhoFundo).getImage();
        } catch (Exception e) {
            System.err.println("Erro imagem: " + caminhoFundo);
        }

        JLabel lblTitulo = new JLabel(tituloPagina, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 50));
        lblTitulo.setForeground(corTextoTitulo);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(75, 0, 0, 0));
        add(lblTitulo, BorderLayout.NORTH);

        painelFilmes = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        painelFilmes.setOpaque(false);
        painelFilmes.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        
        add(painelFilmes, BorderLayout.CENTER);
    }

    public void setJanelaCaixa(JanelaCaixa janelaCaixa) {
        this.janelaCaixa = janelaCaixa;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    protected void adicionarItem(String titulo, String caminhoImagem) {
        painelFilmes.add(criarCard(titulo, caminhoImagem));
    }

    private JPanel criarCard(String titulo, String caminhoImagem) {
        JPanel box = new JPanel();
        box.setLayout(new BorderLayout());
        box.setBackground(new Color(20, 20, 20)); 
        box.setBorder(BorderFactory.createLineBorder(corDestaque, 3));
        
        box.setPreferredSize(dimensaoCard); 

        JLabel lblImagem = new JLabel();
        lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagem.setPreferredSize(dimensaoImagem);

        try {
            ImageIcon icone = new ImageIcon(caminhoImagem);
            Image img = icone.getImage().getScaledInstance(dimensaoImagem.width, dimensaoImagem.height, Image.SCALE_SMOOTH);
            lblImagem.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            lblImagem.setText("<html><center>" + titulo + "</center></html>");
            lblImagem.setForeground(corDestaque);
            lblImagem.setFont(new Font("Courier New", Font.BOLD, 20));
        }

        JLabel lblTitulo = new JLabel(titulo, SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setPreferredSize(new Dimension(dimensaoCard.width, 30));

        JButton btnCarrinho = new JButton("Alugar(R$10)");
        btnCarrinho.setFont(new Font("Courier New", Font.BOLD, 16));
        btnCarrinho.setBackground(corDestaque);
        
        if (corDestaque.equals(Color.GREEN) || corDestaque.equals(Color.CYAN) || corDestaque.equals(Color.YELLOW)) {
            btnCarrinho.setForeground(Color.BLACK);
        } else {
            btnCarrinho.setForeground(Color.WHITE);
        }
        
        btnCarrinho.setFocusPainted(false);
        btnCarrinho.setPreferredSize(new Dimension(dimensaoCard.width, 35));

        btnCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (janelaCaixa != null) {
                    janelaCaixa.adicionarFilme(titulo, 10.00);
                    JOptionPane.showMessageDialog(box, titulo + " adicionado ao carrinho!");
                } else {
                    System.out.println("Erro: JanelaCaixa nao configurada.");
                }
            }
        });

        box.add(lblImagem, BorderLayout.NORTH);
        box.add(lblTitulo, BorderLayout.CENTER);
        box.add(btnCarrinho, BorderLayout.SOUTH);

        return box;
    }
}