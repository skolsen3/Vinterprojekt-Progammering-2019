import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;

/**
 * This class represents the GUI section of the application. It currently holds all the relevant elements to create and run the GUI.
 */

public class View {
    protected static JFrame frame;
    protected ArrayList<JCheckBox> jCheckBoxArrayList;
    protected Controller controller;
    protected JTextField searchField;
    private static String filePath = new File("").getAbsolutePath();

    /**
     * Creates a View-object with a specified Controller-object and initializes the jCheckBoxArrayList.
     *
     * @param controller The specified Controller-object which controls the program.
     */
    public View(Controller controller) {
        this.controller = controller;
        jCheckBoxArrayList = new ArrayList<>();
    }

    /**
     * Runs the login screen GUI of the streaming service. At the moment only checks if the
     * username and password both equals "admin", and if true, closes the login-screen frame
     * and calls runStreamingService().
     *
     * @param genreList An ArrayList of all genres of the media.
     * @param media     An ArrayList of Media objects.
     */
    public void run(ArrayList<Media> media, ArrayList<String> genreList) {
        JFrame loginFrame = new JFrame("Login screen");
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File(filePath + "/biografsæderbaggrundsbillede.jpg"));
            loginFrame.setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage.getScaledInstance((Math.round((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth())), -1, Image.SCALE_SMOOTH), 0, 0, null);
                }
            });
        } catch (IOException e) {
            e.getStackTrace();
        }
        Container loginFrameContentPane = loginFrame.getContentPane();
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrameContentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));

        JPanel upperRow = new JPanel(new GridLayout(1, 2));
        JPanel lowerRow = new JPanel(new GridLayout(1, 2));

        JLabel userLabel = new JLabel("Username: ");
        userLabel.setFont(new Font("Verdana", Font.PLAIN, 26));

        JLabel passLabel = new JLabel("Password: ");
        passLabel.setFont(new Font("Verdana", Font.PLAIN, 26));

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Verdana", Font.PLAIN, 26));

        JTextField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Verdana", Font.PLAIN, 26));


        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Verdana", Font.PLAIN, 26));

        passwordField.addActionListener(e8 -> {
            loginButton.doClick();
        });
        upperRow.add(userLabel);
        upperRow.add(usernameField);
        lowerRow.add(passLabel);
        lowerRow.add(passwordField);

        JLabel loginIcon = new JLabel(new ImageIcon(filePath + "/popcorn-cinema.jpg"));
        loginIcon.setOpaque(false);
        loginIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        upperRow.setAlignmentX(Component.CENTER_ALIGNMENT);
        lowerRow.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelBox.add(loginIcon);
        panelBox.add(upperRow);
        panelBox.add(lowerRow);
        panelBox.add(loginButton);

        loginFrameContentPane.add(panelBox);

        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.setVisible(true);

        //Checks if the username and password both contains "admin". If true, runs the streaming service. If false, throws WrongLoginCredentialsException.
        //Also catches the exception in a try-catch block in the same code, and displays an error dialog if the exception is caught.
        loginButton.addActionListener(login -> {
            try {
                if (usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                    loginFrame.setVisible(false);
                    runStreamingService(media, genreList);
                } else {
                    throw new WrongLoginCredentialsException();
                }
            } catch (WrongLoginCredentialsException e) {
                JOptionPane.showMessageDialog(loginFrame, e.getMessage());
            }
        });
    }

    /**
     * Creates the GUI of the streaming service. Uses the genreList to create an appropriate number of JCheckBoxes, which calls methods in the Controller-object. Also calls the
     * update method to create the BorderLayout.CENTER panel with the media variable.
     *
     * @param genreList An ArrayList of all genres of the media.
     * @param media     An ArrayList of Media objects.
     */
    public void runStreamingService(ArrayList<Media> media, ArrayList<String> genreList) {
        frame = new JFrame("playIT");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File(filePath + "/biografsæderbaggrundsbillede.jpg"));
            frame.setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage.getScaledInstance((Math.round((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth())), -1, Image.SCALE_SMOOTH), 0, 0, null);
                }
            });
        } catch (IOException e) {
            e.getStackTrace();
        }
        Container contentPane = frame.getContentPane();

        contentPane.setLayout(new BorderLayout(0, 0));
        frame.setContentPane(contentPane);

        //NORTH
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 0, 0));
        northPanel.setBorder(BorderFactory.createEmptyBorder());
        JButton myListButton = new JButton("My List");
        myListButton.setFont(new Font("Verdana", Font.PLAIN, 11));

        JButton allMediaButton = new JButton("All media");
        allMediaButton.setFont(new Font("Verdana", Font.PLAIN, 11));

        JButton seriesButton = new JButton("Series");
        seriesButton.setFont(new Font("Verdana", Font.PLAIN, 11));

        JButton movieButton = new JButton("Movies");
        movieButton.setFont(new Font("Verdana", Font.PLAIN, 11));

        searchField = new JTextField(16);
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Verdana", Font.PLAIN, 11));

        JButton userProfileButton = new JButton("User");
        userProfileButton.setFont(new Font("Verdana", Font.PLAIN, 11));

        northPanel.add(myListButton);
        northPanel.add(allMediaButton);
        northPanel.add(seriesButton);
        northPanel.add(movieButton);
        northPanel.add(searchField);
        northPanel.add(searchButton);
        northPanel.add(userProfileButton);

        northPanel.setOpaque(false);

        contentPane.add(northPanel, BorderLayout.NORTH);

        searchButton.addActionListener(e -> {
            controller.searchForString();
        });

        searchField.addActionListener(e7 -> {
            controller.searchForString();
        });

        seriesButton.addActionListener(e1 -> {
            controller.showSeries();
        });
        movieButton.addActionListener(e2 -> {
            controller.showMovies();
        });
        myListButton.addActionListener(e3 -> {
            controller.displayMyList();
        });
        allMediaButton.addActionListener(e6 -> {
            controller.displayAllMedia();
        });

        //WEST
        JPanel westJPanel = new JPanel();
        westJPanel.setBorder(BorderFactory.createEmptyBorder());
        contentPane.add(westJPanel, BorderLayout.WEST);

        westJPanel.setOpaque(false);

        //JPanel'et bliver lavet som vertikalt boxlayout, det er her hhv. checkboxe og kategorier kommer til at stå under hinanden
        westJPanel.setLayout(new BoxLayout(westJPanel, BoxLayout.Y_AXIS));

        //Tilføjer checkboxene
        JButton clearSearchButton = new JButton("Clear Search");
        clearSearchButton.setFont(new Font("Verdana", Font.PLAIN, 11));

        westJPanel.add(clearSearchButton);
        clearSearchButton.addActionListener(e6 -> {
            for (JCheckBox j : jCheckBoxArrayList) {
                if (j.isSelected()) {
                    j.doClick();
                }
            }

            controller.clearSearch();
        });

        for (String s : genreList) {
            JCheckBox tempBoxReference = new JCheckBox(s);
            tempBoxReference.setOpaque(false);
            tempBoxReference.setFont(new Font("Verdana", Font.BOLD, 11));
            tempBoxReference.setForeground(Color.white);
            westJPanel.add(tempBoxReference);
            jCheckBoxArrayList.add(tempBoxReference);

            tempBoxReference.addActionListener(e -> {
                controller.searchByGenre();
            });
        }

        //SOUTH
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        JLabel rightsLabel = new JLabel("ALL RIGHTS RESERVED. TM & COPYRIGHT");
        rightsLabel.setFont(new Font("Verdana", Font.PLAIN, 8));
        rightsLabel.setForeground(Color.white);

        southPanel.add(rightsLabel);
        southPanel.setBackground(Color.black);
        contentPane.add(southPanel, BorderLayout.SOUTH);

        //CENTER
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        update(media);

    }

    /**
     * Returns the current ArrayList of JCheckBoxes.
     */
    public ArrayList<JCheckBox> getJCheckBoxArrayList() {
        return jCheckBoxArrayList;
    }

    /**
     * Returns the String of text in the searchField.
     */
    public String getSearchField() {
        return searchField.getText();
    }

    /**
     * Creates and/or updates the current BorderLayout.CENTER panel by creating media panels (in code: gridPanel) for each of the Media objects given by the media parameter.
     * A media panel is created with information from the get-methods from the Media-class, loading the medias BufferedImage field as a JButton. The JButton is then given the actionPerformed method
     * of creating and displaying a new frame with a play-button, other relevant buttons, and information about the specific media.
     *
     * @param media An ArrayList of Media objects.
     */
    public void update(ArrayList<Media> media) {

        JPanel centerJPanel = new JPanel();
        centerJPanel.setBorder(BorderFactory.createEmptyBorder());
        centerJPanel.setOpaque(false);
        JScrollPane centerJScrollPane = new JScrollPane(centerJPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerJScrollPane.setOpaque(false);
        centerJScrollPane.getViewport().setOpaque(false);
        centerJScrollPane.setBorder(BorderFactory.createEmptyBorder());

        //Her bruges WrapLayout klassen, som er en klasse vi har inkluderet i projektet, og som er fundet på nettet. Den extender FlowLayout,
        //og "wrapper" teksten således at medierne tilpasser sig, når man resizer frame. Constructoren tager en "alignment" man tager direkte fra flowlayout
        // som i det her tilfælde er FlowLayout.LEADING, sådan at medierne placeres venstre-mod-højre og ikke centreres, hvis der en sidste række med
        // færre medier end de forrige rækker.
        centerJPanel.setLayout(new WrapLayout(FlowLayout.LEADING));



        /*Hele den her for-løkke gennemløber medierne i søgemaskinens library. Den opretter medierne, tilføjer billederne til medierne, tilføjer "knapper" så man kan trykke på medierne,
        * og desuden tilføjer en label der viser filmens titel under billedet. Knapperne, som vises som mediernes respektive billeder, får funktionen at åbne et nyt frame,
        * med information om filmen, en play-knap, en tilføj-til-min-liste-knap, og en fjern-fra-min-liste-knap.
        */
        for (Media m : media) {
            JPanel gridPanel = new JPanel();
            gridPanel.setOpaque(false);

            //Jeg sætter billedet sammen med en textLabel i et vertikalt BoxLayout, sådan så jeg sørger for, at der aldrig kommer luft mellem billede og tekst.
            BoxLayout boxLayout = new BoxLayout(gridPanel, BoxLayout.Y_AXIS);

            gridPanel.setLayout(boxLayout);

            //Billedet hentes direkte fra medie-objektet og bliver sat som ikon til en JButton, så man kan trykke på den.
            JButton picButton = new JButton(new ImageIcon(m.getPictureFile()));
            picButton.setOpaque(false);
            //Billedet åbner et nyt frame, henter information om mediet direkte fra objektet, og opretter en playknap :)

            picButton.addActionListener(e -> {
                        JFrame mediaFrame = new JFrame(m.getName());

                        //Skalerer framet, så det ser pænere ud
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                        int frameHeight = screenSize.height * 1 / 2;
                        int frameWidth = screenSize.width * 1 / 2;

                        mediaFrame.setPreferredSize(new Dimension(frameWidth, frameHeight));

                        Container mediaContentPane = mediaFrame.getContentPane();

                        mediaContentPane.setLayout(new BorderLayout());

                        //Skalering af billede, så det passer med sit frame
                        int picWidth = m.getPictureFile().getWidth();
                        int picHeight = m.getPictureFile().getHeight();
                        double picAspectRatio = (picWidth + 0.0) / (picHeight + 0.0);
                        picHeight = frameHeight;
                        double newPicWidth = picAspectRatio * picHeight;


                        JLabel picture = new JLabel(new ImageIcon(new ImageIcon(m.getPictureFile()).getImage().getScaledInstance((int) newPicWidth, picHeight, Image.SCALE_SMOOTH)));

                        mediaContentPane.add(picture, BorderLayout.WEST);

                        JPanel aboutPanel = new JPanel();
                        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));

                        JLabel aboutLabel = new JLabel("About: ");
                        aboutLabel.setFont(new Font("Verdana", Font.PLAIN, 12));

                        aboutPanel.add(aboutLabel);

                        aboutPanel.add(new JLabel("   "));

                        JLabel titleLabel = new JLabel("Title: " + m.getName());
                        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 12));

                        aboutPanel.add(titleLabel);

                        JLabel yearLabel = new JLabel("Year: " + m.getYear());
                        yearLabel.setFont(new Font("Verdana", Font.PLAIN, 12));

                        aboutPanel.add(yearLabel);

                        String genresAbout = "Genres: ";
                        for (int i = 0; i < m.getGenres().length - 1; i++) {
                            genresAbout = genresAbout + m.getGenres()[i] + ", ";
                        }
                        genresAbout = genresAbout + m.getGenres()[m.getGenres().length - 1];

                        JLabel genresAboutLabel = new JLabel(genresAbout);
                        genresAboutLabel.setFont(new Font("Verdana", Font.PLAIN, 12));

                        aboutPanel.add(genresAboutLabel);

                        JLabel ratingLabel = new JLabel("Rating: " + m.getRating());
                        ratingLabel.setFont(new Font("Verdana", Font.PLAIN, 12));

                        aboutPanel.add(ratingLabel);

                        mediaContentPane.add(aboutPanel, BorderLayout.CENTER);

                        //nogle knapper. en playknap, og to knapper, som kan tilføje eller fjerne film fra mylist. smider det hele ind i et boxlayout

                        JButton playButton = new JButton("Play");
                        playButton.addActionListener(ex -> {
                            if (playButton.getBackground() == Color.GREEN) {
                                playButton.setBackground(Color.RED);
                            } else {
                                playButton.setBackground(Color.GREEN);
                            }
                        });
                        playButton.setBorderPainted(false);
                        playButton.setFocusPainted(false);


                        JButton addToMyListButton = new JButton("Add to MyList");
                        addToMyListButton.setBorderPainted(false);
                        addToMyListButton.setFocusPainted(false);
                        addToMyListButton.addActionListener(e5 -> {
                            controller.addToMyList(m);
                        });


                        JButton removeFromMyListButton = new JButton("Remove from MyList");
                        removeFromMyListButton.setBorderPainted(false);
                        removeFromMyListButton.setFocusPainted(false);
                        removeFromMyListButton.addActionListener(e4 -> {
                            controller.removeFromMyList(m);
                        });

                        JPanel buttonPanel = new JPanel();
                        buttonPanel.setLayout(new GridLayout(0, 1));
                        buttonPanel.add(playButton);
                        buttonPanel.add(addToMyListButton);
                        buttonPanel.add(removeFromMyListButton);

                        mediaContentPane.add(buttonPanel, BorderLayout.EAST);

                        mediaFrame.pack();
                        mediaFrame.setLocationRelativeTo(null);
                        mediaFrame.setVisible(true);

                    }
            );
            //Gør knappen lidt pænere, og sådan at den kun fylder billedet.
            picButton.setBorderPainted(false);
            picButton.setFocusPainted(false);
            picButton.setContentAreaFilled(false);

            gridPanel.add(picButton);

            //Opretter tekst-lablen under billedet. Jeg tjekker efter et (abritært) antal tegn, og forkorter med "..." til sidst hvis titlen er for lang (ellers kommer der mellemrum mellem filmene).
            JLabel textLabel;

            if (m.getName().trim().length() <= 17) {
                textLabel = new JLabel(m.getName(), JLabel.CENTER);
            } else {
                String shortenedText = "";
                for (int i = 0; i < 17; i++) {
                    shortenedText = shortenedText + m.getName().charAt(i);
                }
                textLabel = new JLabel(shortenedText + "...", JLabel.CENTER);

            }
            textLabel.setFont(new Font("Verdana", Font.BOLD, 11));
            textLabel.setForeground(Color.white);
            textLabel.setOpaque(false);
            gridPanel.add(textLabel);


            textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            picButton.setAlignmentX(Component.CENTER_ALIGNMENT);


            centerJPanel.add(gridPanel);

        }


        BorderLayout tempLayout = (BorderLayout) frame.getContentPane().getLayout();
        if (tempLayout.getLayoutComponent(BorderLayout.CENTER) != null) {
            frame.getContentPane().remove(tempLayout.getLayoutComponent(BorderLayout.CENTER));
        }


        frame.getContentPane().add(centerJScrollPane);
        frame.setVisible(true);
    }

    /**
     * Creates and displays a messageDialog in case of failed search.
     */
    public void displayNoSuchMovieException() {
        JOptionPane.showMessageDialog(frame, "No movies matched your search-criteria");

    }
}
