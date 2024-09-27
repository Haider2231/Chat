package client.interfaz;

import client.controlador.Controlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class PanelMsg extends JPanel implements ActionListener {

    private JTextField txtFieldEnviar;
    private JButton bttnEnviar;
    private PanelChat pnlChat;
    private Controlador ctrl;

    public PanelMsg(PanelChat panelChat, Controlador ctrl) {
        this.ctrl = ctrl;
        this.pnlChat = panelChat;
        
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 240)); 

        txtFieldEnviar = new JTextField();
        txtFieldEnviar.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldEnviar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        
        txtFieldEnviar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        bttnEnviar = new JButton("Enviar");
        bttnEnviar.setBackground(new Color(0, 123, 255));
        bttnEnviar.setForeground(Color.WHITE);
        bttnEnviar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bttnEnviar.addActionListener(this);

        add(txtFieldEnviar, BorderLayout.CENTER);
        add(bttnEnviar, BorderLayout.EAST);
    }

    public String getMessage() {
        return txtFieldEnviar.getText();
    }

    public void clearMessage() {
        txtFieldEnviar.setText("");
    }

    private void sendMessage() {
        String message = getMessage();
        if (!message.trim().isEmpty()) {
            pnlChat.addMessage("Me: " + message);
            ctrl.socket(message);
            clearMessage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enviar")) {
            sendMessage();
        }
    }
}
 
