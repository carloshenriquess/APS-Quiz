package model;

public class Question {
    private String question;
    private String[] alternatives;
    private Alternative rightAlternative;
    private int points;
    
    public Question(String question, String[] alternatives, Alternative rightAlternative, int points) {
        if (!(alternatives != null && alternatives.length == 4)) {
            throw new IllegalArgumentException("Apenas 4 alternativas permitidas");
        }
        if (rightAlternative == null) {
            throw new IllegalArgumentException("É necessário informar uma resposta correta");
        }

        this.question = question;
        this.alternatives = alternatives;
        this.rightAlternative = rightAlternative;
        this.points = points;
    }
    
    public boolean reply(Alternative alternative) {
        return this.rightAlternative == alternative;
    }
    
    public enum Alternative {
        A((byte)0), B((byte)1), C((byte)2), D((byte)3);
        private final byte value;
        private Alternative(byte value) {
            this.value = value;
        }
        public byte getValue() {
            return value;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String[] alternatives) {
        this.alternatives = alternatives;
    }

    public Alternative getRightAlternative() {
        return rightAlternative;
    }

    public void setRightAlternative(Alternative rightAlternative) {
        this.rightAlternative = rightAlternative;
    }
    
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
}
