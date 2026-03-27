package td1.calculator.trace;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CalculatorTrace {
    private List<String> historique = new ArrayList<>();
    private final String DATA_PATH = "calculator/data";
    private final String FILE_NAME = "trace_calculs.txt";
    private final String FULL_PATH = DATA_PATH + "/" + FILE_NAME;

    public CalculatorTrace() {
        try {
            Path path = Paths.get(DATA_PATH);
            if (!Files.exists(path)) Files.createDirectories(path);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void ajouterAuLog(String entree) { historique.add(entree); }
    public List<String> getHistorique() { return historique; }

    public void sauvegarder() throws IOException {
        if (!historique.isEmpty()) {
            Files.write(Paths.get(FULL_PATH), historique, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            historique.clear();
        }
    }

    public List<String> chargerToutesLesTraces() throws IOException {
        Path path = Paths.get(FULL_PATH);
        if (!Files.exists(path)) return new ArrayList<>();
        return Files.readAllLines(path);
    }
}