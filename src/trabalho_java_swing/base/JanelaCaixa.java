package trabalho_java_swing.base;

import javax.swing.*;
import java.awt.*;

public class JanelaCaixa extends JPanel {

    private DefaultListModel<String> modeloLista;
    private JList<String> listaDeProdutos;
    private JLabel labelTotal;
    private double valorTotal;
    private Image imagemFundo;

    public JanelaCaixa() {
        setLayout(new BorderLayout());

        try {
            imagemFundo = new ImageIcon("imagens/caixa.jpg").getImage();
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem de fundo do caixa");
        }

        modeloLista = new DefaultListModel<>();
        listaDeProdutos = new JList<>(modeloLista);
        listaDeProdutos.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JScrollPane scrollPane = new JScrollPane(listaDeProdutos);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        listaDeProdutos.setBackground(new Color(255, 255, 255, 200)); 
        
        scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 50));

        add(scrollPane, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        painelInferior.setOpaque(false);

        labelTotal = new JLabel("Total: R$ 0.00");
        labelTotal.setFont(new Font("Arial", Font.BOLD, 24));
        labelTotal.setForeground(Color.WHITE); 

        JButton btnPagar = new JButton("Pagar");
        btnPagar.setFont(new Font("Arial", Font.BOLD, 18));
        btnPagar.setBackground(new Color(0, 200, 0));
        btnPagar.setForeground(Color.WHITE);
        btnPagar.setFocusPainted(false);
        btnPagar.setPreferredSize(new Dimension(150, 40));

        btnPagar.addActionListener(e -> {
            if (modeloLista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O carrinho está vazio!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Obrigado pela compra!\nVolte sempre.");
                modeloLista.clear();
                valorTotal = 0;
                labelTotal.setText("Total: R$ 0.00");
            }
        });

        painelInferior.add(labelTotal);
        painelInferior.add(btnPagar);

        add(painelInferior, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void adicionarFilme(String nome, double preco) {
        modeloLista.addElement(nome + " - R$ " + String.format("%.2f", preco));
        valorTotal += preco;
        labelTotal.setText("Total: R$ " + String.format("%.2f", valorTotal));
    }
}