import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownButton extends JButton implements ActionListener, Runnable {
    private int counter;

    public void setCounter(int value) {
        counter = value;
        if (counter < 0) counter = 0;
        timerLabel.setText("" + counter);
    }

    private int decrement;
    private double period;
    private Thread thread;
    private final JLabel timerLabel;
    private final StatusLabel statusLabel;

    public CountdownButton(JLabel timerLabel, StatusLabel statusLabel, int decrement, double period) {
        super("START");
        this.timerLabel = timerLabel;
        this.statusLabel = statusLabel;
        setCounter(10);
        this.decrement = decrement;
        this.period = period;
        addActionListener(this);
    }

    @Override
    public void run() {
        statusLabel.start();
        try {
            while (counter > 0) {
                Thread.sleep(Math.round(1000 * period));
                if (Thread.interrupted()) throw new InterruptedException();
                setCounter(counter - decrement);
            }
        } catch (InterruptedException e) {
            return;
        }
        statusLabel.finish();
        setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
            setText("STOP");
        } else {
            thread.interrupt();
            thread = null;
            setText("START");
        }
    }
}
