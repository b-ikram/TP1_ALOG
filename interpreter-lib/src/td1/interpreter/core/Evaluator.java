package td1.interpreter.core;
import td1.interpreter.terminal.*;
import td1.interpreter.nonterminal.*;
import java.util.*;

public class Evaluator implements Expression {
    private Expression syntaxTree;

    public Evaluator(String expression) {
        Stack<Expression> stack = new Stack<>();
        for (String token : expression.split(" ")) {
            if (token.equals("+")) {
                stack.push(new Plus(stack.pop(), stack.pop()));
            } else if (token.equals("*")) {
                stack.push(new Multiply(stack.pop(), stack.pop()));
            } else if (token.equals("!")) {
                stack.push(new Factoriel(stack.pop()));
            } else {
                stack.push(new Variable(token));
            }
        }
        syntaxTree = stack.pop();
    }

    public int interpret(Map<String, Expression> context) {
        return syntaxTree.interpret(context);
    }
}