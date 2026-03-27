package td1.interpreter.core;
import java.util.Map;

public interface Expression {
    int interpret(Map<String, Expression> variables);
}