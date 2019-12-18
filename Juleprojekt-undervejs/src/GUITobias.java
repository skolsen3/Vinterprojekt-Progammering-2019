import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//Har lavet et frame, som fungerer som en login skærm. Der er et felt til at skrive brugernavn, og et felt til adgangskoden.
//

//public class GUITobias{

    /*public static void main (String[] args) {
        JFrame frame = new JFrame("skrt");
    Container contentPane = frame.getContentPane();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
                JPanel leftColumn = new JPanel(new GridLayout(2,1,5,10));
                JPanel rightColumn = new JPanel(new GridLayout(2,1,5,5));
                JLabel userLabel = new JLabel("Brugernavn:");
                JLabel passLabel = new JLabel("Password:");
                JTextField usernameField = new JTextField();
                JTextField passwordField = new JTextField();
                JButton loginButton = new JButton("Login");
                leftColumn.add(userLabel);
                leftColumn.add(passLabel);
                rightColumn.add(usernameField);
                rightColumn.add(passwordField);

                // lidt visuelle tilføjelser.
                usernameField.setColumns(20);
                passwordField.setColumns(20);
                usernameField.setBorder(new LineBorder(Color.DARK_GRAY,1));
                passwordField.setBorder(new LineBorder(Color.DARK_GRAY,1));
                leftColumn.setBackground(Color.LIGHT_GRAY);
                rightColumn.setBackground(Color.LIGHT_GRAY);
                contentPane.setBackground(Color.LIGHT_GRAY);

                contentPane.add(leftColumn);
                contentPane.add(rightColumn);
                contentPane.add(loginButton);

                frame.setSize(1000,1000);
                frame.setVisible(true);

                // hvis man klikker på login og har indtastet de rigtige oplysninger bliver vinduet usynligt
                loginButton.addActionListener(e -> {
                if(usernameField.getText().equals("Dankmemer420") && passwordField.getText().equals("Pepega")){
                frame.setVisible(false);
                }
                });
                }
                }
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
        // Laver et simpelt flowlayout panel med nogle de nødvendige buttons.
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