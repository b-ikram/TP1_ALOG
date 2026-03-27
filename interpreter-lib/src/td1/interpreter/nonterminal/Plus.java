package td1.interpreter.nonterminal;
import td1.interpreter.core.Expression;
import java.util.Map;

public class Plus implements Expression {
    Expression left, right;
    public Plus(Expression l, Expression r) { left = l; right = r; }
    public int interpret(Map<String, Expression> variables) {
        return left.interpret(variables) + right.interpret(variables);
    }
}