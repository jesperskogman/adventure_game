import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SloGui {
    private Connection conn;
    private Statement stmt;


    private JPanel panel1;
    private JTextArea textArea1;

    private JButton button1;
    private JButton button2;
    private JButton button3;

    public SloGui() {
        try {
            conn = JdbcAdventure.getConnection();
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText(JdbcAdventure.getStoryBody(stmt,1));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SloGui");
        frame.setContentPane(new SloGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
