import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class View {
    protected static JFrame frame;
    protected ArrayList<JCheckBox> jCheckBoxArrayList;
    protected Controller controller;
    protected JTextField searchField;
    private static String filePath = new File("").getAbsolutePath();

    public View(Controller controller){
        this.controller = controller;
        jCheckBoxArrayList = new ArrayList<>();
        }

    public void run(ArrayList<Media> media, ArrayList<String> genreList) {
        frame = new JFrame("playIT");


        JLabel contentPane = new JLabel();
        contentPane.setIcon(new ImageIcon(filePath + "/biografsæderbaggrundsbillede.jpg"));

        // Container contentPane = frame.getContentPane();

        contentPane.setLayout(new BorderLayout());
        frame.setContentPane(contentPane);
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

        searchButton.addActionListener(e -> { controller.searchForString(); } );

        seriesButton.addActionListener(e1 -> {controller.showSeries(); });
        movieButton.addActionListener(e2 -> { controller.showMovies(); });


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
                } );
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

    public ArrayList<JCheckBox> getJCheckBoxArrayList(){return jCheckBoxArrayList;}

    public String getSearchField(){return searchField.getText();}

    public void update(ArrayList<Media> media) {

        JPanel centerJPanel = new JPanel();
        JScrollPane centerJScrollPane = new JScrollPane(centerJPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Her bruges WrapLayout klassen, som er en klasse vi har inkluderet i projektet, og som er fundet på nettet. Den extender FlowLayout,
        //og "wrapper" teksten således at medierne tilpasser sig, når man resizer frame. Constructoren tager en "alignment" man tager direkte fra flowlayout
        // som i det her tilfælde er FlowLayout.LEADING, sådan at medierne placeres venstre-mod-højre og ikke centreres, hvis der en sidste række med
        // færre medier end de forrige rækker.
        centerJPanel.setLayout(new WrapLayout(FlowLayout.LEADING));


        /*Hele den her for-løkke gennemløber medierne i søgemaskinens library. Den opretter medierne, tilføjer billederne til medierne, tilføjer "knapper" så man kan trykke på medierne,
        og desuden tilføjer en label der viser filmens titel under billedet.
        */
        for (Media m : media) {
            JPanel gridPanel = new JPanel();
            //Jeg sætter billedet sammen med en textLabel i et vertikalt BoxLayout, sådan så jeg sørger for, at der aldrig kommer luft mellem billede og tekst.
            BoxLayout boxLayout = new BoxLayout(gridPanel, BoxLayout.Y_AXIS);
            gridPanel.setLayout(boxLayout);

            //Billedet hentes direkte fra medie-objektet og bliver sat som ikon til en JButton, så man kan trykke på den.
            JButton picButton = new JButton(new ImageIcon(m.getPictureFile()));

            //Billedet åbner et nyt frame, henter information om mediet direkte fra objektet, og opretter en playknap :)

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
                        double picAspectRatio = (picWidth+0.0)/(picHeight+0.0);
                        picHeight = frameHeight;
                        double newPicWidth  = picAspectRatio*picHeight;


                        JLabel picture = new JLabel(new ImageIcon(new ImageIcon(m.getPictureFile()).getImage().getScaledInstance((int) newPicWidth, picHeight, Image.SCALE_SMOOTH)));

                        mediaContentPane.add(picture, BorderLayout.WEST);

                        JPanel aboutPanel = new JPanel();
                        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
                        aboutPanel.add(new JLabel("About: "));
                        aboutPanel.add(new JLabel("   "));
                        aboutPanel.add(new JLabel("Title: " + m.getName()));
                        aboutPanel.add(new JLabel("Year: " + m.getYear()));
                        String genresAbout = "Genres: ";
                        for (int i = 0; i < m.getGenres().length-1; i++) {
                            genresAbout = genresAbout + m.getGenres()[i] + ", ";
                        }
                        genresAbout = genresAbout + m.getGenres()[m.getGenres().length-1];

                        aboutPanel.add(new JLabel(genresAbout));
                        aboutPanel.add(new JLabel("Rating: " + m.getRating()));

                        mediaContentPane.add(aboutPanel);

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


                        JButton removeFromMyListButton = new JButton("Remove from MyList");
                        removeFromMyListButton.setBorderPainted(false);
                        removeFromMyListButton.setFocusPainted(false);

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

            //gamle kode, her blev billedeknap og tekstlabel blot tilføjet en ad gangen.
            gridPanel.add(picButton);

            //Opretter tekst-lablen under billedet. Jeg tjekker efter et (abritært) antal tegn, og forkorter med "..." til sidst hvis titlen er for lang (ellers kommer der mellemrum mellem filmene).
            JLabel textLabel;
            if (m.getName().length() <= 17) {
                textLabel = new JLabel(m.getName(), JLabel.CENTER);
            } else {
                String shortenedText = "";
                for (int i = 0; i <= 17; i++) {
                    shortenedText = shortenedText + m.getName().charAt(i);
                }
                textLabel = new JLabel(shortenedText + "...", JLabel.CENTER);

            }
            gridPanel.add(textLabel);

            textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            picButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            centerJPanel.add(gridPanel);
        }



        BorderLayout tempLayout = (BorderLayout) frame.getContentPane().getLayout();
        if(tempLayout.getLayoutComponent(BorderLayout.CENTER) != null) {
            frame.getContentPane().remove(tempLayout.getLayoutComponent(BorderLayout.CENTER));
        }
        frame.getContentPane().add(centerJScrollPane);

        frame.setVisible(true);
    }


    public void displayNoSuchMovieException() {
        JOptionPane.showMessageDialog(frame, "No movies matched your search-criteria");

    }
}
