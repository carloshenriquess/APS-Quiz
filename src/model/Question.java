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
    
    private char alternativeNumberToChar(int num) {
        if (num < 0 || num > 3) {
            throw new IllegalArgumentException("Numero de alternativa deve estar entre 0 e 3");
        }
        switch(num) {
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            case 3:
                return 'D';
            default:
                return ' ';
        }
    }
    
    public enum Alternative {
        A((byte)1), B((byte)2), C((byte)3), D((byte)4);
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
            displayAlternatives[i] = 
                    "<html><p style=\"width:250px;\">"+
                        alternativeNumberToChar(i)+") " + alternatives[i] +
                    "</p></html>";
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
