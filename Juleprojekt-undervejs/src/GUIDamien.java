/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

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

        GridLayout centerGrid = new GridLayout(0, 9);
        centerJPanel.setLayout(centerGrid);

        SearchEngine searchEngine = new SearchEngine();

        /*Hele den her for-løkke gennemløber medierne i søgemaskinens library. Den opretter medierne i et Grid-layout, tilføjer billederne til medierne, tilføjer "knapper" så man kan trykke på medierne,
        og desuden tilføjer en label der viser filmens titel under billedet. Det er denne her lange metode, som nok skal sættes som en separat metode, således at man kan opdatere film-listen alt efter input
        fra brugeren.
        */
/*
        for (Media m : searchEngine.getLibrary()) {
            JPanel gridPanel = new JPanel();
            gridPanel.setLayout(new BorderLayout());

            //Billedet hentes direkte fra medie-objektet og bliver sat som ikon til en JButton, så man kan trykke på den.
            JButton picButton = new JButton(new ImageIcon(m.getPictureFile()));
            //Billedknappens funktion. Hvad skal der ske, når man trykker på en film. Måske dialogboks?

            //Prøver at få den til at åbne et nyt Frame, og så tage den derfra.

            picButton.addActionListener(e -> {
                        JFrame mediaFrame = new JFrame(m.getName());
                        Container mediaContentPane = mediaFrame.getContentPane();

                        mediaContentPane.setLayout(new BorderLayout());

                        JLabel picture = new JLabel(new ImageIcon(m.getPictureFile()));
                        mediaContentPane.add(picture, BorderLayout.WEST);

                        JPanel aboutPanel = new JPanel();
                        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
                        aboutPanel.add(new JLabel("About: "));
                        aboutPanel.add(new JLabel("Title: " + m.getName()));
                        aboutPanel.add(new JLabel("Year: " + m.getYear()));
                        String genresAbout = "Genres: ";
                        for (int i = 0; i < m.getGenres().length; i++) {
                            genresAbout = genresAbout + m.getGenres()[i];
                        }
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
                        mediaContentPane.add(playButton, BorderLayout.EAST);
                        mediaFrame.pack();
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

        contentPane.add(centerJScrollPane, BorderLayout.CENTER);


        //SOUTH
        JButton southJButton = new JButton("South");
        contentPane.add(southJButton, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);
    }
}
*/