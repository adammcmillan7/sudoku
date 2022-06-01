package view;

import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BoardImpl;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //model

        int[][] board1 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        BoardImpl board = new BoardImpl(board1);

        //controller
        ControllerImpl controller = new ControllerImpl(board);

        //view


        //scene
        /*Scene scene = new Scene();
        scene.getStylesheets().add();
        stage.setScene(scene);

        //refresh render
        board.addObserver((BoardImpl bi) ->{
            scene.setRoot(app.render());
        });

        stage.show();*/


    }
}
