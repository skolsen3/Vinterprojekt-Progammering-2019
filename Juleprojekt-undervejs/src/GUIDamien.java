import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


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

        GridLayout centerGrid = new GridLayout(0, 5);
        centerJPanel.setLayout(centerGrid);

        // BufferedImage myPicture = ImageIO.read(new File("path-to-file"));
        //JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        //add(picLabel);

        for(int i = 1; i<=1000; i++) {
            JButton funButton = new JButton();

            centerJPanel.add(funButton);
        }


        contentPane.add(centerJScrollPane, BorderLayout.CENTER);



        //SOUTH
        JButton southJButton = new JButton();
        contentPane.add(southJButton, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
    }
}
