package client.interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelNick extends JPanel {

    private JTextField txtFieldNick;
    private JLabel lblNick;

    public PanelNick() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(255, 255, 255, 240));

        lblNick = new JLabel("Nick:");
        txtFieldNick = new JTextField(15);
        txtFieldNick.setEditable(false);
        txtFieldNick.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        add(lblNick);
        add(txtFieldNick);
    }

    public void setNick(String nick) {
        txtFieldNick.setText(nick);
    }
}
