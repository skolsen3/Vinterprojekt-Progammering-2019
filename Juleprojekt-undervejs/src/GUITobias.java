/*import javax.swing.*;
import java.awt.*;


public class GUITobias {
    public static void main(String[] args) {
        makeFrame();
    }

    public static void makeFrame() {
        JFrame frame = new JFrame("playIT");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        //NORTH
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JButton myListButton = new JButton("Min Liste");
        JButton seriesButton = new JButton("Serier");
        JButton movieButton = new JButton("Film");
        JTextField searchField = new JTextField(16);
        JButton searchButton = new JButton("?");
        JButton userProfileButton = new JButton("(Bruger)");
        northPanel.add(myListButton);
        northPanel.add(seriesButton);
        northPanel.add(movieButton);
        northPanel.add(searchField);
        northPanel.add(searchButton);
        northPanel.add(userProfileButton);

        contentPane.add(northPanel, BorderLayout.NORTH);


        //WEST
        contentPane.add(new JPanel(), BorderLayout.WEST);


        //CENTER
        JPanel centerJPanel = new JPanel();
        contentPane.add(centerJPanel, BorderLayout.CENTER);
        
        centerJPanel.setLayout(new GridLayout());


        //SOUTH
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JLabel rightsLabel = new JLabel("ALL RIGHTS RESERVED. TM & COPYRIGHT");
        southPanel.add(rightsLabel);
        contentPane.add(southPanel, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
    }
}
*/