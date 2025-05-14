import java.awt.*;

public class DecrementMenuItem extends MenuItem {
    private int value;
    public DecrementMenuItem(int value) throws HeadlessException {
        super(value + "");
        this.value = value;
    }

    public void setEnabledIcon() {
        setLabel(value + " ✔");
    }

    public void setDisabledIcon() {
        setLabel(value + "");
    }

    public int getValue() {
        return value;
    }
}
