package client.interfaz;

import archivo.HelloSocket;
import client.controlador.Controlador;
import archivo.ReadFile;
import javax.swing.*;
import java.awt.*;

public class InterfazApp extends JFrame {

    private PanelChat pnlChat;
    private PanelMsg pnlMsg;
    private PanelTop pnlTop; // Reemplazar PanelTop

    private Controlador ctrl;
    private ReadFile readFile;

    public InterfazApp() {
        setTitle("Chat");
        setSize(480, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(new Color(240, 240, 240)); // Color de fondo neumórfico

        readFile = new ReadFile();

        //Imagen a la barra de tareas
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/icon1.png"));
        Image image = icon.getImage();
        setIconImage(image);

        // Instanciar los paneles
        pnlTop = new PanelTop(); // Crear PanelTop en el que está el pnlIP  y pnlNick
        pnlChat = new PanelChat();
        ctrl = new Controlador(pnlChat);
        pnlMsg = new PanelMsg(pnlChat, ctrl);

        // Agregar paneles
        add(pnlTop, BorderLayout.NORTH);
        add(pnlChat, BorderLayout.CENTER);
        add(pnlMsg, BorderLayout.SOUTH);

        ctrl.conectar(readFile, pnlTop.getPanelIp(), pnlTop.getPanelNick());
        ctrl.cargarConfiguracion();

        setVisible(true);
    }

    public static void main(String[] args) {
        new InterfazApp();
    }
}
