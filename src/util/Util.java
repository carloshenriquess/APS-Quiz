package util;

import javax.swing.JFrame;

public class Util {
    private Util() {}
    
    // POLIMORFISMO
    public static void toFrame(JFrame from, JFrame to) {
        from.setVisible(false);
        to.setVisible(true);
    }
}
