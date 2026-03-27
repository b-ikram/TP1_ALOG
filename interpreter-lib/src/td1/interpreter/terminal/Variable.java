package td1.interpreter.terminal;
import java.util.Map;
import td1.interpreter.core.Expression;

public class Variable implements Expression {
    private String name;

    // Ce constructeur permet de stocker le nom de la variable (ex: "a" ou "b")
    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Map<String, Expression> variables) {
        if (variables.get(name) == null) return 0;
        return variables.get(name).interpret(variables);
    }
}