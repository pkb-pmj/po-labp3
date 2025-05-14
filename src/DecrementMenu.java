import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecrementMenu extends Menu implements ActionListener {
    DecrementMenuItem i5;
    DecrementMenuItem i10;
    DecrementMenuItem i20;
    CountdownButton[] buttons;

    public DecrementMenu(String label, CountdownButton[] buttons) throws HeadlessException {
        super(label);
        this.buttons = buttons;
        i5 = new DecrementMenuItem(5);
        i10 = new DecrementMenuItem(10);
        i20 = new DecrementMenuItem(20);
        i5.addActionListener(this);
        i10.addActionListener(this);
        i20.addActionListener(this);
        add(i5);
        add(i10);
        add(i20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        i5.setDisabledIcon();
        i10.setDisabledIcon();
        i20.setDisabledIcon();
        DecrementMenuItem source = (DecrementMenuItem) e.getSource();
        source.setEnabledIcon();
        int startValue = source.getValue();
        for (CountdownButton button : buttons) {
            button.setCounter(startValue);
        }
    }
}
