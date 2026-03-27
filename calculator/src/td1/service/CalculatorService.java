package td1.calculator.service;

import td1.interpreter.core.Evaluator;
import td1.interpreter.terminal.Number;
import td1.interpreter.core.Expression;
import td1.calculator.trace.CalculatorTrace; 
import java.io.*;
import java.util.*;

public class CalculatorService {
    private CalculatorTrace traceModule = new CalculatorTrace();

    // Utilisation de l'objet Operation au lieu d'une String
    public String calculer(Operation op, String val1, String val2) {
        try {
            int n1 = Integer.parseInt(val1);
            Map<String, Expression> vars = new HashMap<>();
            vars.put("a", new Number(n1));
            
            // On récupère l'expression RPN et le symbole depuis l'Enum
            String expressionStr = op.getExpressionRPN();
            String symbole = op.getSymbole();
            String log = "";

            if (op != Operation.FACTORIEL) {
                // Opérations binaires (Somme, Produit)
                int n2 = Integer.parseInt(val2);
                vars.put("b", new Number(n2));
                int res = new Evaluator(expressionStr).interpret(vars);
                log = n1 + " " + symbole + " " + n2 + " = " + res;
            } else {
                // Opération unaire (Factoriel)
                int res = new Evaluator(expressionStr).interpret(vars);
                log = n1 + symbole + " = " + res;
            }

            traceModule.ajouterAuLog(log);
            
            // On retourne uniquement le résultat après le "="
            return log.split("=")[1].trim();
            
        } catch (Exception e) {
            return "Erreur";
        }
    }

    // --- Reste des méthodes inchangé ---
    public void sauvegarderTrace() throws IOException {
        traceModule.sauvegarder();
    }

    public String chargerDerniereTrace() throws IOException {
        return traceModule.chargerDerniere();
    }

    public List<String> getHistorique() { 
        return traceModule.getHistorique(); 
    }

    public List<String> obtenirTouteLaTrace() throws IOException {
        sauvegarderTrace(); 
        return traceModule.lireToutLeFichier();
    }
}