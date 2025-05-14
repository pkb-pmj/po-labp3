import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Okno extends JFrame {
    private CountdownButton b1;
    private CountdownButton b2;
    private CountdownButton b3;
    public Okno() {
        super("Odliczanie");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        JLabel t1 = new JLabel();
        JLabel t2 = new JLabel();
        JLabel t3 = new JLabel();
        StatusLabel l = new StatusLabel();
        b1 = new CountdownButton(t1, l, 1, 0.5);
        b2 = new CountdownButton(t2, l, 1, 1.0);
        b3 = new CountdownButton(t3, l, 2, 1.0);

        MenuBar mb = new MenuBar();
        Menu edit = new DecrementMenu("Edit", new CountdownButton[] {b1, b2, b3});
        mb.add(edit);
        setMenuBar(mb);

        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createTitledBorder("Przyciski"));
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        add(buttons, BorderLayout.PAGE_START);

        JPanel timers = new JPanel();
        timers.setBorder(BorderFactory.createTitledBorder("Liczniki"));
        timers.add(t1);
        timers.add(t2);
        timers.add(t3);
        add(timers, BorderLayout.CENTER);

        JPanel labels = new JPanel();
        labels.setBorder(BorderFactory.createTitledBorder("Etykiety"));
        labels.add(l);
        add(labels, BorderLayout.PAGE_END);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Okno();
    }
}
