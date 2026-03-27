package td1.calculator;

import javax.swing.SwingUtilities;
import td1.calculator.gui.CalculatorGUI;

public class Main {
    public static void main(String[] args) {
        // Pour Swing, on lance l'interface dans le thread dédié (EDT)
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI gui = new CalculatorGUI();
            gui.setVisible(true); // C'est ici que la fenêtre s'affiche
        });
    }
}