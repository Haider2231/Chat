package client.interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelTop extends JPanel {
    private PanelIp pnlIP;
    private PanelNick pnlNick;
    private JLabel lblAvatar;       

    public PanelTop() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Vertical layout
        setBackground(new Color(240, 240, 240));

        // Instanciar los paneles
        pnlIP = new PanelIp();
        pnlNick = new PanelNick();

        // Cargar imagen de avatar
        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/resources/icon6.png"));
        Image avatarImage = avatarIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Redimensionar imagen
        lblAvatar = new JLabel(new ImageIcon(avatarImage));
        lblAvatar.setPreferredSize(new Dimension(45, 45)); // Tamaño del avatar
        lblAvatar.setBackground(new Color(207, 216, 223));
        lblAvatar.setOpaque(true);
        
//        ImageIcon avatarIcon = new ImageIcon(getClass().getResource("/resources/icon5.png"));
//        lblAvatar = new JLabel(avatarIcon);
//        lblAvatar.setPreferredSize(new Dimension(48, 48)); // Tamaño del avatar
//        add(lblAvatar); // Agregar el JLabel al PanelTop
        
        // Agregar paneles y labels al PanelTop
        add(lblAvatar);
        add(pnlNick);
        add(pnlIP);
    }

    public PanelIp getPanelIp() {
        return pnlIP;
    }

    public PanelNick getPanelNick() {
        return pnlNick;
    }
}

