import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GUIDamien {
    public static void main(String[] args) {
        makeFrame();
    }
    public static void makeFrame() {
        JFrame frame = new JFrame("playIT");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        //NORTH
        JButton northButton = new JButton("North");
        contentPane.add(northButton, BorderLayout.NORTH);


        //WEST
        JButton westButton = new JButton("West");
        contentPane.add(westButton, BorderLayout.WEST);


        //CENTER
        JPanel centerJPanel = new JPanel();
        JScrollPane centerJScrollPane = new JScrollPane(centerJPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        GridLayout centerGrid = new GridLayout(0, 7);
        centerJPanel.setLayout(centerGrid);

        SearchEngine searchEngine = new SearchEngine();


        for(Media m : searchEngine.getLibrary()) {
            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new BorderLayout());

            JLabel picLabel = new JLabel(new ImageIcon(m.getPictureFile()));
            gridPanel.add(picLabel, BorderLayout.CENTER);

            JTextArea textLabel = new JTextArea(m.getName() + " (" + m.getYear() + ")");
            textLabel.setLineWrap(true);
            gridPanel.add(textLabel, BorderLayout.SOUTH);

            centerJPanel.add(gridPanel);
        }




        contentPane.add(centerJScrollPane, BorderLayout.CENTER);



        //SOUTH
        JButton southJButton = new JButton("South");
        contentPane.add(southJButton, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
    }
}
