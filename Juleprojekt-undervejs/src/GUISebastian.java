import javax.swing.*;
import javax.swing.border.Border;
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



        contentPane.add(new JPanel(), BorderLayout.NORTH);
        JLabel northLabel = new JLabel("This is the northLabel");
        contentPane.add(northLabel,BorderLayout.NORTH);

        contentPane.add(new JPanel(), BorderLayout.SOUTH);
        JLabel southLabel = new JLabel("This is the southLabel");
        contentPane.add(southLabel,BorderLayout.SOUTH);

        contentPane.add(new JPanel(), BorderLayout.CENTER);
        JLabel centerLabel = new JLabel("This is the centerLabel");
        contentPane.add(centerLabel,BorderLayout.CENTER);

        JPanel westJPanel = new JPanel();
        contentPane.add(westJPanel, BorderLayout.WEST);


        westJPanel.setLayout(new BoxLayout(westJPanel, BoxLayout.Y_AXIS));

        westJPanel.add(new JLabel("This is the west Label"));
        /*
        Container westMiniContainer1 = new Container();
        westMiniContainer1.add(new JLabel("genre 1"), BorderLayout.CENTER);
        westJPanel.add(westMiniContainer1);
        Container westMiniContainer2 = new Container();
        westJPanel.add(westMiniContainer2);
        Container westMiniContainer3 = new Container();
        westJPanel.add(westMiniContainer3);

        westMiniContainer1.add(new JPanel(), BorderLayout.EAST);
        westMiniContainer1.add(new JPanel(), BorderLayout.CENTER);



        westMiniContainer2.add(new JLabel("genre 2"));

*/

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