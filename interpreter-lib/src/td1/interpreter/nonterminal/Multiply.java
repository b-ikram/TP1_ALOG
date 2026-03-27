package td1.interpreter.nonterminal;
import java.util.Map;
import td1.interpreter.core.Expression;

public class Multiply implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    // C'est ce constructeur qui manquait !
    public Multiply(Expression left, Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        return leftOperand.interpret(variables) * rightOperand.interpret(variables);
    }
}