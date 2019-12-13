import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class View {
    protected static JFrame frame;
    protected ArrayList<JCheckBox> jCheckBoxArrayList;
    protected Controller controller;
    protected JTextField searchField;

    public View(Controller controller) {
        this.controller = controller;
        jCheckBoxArrayList = new ArrayList<>();
    }

    public void run(ArrayList<Media> media, ArrayList<String> genreList) {
        frame = new JFrame("playIT");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        int frameHeight = screenSize.height;
        int frameWidth = screenSize.width;


        //frame.setPreferredSize(new Dimension(frameWidth, frameHeight));


        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        //NORTH
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JButton myListButton = new JButton("Min Liste");
        JButton seriesButton = new JButton("Serier");
        JButton movieButton = new JButton("Film");
        searchField = new JTextField(16);
        JButton searchButton = new JButton("?");
        JButton userProfileButton = new JButton("(Bruger)");
        northPanel.add(myListButton);
        northPanel.add(seriesButton);
        northPanel.add(movieButton);
        northPanel.add(searchField);
        northPanel.add(searchButton);
        northPanel.add(userProfileButton);

        contentPane.add(northPanel, BorderLayout.NORTH);

        searchButton.addActionListener(e -> {
            controller.searchForString();
        });


        //WEST
        //Nedenfor laves JPanel'et i West, som senere kommer til at indeholde nogle checkboxe
        JPanel westJPanel = new JPanel();
        contentPane.add(westJPanel, BorderLayout.WEST);

        //JPanel'et bliver lavet som vertikalt boxlayout, det er her hhv checkboxe og kategorier kommer til at stå under hinanden
        westJPanel.setLayout(new BoxLayout(westJPanel, BoxLayout.Y_AXIS));

        //Tilføjer checkboxene


        for (String s : genreList) {
            JCheckBox tempBoxReference = new JCheckBox(s);
            westJPanel.add(tempBoxReference);
            jCheckBoxArrayList.add(tempBoxReference);

            tempBoxReference.addActionListener(e -> {
                controller.searchByGenre();
            });
        }


        //SOUTH
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JLabel rightsLabel = new JLabel("ALL RIGHTS RESERVED. TM & COPYRIGHT");
        southPanel.add(rightsLabel);
        contentPane.add(southPanel, BorderLayout.SOUTH);

        //CENTER
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        update(media);


    }

    public ArrayList<JCheckBox> getJCheckBoxArrayList() {
        return jCheckBoxArrayList;
    }

    public String getSearchField() {
        return searchField.getText();
    }

    public void update(ArrayList<Media> media) {

        JPanel centerJPanel = new JPanel();
        JScrollPane centerJScrollPane = new JScrollPane(centerJPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        GridLayout centerGrid = new GridLayout(0, 8);
        centerJPanel.setLayout(centerGrid);


        /*Hele den her for-løkke gennemløber medierne i søgemaskinens library. Den opretter medierne i et Grid-layout, tilføjer billederne til medierne, tilføjer "knapper" så man kan trykke på medierne,
        og desuden tilføjer en label der viser filmens titel under billedet. Det er denne her lange metode, som nok skal sættes som en separat metode, således at man kan opdatere film-listen alt efter input
        fra brugeren.
        */
        for (Media m : media) {
            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new BorderLayout());

            //Billedet hentes direkte fra medie-objektet og bliver sat som ikon til en JButton, så man kan trykke på den.
            JButton picButton = new JButton(new ImageIcon(m.getPictureFile()));
            //Billedknappens funktion. Hvad skal der ske, når man trykker på en film. Måske dialogboks?

            //Prøver at få den til at åbne et nyt Frame, og så tage den derfra.

            picButton.addActionListener(e -> {
                        JFrame mediaFrame = new JFrame(m.getName());

                        //skalerer framet, så det ser pænere ud

                        // get the screen size as a java dimension
                        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                        // get 2/3 of the height, and 2/3 of the width
                        int frameHeight = screenSize.height * 2 / 3;
                        int frameWidth = screenSize.width * 2 / 3;

                        // set the jframe height and width
                        mediaFrame.setPreferredSize(new Dimension(frameWidth, frameHeight));

                        Container mediaContentPane = mediaFrame.getContentPane();

                        mediaContentPane.setLayout(new BorderLayout());

                        //skalering af billede, så det passer med sit frame
                        int picWidth = m.getPictureFile().getWidth();
                        int picHeight = m.getPictureFile().getHeight();
                        double picAspectRatio = (picWidth + 0.0) / (picHeight + 0.0);
                        picHeight = frameHeight;
                        double newPicWidth = picAspectRatio * picHeight;


                        JLabel picture = new JLabel(new ImageIcon(new ImageIcon(m.getPictureFile()).getImage().getScaledInstance((int) newPicWidth, picHeight, Image.SCALE_SMOOTH)));

                        mediaContentPane.add(picture, BorderLayout.WEST);

                        JPanel aboutPanel = new JPanel();
                        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
                        aboutPanel.add(new JLabel("About: "));
                        aboutPanel.add(new JLabel("   "));
                        aboutPanel.add(new JLabel("Title: " + m.getName()));
                        aboutPanel.add(new JLabel("Year: " + m.getYear()));
                        String genresAbout = "Genres: ";
                        for (int i = 0; i < m.getGenres().length - 1; i++) {
                            genresAbout = genresAbout + m.getGenres()[i] + ", ";
                        }
                        genresAbout = genresAbout + m.getGenres()[m.getGenres().length - 1];

                        aboutPanel.add(new JLabel(genresAbout));
                        aboutPanel.add(new JLabel("Rating: " + m.getRating()));

                        mediaContentPane.add(aboutPanel);

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
                        mediaContentPane.add(playButton, BorderLayout.EAST);
                        mediaFrame.pack();
                        mediaFrame.setLocationRelativeTo(null);
                        mediaFrame.setVisible(true);

                    }
            );

            //Gør knappen lidt pænere, og sådan at den kun fylder billedet.
            picButton.setBorderPainted(false);
            picButton.setFocusPainted(false);
            picButton.setContentAreaFilled(false);


            gridPanel.add(picButton, BorderLayout.CENTER);

            //Opretter tekst-lablen under billedet. Jeg tjekker efter et (abritært) antal tegn, og forkorter med "..." til sidst hvis titlen er for lang (ellers kommer der mellemrum mellem filmene).
            JLabel textLabel;
            if (m.getName().length() <= 17) {
                textLabel = new JLabel(m.getName(), SwingConstants.CENTER);
            } else {
                String shortenedText = "";
                for (int i = 0; i <= 17; i++) {
                    shortenedText = shortenedText + m.getName().charAt(i);
                }
                textLabel = new JLabel(shortenedText + "...", SwingConstants.CENTER);

            }
            gridPanel.add(textLabel, BorderLayout.SOUTH);
            centerJPanel.add(gridPanel);
        }


        BorderLayout tempLayout = (BorderLayout) frame.getContentPane().getLayout();
        if (tempLayout.getLayoutComponent(BorderLayout.CENTER) != null) {
            frame.getContentPane().remove(tempLayout.getLayoutComponent(BorderLayout.CENTER));
        }
        frame.getContentPane().add(centerJScrollPane);

        frame.setVisible(true);
    }

    public void displayNoSuchMovieException() {
        JOptionPane.showMessageDialog(frame, "No movies matched your search-criteria");

    }
}
