package client.interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelChat extends JPanel {

    private JTextArea txtArena;

    public PanelChat() {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 240));
        setBorder(null);

        txtArena = new JTextArea();
        txtArena.setEditable(false);
        txtArena.setFont(new Font("Arial", Font.PLAIN, 14));
        txtArena.setLineWrap(true);
        txtArena.setWrapStyleWord(true);
        txtArena.setOpaque(false);
        txtArena.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrlChat = new JScrollPane(txtArena);
        scrlChat.setBorder(null);
        scrlChat.setOpaque(false);
        scrlChat.getViewport().setOpaque(false);
        
        add(scrlChat, BorderLayout.CENTER);
    }

    public void addMessage(String message) {
        txtArena.append(message + "\n");
        txtArena.setCaretPosition(txtArena.getDocument().getLength());
    }
}