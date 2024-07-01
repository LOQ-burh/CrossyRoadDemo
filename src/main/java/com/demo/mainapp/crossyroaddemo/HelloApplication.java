package com.demo.mainapp.crossyroaddemo;

import com.almasb.fxgl.app.GameSettings;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;


import static com.almasb.fxgl.dsl.FXGL.getWorldProperties;

public class HelloApplication extends GameApplication {
    private static int screenWidth;
    private static int screenHeight;

    private boolean pause;

    // Default constructor
    public HelloApplication() {
        this.pause = true; // or false, depending on your requirement
    }

    public HelloApplication(boolean pause) {
        this.pause = pause;
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("Frogger Remix");

        settings.setWidth(800);
        settings.setHeight(800);

        // Set the initial position of the window
        settings.setFullScreenAllowed(false);

    }

    @Override
    protected void initGame() {
        // Initialize game here
        // For example, you can add a text node to the scene
        Text text = new Text();
        text.setText("Game Paused: " + pause);
        text.setFill(Color.WHITE);
        text.setTranslateX(400); // Center text horizontally
        text.setTranslateY(400); // Center text vertically

        getGameScene().addUINode(text);
    }
//    @Override
//    public void start(Stage stage) throws IOException {
////        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
////        screenWidth = (int) screenSize.getWidth();
////        screenHeight = (int) screenSize.getHeight();
//
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        Scene scene = new Scene(fxmlLoader.load(getClass().getResource("hello-view.fxml")), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }

    public void initUI() {
        Text scoreLabel = getUIFactoryService().newText("Score", Color.BLACK, 22);
        Text scoreValue = getUIFactoryService().newText("", Color.BLACK, 22);
        Text livesLabel = getUIFactoryService().newText("Lives", Color.BLACK, 22);
        Text livesValue = getUIFactoryService().newText("", Color.BLACK, 22);

        scoreLabel.setTranslateX(20);
        scoreLabel.setTranslateY(20);

        scoreValue.setTranslateX(90);
        scoreValue.setTranslateY(20);

        livesLabel.setTranslateX(getAppWidth() - 150);
        livesLabel.setTranslateY(20);

        livesValue.setTranslateX(getAppWidth() - 80);
        livesValue.setTranslateY(20);

        scoreValue.textProperty().bind(getWorldProperties().intProperty("score").asString());
        livesValue.textProperty().bind(getWorldProperties().intProperty("lives").asString());

        getGameScene().addUINodes(scoreLabel, scoreValue, livesLabel, livesValue);
    }

//    public void initSettings(GameSettings settings) {
//        settings.setHeight(screenHeight);
//        settings.setWidth(screenWidth);
//        settings.setFullScreenAllowed(true);
//        settings.setFullScreenFromStart(true);
//        settings.setTitle("Oracle Java Magazine - FXGL");
//    }

    public static void main(String[] args) {
        // Pause game if first run.
        final boolean pause = true;

        // Create and launch the FXGL application
        launch(HelloApplication.class, args);
    }
}