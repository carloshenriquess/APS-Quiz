package storage;

import model.Question;

public class Storage {
    static final String[][] ALTERNATIVES = {
        {
            "<html>Alternativa certa certa certa certa certa certa certa certa certa certa certa certa certa</html>",
            "<html>Alternativa errada errada errada errada errada errada errada errada errada errada errada errada errada</html>",
            "<html>Alternativa errada</html>",
            "<html>Alternativa errada</html>",
        },
        {
            "<html>Alternativa errada errada errada</html>",
            "<html>Alternativa certa certa certa certa certa certa certa certa certa certa certa</html>",
            "<html>Alternativa errada errada errada</html>",
            "<html>Alternativa errada</html>",
        },
        {
            "<html>Alternativa errada</html>",
            "<html>Alternativa errada</html>",
            "<html>Alternativa certa certa certa certa certa certa certa certa certa certa certa certa certa certa certa</html>",
            "<html>Alternativa errada</html>",
        },
    };
    public static final Question[] QUESTIONS = {
        new Question("Pergunta 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1", ALTERNATIVES[0], Question.Alternative.A, 10),
        new Question("Pergunta 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2", ALTERNATIVES[1], Question.Alternative.B, 30),
        new Question("Pergunta 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3", ALTERNATIVES[2], Question.Alternative.C, 50),
    };
}
