package client.interfaz;

import client.controlador.Controlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.geom.RoundRectangle2D;

public class PanelMsg extends JPanel implements ActionListener {

    private RoundedTextField txtFieldEnviar;
    private RoundedButton bttnEnviar;
    private PanelChat pnlChat;
    private Controlador ctrl;

    public PanelMsg(PanelChat panelChat, Controlador ctrl) {
        this.ctrl = ctrl;
        this.pnlChat = panelChat;

        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 240));
        setBorder(null);
        

        txtFieldEnviar = new RoundedTextField(20);
        txtFieldEnviar.setFont(new Font("Arial", Font.PLAIN, 14));
        txtFieldEnviar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtFieldEnviar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enviar"));
                }
            }
        });

        bttnEnviar = new RoundedButton("Enviar");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enviar")) {
            String message = getMessage();
            pnlChat.addMessage("Me: " + message);
            ctrl.socket(message);
            clearMessage();
        }
    }

    // Clase personalizada para el campo de texto redondeado
    private class RoundedTextField extends JTextField {

        private Shape shape;

        public RoundedTextField(int size) {
            super(size);
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(new Color(238, 237, 239));
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 35, 35);
            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(new Color(0, 0, 0, 50));
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 35, 35);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }

    // Clase personalizada para el botón redondeado
    private class RoundedButton extends JButton {

        public RoundedButton(String label) {
            super(label);
            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
        }

        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(getBackground().darker());
            } else {
                g.setColor(getBackground());
            }
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 35, 35);
            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 35, 35);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            }
            return shape.contains(x, y);
        }

        private Shape shape;
    }
}
