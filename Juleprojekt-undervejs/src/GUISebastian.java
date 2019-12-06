import javax.swing.*;
import java.awt.*;


/**
 * ImageViewer is the main class of the image viewer application. It builds
 * and displays the application GUI.
 * <p>
 * To start the application, create an object of this class.
 *
 * @author Michael Kölling and David J. Barnes.
 * @version 0.2
 */



public class GUISebastian {
    private JFrame frame;


    public GUISebastian() {
        makeFrame();
    }
    public static void main(String[] args) {
        GUISebastian sebber = new GUISebastian();
        sebber.makeFrame();
    }
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        frame = new JFrame("SebastiansImageViewer");
        makeMenuBar(frame);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel label = new JLabel("I am a label. I can display some text.");
        contentPane.add(label);

        contentPane.add(new JPanel(), BorderLayout.NORTH);
        contentPane.add(new JPanel(), BorderLayout.SOUTH);
        contentPane.add(new JPanel(), BorderLayout.CENTER);

        JPanel westJPanel = new JPanel();
        contentPane.add(westJPanel, BorderLayout.WEST);

        BoxLayout FirstBox = new BoxLayout(westJPanel, BoxLayout.Y_AXIS);
        westJPanel.setLayout(FirstBox);


        Container westMiniContainer1 = new Container();
        westJPanel.add(westMiniContainer1);
        Container westMiniContainer2 = new Container();
        westJPanel.add(westMiniContainer2);
        Container westMiniContainer3 = new Container();
        westJPanel.add(westMiniContainer3);

        westJPanel.add(new JPanel(), BorderLayout.EAST);
        westJPanel.add(new JPanel(), BorderLayout.CENTER);


        westMiniContainer1.add(new JLabel("genre 1"));
        westMiniContainer2.add(new JLabel("genre 2"));



        // building is done - arrange the components and show
        frame.pack();
        frame.setVisible(true);
    }


     // Create the main frame's menu bar.

    private void makeMenuBar(JFrame frame) {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // create the File menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
    }
}