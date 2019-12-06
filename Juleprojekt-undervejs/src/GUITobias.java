import javax.swing.*;
import java.awt.*;


public class GUITobias {
    private JFrame frame;
    public void makeFrame() {
        frame = new JFrame("playIT");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        //NORTH
        contentPane.add(new JPanel(), BorderLayout.NORTH);


        //WEST
        contentPane.add(new JPanel(), BorderLayout.WEST);


        //CENTER
        JPanel centerJPanel = new JPanel();
        contentPane.add(centerJPanel, BorderLayout.CENTER);
        
        centerJPanel.setLayout(new GridLayout());


        //SOUTH
        contentPane.add(new JPanel(), BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
    }
}
