package com.demo.mainapp.crossyroaddemo;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.MenuItem;
import com.almasb.fxgl.app.scene.*;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.LoadingScene;
import com.almasb.fxgl.app.scene.SceneFactory;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;
import javafx.scene.control.Button;
import java.util.Arrays;
import java.util.EnumSet;


import static com.almasb.fxgl.dsl.FXGL.getWorldProperties;

public class HelloApplication extends GameApplication {
    private final int HEIGHT = 720;
    private final int WIDTH = 1280;
    private boolean pause;

    // Default constructor
//    public HelloApplication() {
//        this.pause = true; // or false, depending on your requirement
//    }
//
//    public HelloApplication(boolean pause) {
//        this.pause = pause;
//    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setTitle("UI Remix");
        settings.setWidth(WIDTH);
        settings.setHeight(HEIGHT);
        settings.setVersion("0.1 - Team thằng nào mạnh, thằng đấy làm!");
        settings.setMainMenuEnabled(true);
        settings.setGameMenuEnabled(false);
        settings.setGameMenuEnabled(true);
        settings.setManualResizeEnabled(true);
        settings.setPreserveResizeRatio(true);
        // Set the initial position of the window
        settings.setFullScreenAllowed(false);
        settings.setEnabledMenuItems(EnumSet.of(MenuItem.EXTRA));
        settings.getCredits().add(Arrays.asList(
                "Start date: 20 june 2024\n",
                "\n",
                "-- Lead --\n",
                "Hank\n",
                "\n",
                "-- Member --\n",
                "Quan\n",
                "\n",
                "-- Designer --\n",
                "Quan",
                "\n",
                "-- Search idea --\n",
                "Hank, Quan"
        ).toString());
//        settings.setSceneFactory(new SceneFactory() {
//            @Override
//            public FXGLMenu newMainMenu() {
//                return new MainMenu();
//            }
//        });
    }

    @Override
    protected void initGame() {
        // Initialize game here
        // For example, you can add a text node to the scene
        getGameScene().setBackgroundRepeat("assets/Materials/background/minecraft-crossy-road.png");
        Text text = getUIFactoryService().newText("Hello, FXGL!", Color.WHITE, 24);
        getGameScene().addUINode(text);
    }

    public static void main(String[] args) {
        // Pause game if first run.
        //final boolean pause = true;
        launch(args);
    }
}