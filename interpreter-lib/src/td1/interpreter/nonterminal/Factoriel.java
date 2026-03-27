package td1.interpreter.nonterminal;
import td1.interpreter.core.Expression;
import java.util.Map;

public class Factoriel implements Expression {
    Expression operand;
    public Factoriel(Expression op) { this.operand = op; }
    public int interpret(Map<String, Expression> variables) {
        int n = operand.interpret(variables);
        int res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        return res;
    }
}