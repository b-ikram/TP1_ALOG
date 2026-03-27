package td1.calculator.service;

public enum Operation {
    SOMME("a b +"),
    PRODUIT("a b *"),
    FACTORIEL("a !");

    private final String expressionRPN;

    Operation(String expressionRPN) {
        this.expressionRPN = expressionRPN;
    }

    public String getExpressionRPN() {
        return expressionRPN;
    }
}