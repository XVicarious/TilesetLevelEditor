package us.xvicario.vtle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by XVicarious on 9/19/2014.
 */
public class VTLE {

    private static JFileChooser fileChoose;

    private static void createAndShowGUI() {
        final JFrame mainFrame = new JFrame("VTLE");
        JOptionPane tileSelector = new JOptionPane("Tile Selection");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem openMenu = new JMenuItem(new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChoose = new JFileChooser();
                int returnValue = fileChoose.showOpenDialog(mainFrame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    Path path = Paths.get(fileChoose.getSelectedFile().toURI());
                    JTextField xField = new JTextField(5);
                    JTextField yField = new JTextField(5);
                    JPanel dialog = new JPanel();
                    dialog.add(new JLabel("x:"));
                    dialog.add(xField);
                    dialog.add(Box.createHorizontalStrut(15));
                    dialog.add(new JLabel("y:"));
                    dialog.add(yField);
                    int result = JOptionPane.showConfirmDialog(null, dialog, "Enter the width and height of the map", JOptionPane.OK_CANCEL_OPTION);
                }
            }
        });
        fileMenu.add(openMenu);
        menuBar.add(fileMenu);
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200, 20));
        mainFrame.setJMenuBar(menuBar);
        mainFrame.pack();
        mainFrame.setVisible(true);
        for (int i = 0; i < 20; i++) {
            System.out.println("" + Math.ceil(i / 2));
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
