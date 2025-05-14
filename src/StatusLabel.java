import javax.swing.*;

public class StatusLabel extends JLabel {
    int finished = 0;

    public StatusLabel() {

    }

    public void start() {
        setText("Odliczanie");
    }

    public void finish() {
        // every button can only finish once and then disables itself, so this will work
        finished++;
        if (finished == 3) {
            setText("Koniec");
        }
    }
}
