/*import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GUIDesign extends Application {

    private Stage window;                       // vinduet
    private Scene scene1;                       // login siden
    private Scene scene2;                       // logout siden

    public static void main(String[] args) { //metoden der får Application til at launce.
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;                  /* renamer primaryStage til window for at gøre det
                                                 nemmere at huske hvad stage er. */
/*
        GridPane loginScreen = new GridPane();  // opretter layout til loginskærmen
        loginScreen.setPadding(new Insets(10, 10, 10, 10)); // margin mellem window og scene
        loginScreen.setVgap(8);                                                  // vertikal margin for alt der bliver indsat
        loginScreen.setHgap(10);                                                 // horisontal margin

        Label welcomeText = new Label("Velkommen til Netflix 2.0"); // velkomst tekst
        GridPane.setConstraints(welcomeText, 0, 0);

        Label userNameLabel = new Label("Brugernavn:");
        GridPane.setConstraints(userNameLabel, 0, 2);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Brugernavn");
        GridPane.setConstraints(nameInput, 1, 2);

        Label passwordLabel = new Label("Kodeord:");
        GridPane.setConstraints(passwordLabel, 0, 3);

        TextField passInput = new TextField();
        passInput.setPromptText("Kodeord");
        GridPane.setConstraints(passInput, 1, 3);

        Button loginButton = new Button("Login");               // login knap der skifter til scene2 ved tryk
        loginButton.setOnAction(e -> window.setScene(scene2));
        GridPane.setConstraints(loginButton, 1, 4);

        loginScreen.getChildren().addAll(welcomeText, userNameLabel, nameInput, passwordLabel, passInput, loginButton);

        scene1 = new Scene(loginScreen, 400, 400); //opret scenen med loginScreen som layout.

        Button logoutButton = new Button("Logout");         // Logout knap der skifter tilbage til scene1
        logoutButton.setOnAction(e -> window.setScene(scene1));

        StackPane mainLayout = new StackPane();
        mainLayout.getChildren().add(logoutButton);
        scene2 = new Scene(mainLayout, 400, 400);

        window.setScene(scene1);
        window.setTitle("Netflix 2.0");
        window.show();
    }
}
*/

