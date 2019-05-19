package storage;

import model.Question;

public class Storage {
    static final String[][] ALTERNATIVES = {
        {
            "Alternativa certa certa certa certa certa certa certa certa certa certa certa certa certa",
            "Alternativa errada errada errada errada errada errada errada errada errada errada errada errada errada",
            "Alternativa errada",
            "Alternativa errada",
        },
        {
            "Alternativa errada errada errada",
            "Alternativa certa certa certa certa certa certa certa certa certa certa certa",
            "Alternativa errada errada errada",
            "Alternativa errada",
        },
        {
            "Alternativa errada",
            "Alternativa errada",
            "Alternativa certa certa certa certa certa certa certa certa certa certa certa certa certa certa certa",
            "Alternativa errada",
        },
    };
    public static final Question[] QUESTIONS = {
        new Question(
                "Pergunta 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
                ALTERNATIVES[0],
                Question.Alternative.A,
                100,
                "Dica 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"
        ),
        new Question(
                "Pergunta 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2",
                ALTERNATIVES[1],
                Question.Alternative.B,
                10000,
                " Dica 2 Dica 2 Dica 2 Dica 2"
        ),
        new Question(
                "Pergunta 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3",
                ALTERNATIVES[2],
                Question.Alternative.C,
                10000,
                "Dica 3"
        ),
    };
}
