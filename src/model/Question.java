package model;

public class Question {
    private String question;
    private String[] alternatives;
    private Alternative rightAlternative;
    private int points;
    private String tip;
    
    public Question(String question, String[] alternatives, Alternative rightAlternative, int points, String tip) {
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
        this.tip = tip;
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

    public String[] getAlternatives() {
        String[] displayAlternatives = new String[4];
        for (int i = 0; i < 4; i++) {
            displayAlternatives[i] = "<html><p style=\"width:250px;\">" + this.alternatives[i] + "</p></html>";
        }
        return displayAlternatives;
    }

    public Alternative getRightAlternative() {
        return rightAlternative;
    }
    
    public int getPoints() {
        return points;
    }
    
    public String getTip() {
        return "<html><p style=\"width:300px;\">"+tip+"</p></html>";
    }
}
