package td1.calculator.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import td1.calculator.service.CalculatorService;

public class CalculatorGUI extends JFrame {
    private JTextField txtN1, txtN2;
    private JLabel lblRes;
    private CalculatorService service = new CalculatorService();

    public CalculatorGUI() {
        setTitle("TP ALOG - Calculatrice");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblHeader = new JLabel("LES FORMES ET LES VUES");
        lblHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(lblHeader);
        mainPanel.add(Box.createVerticalStrut(5));

        mainPanel.add(new JSeparator());
        mainPanel.add(Box.createVerticalStrut(15));

        JPanel pnlInputs = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        txtN1 = new JTextField(6);
        txtN2 = new JTextField(6);
        pnlInputs.add(new JLabel("Nombre 1")); 
        pnlInputs.add(txtN1);
        pnlInputs.add(new JLabel("Nombre 2")); 
        pnlInputs.add(txtN2);
        mainPanel.add(pnlInputs);
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(new JSeparator());
        mainPanel.add(Box.createVerticalStrut(15));

        JPanel pnlOps = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton bSomme = new JButton("SOMME");
        JButton bProd = new JButton("PRODUIT");
        JButton bFact = new JButton("FACTORIEL");
        pnlOps.add(bSomme); pnlOps.add(bProd); pnlOps.add(bFact);
        mainPanel.add(pnlOps);
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(new JSeparator());
        mainPanel.add(Box.createVerticalStrut(15));

       
        JPanel pnlResTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlResTitle.setBorder(new EmptyBorder(0, 155, 0, 0)); 
        JLabel lblResultats = new JLabel("RESULTATS");
        lblResultats.setFont(new Font("Arial", Font.BOLD, 14));
        pnlResTitle.add(lblResultats);
        mainPanel.add(pnlResTitle);

        lblRes = new JLabel("...........", SwingConstants.CENTER);
        lblRes.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblRes.setFont(new Font("Monospaced", Font.BOLD, 16));
        mainPanel.add(lblRes);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(new JSeparator());
        mainPanel.add(Box.createVerticalStrut(20));

        // 9. Boutons du bas (QUITTER et TRACE)
        JPanel pnlBottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        JButton bQuitter = new JButton("QUITTER");
        JButton bTrace = new JButton("TRACE");
        pnlBottom.add(bQuitter); pnlBottom.add(bTrace);
        mainPanel.add(pnlBottom);

        add(mainPanel, BorderLayout.CENTER);

        bSomme.addActionListener(e -> lblRes.setText(service.calculer("SOMME", txtN1.getText(), txtN2.getText())));
        bProd.addActionListener(e -> lblRes.setText(service.calculer("PRODUIT", txtN1.getText(), txtN2.getText())));
        bFact.addActionListener(e -> lblRes.setText(service.calculer("FACTORIEL", txtN1.getText(), "")));
       // Action pour QUITTER
        bQuitter.addActionListener(e -> System.exit(0));

        bTrace.addActionListener(e -> {
            java.util.List<String> logs = service.getHistorique();
            if (logs.isEmpty()) {
                JOptionPane.showMessageDialog(this, "La trace est vide. Faites un calcul d'abord !");
            } else {
                String message = String.join("\n", logs);
                JOptionPane.showMessageDialog(this, message, "Trace des opérations", JOptionPane.INFORMATION_MESSAGE);
                
                try {
                    service.sauvegarderTrace();
                    System.out.println("Trace sauvegardée dans le fichier.");
                } catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}