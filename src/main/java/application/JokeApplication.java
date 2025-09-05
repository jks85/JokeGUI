package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Display joke...");
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window){
        // create layout elements
        BorderPane view = new BorderPane();
        HBox buttonMenu = new HBox();

        // create UI elements
        Button showJokeButton = new Button("Joke");
        Button answerJokeButton = new Button("Answer");
        Button explainJokeButton = new Button("Explanation");

        StackPane showJokeStackPane = this.createStackPane("What do you call a bear with no teeth?");
        StackPane answerJokeStackPane = this.createStackPane("A gummy bear.");
        StackPane explainJokeStackPane = this.createStackPane("Explanation: A toothless bear would only have gums in its mouth.");

        // set up layout
        buttonMenu.getChildren().addAll(showJokeButton, answerJokeButton, explainJokeButton);
        buttonMenu.setSpacing(20);
        buttonMenu.setAlignment(Pos.CENTER);

        view.setPrefSize(500, 240);
        view.setTop(buttonMenu);
        view.setCenter(showJokeStackPane);

        // on joke button click, show joke text
        showJokeButton.setOnAction((event) -> {
            view.setCenter(showJokeStackPane);
        });

        // on answer button click show answer text
        answerJokeButton.setOnAction((event) -> {
            view.setCenter(answerJokeStackPane);
        });

        // on explanation button click show explanation
        explainJokeButton.setOnAction((event) -> {
            view.setCenter(explainJokeStackPane);
        });

        // create scene and  window
        Scene scene = new Scene(view);

        // set up window
        window.setScene(scene);
        window.show();


    }

    public StackPane createStackPane(String labelText){
        StackPane stackPane = new StackPane();
        Label label = new Label(labelText);
        stackPane.getChildren().add(label);

        return stackPane;
    }

}
