import javax.swing.*;

public class SloGui {

    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SloGui");
        frame.setContentPane(new SloGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
