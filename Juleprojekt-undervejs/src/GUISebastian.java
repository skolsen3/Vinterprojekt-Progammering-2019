/*
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;


/**
 * ImageViewer is the main class of the image viewer application. It builds
 * and displays the application GUI.
 * <p>
 * To start the application, create an object of this class.
 *
 * @author Michael Kölling and David J. Barnes.
 * @version 0.2
 */
/*


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

    private void makeFrame() {
        frame = new JFrame("SebastiansImageViewer");
        makeMenuBar(frame);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());


    // Nedenfor laves den store contentPane, som senere bliver fyldt ud med Damiens og Tobias arbejde
        contentPane.add(new JPanel(), BorderLayout.NORTH);
        JLabel northLabel = new JLabel("This is the northLabel");
        JLabel northLabel2 = new JLabel("This is the second northLabel");
        contentPane.add(northLabel,BorderLayout.NORTH);
        contentPane.add(northLabel2,BorderLayout.NORTH);

        contentPane.add(new JPanel(), BorderLayout.SOUTH);
        JLabel southLabel = new JLabel("This is the southLabel");
        contentPane.add(southLabel,BorderLayout.SOUTH);

        contentPane.add(new JPanel(), BorderLayout.CENTER);
        JLabel centerLabel = new JLabel("This is the centerLabel");
        contentPane.add(centerLabel,BorderLayout.CENTER);


        //Nedenfor laves JPanel'et i West, som senere kommer til at indeholde nogle mindre paneler
        JPanel westJPanel = new JPanel();
        contentPane.add(westJPanel, BorderLayout.WEST);

        //JPanel'et bliver lavet som vertikalt boxlayout, det er her hhv kategorier og checkboxe kommer til at stå under hinanden
        westJPanel.setLayout(new BoxLayout(westJPanel, BoxLayout.Y_AXIS));

        //add'er et mini Panel som ligger inde i westPanel'et, panelet er i center og skal indeholde en titel
        Panel miniPanel1Center = new Panel();
        westJPanel.add(miniPanel1Center,BorderLayout.CENTER);
        //add'er endnu et mini panel som står til højre for titlen, og skal indeholde en checkbox
        Panel miniPanel1East = new Panel();
        westJPanel.add(miniPanel1East,BorderLayout.EAST);
        Panel miniPanel2East = new Panel();
        westJPanel.add(miniPanel2East,BorderLayout.EAST);



        //Jeg laver et array af genre som eksempel, for at vise hvordan vi kan autogenerere sortering for nye genrer
        //Det kræver blot at vi har en liste af genrer, den kan vi generere på flere forskellige måder.


        ArrayList<String> genreList = new ArrayList();
        genreList.add("Gysere");
        genreList.add("Krimier");
        genreList.add("Kærlighedsfilm");

        for(String s : genreList){
            westJPanel.add(new JCheckBox(s));
        }




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
*/