package GraphicalInterface;

import Models.*;
import View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.MalformedURLException;

public class Graphic extends Application
{
    public static void main(String[] args) {
        JSONHandler.createObjects();
        JSONHandler.readAllFromJsons();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws MalformedURLException, InterruptedException
    {
        Map map = Map.createMap("Land", false, new Pane());
        ImageView backyard = new ImageView(new Image("Resources/Backyard.jpg"));
        map.getMgi().getPane().getChildren().add(backyard);
        Collection pc = new Collection();
        pc.add(Plant.getAllPlants().getCard("Peashooter"));
        pc.add(Plant.getAllPlants().getCard("Threepeater"));
        pc.add(Plant.getAllPlants().getCard("Jalapeno"));
        Collection zc = new Collection();
        zc.add(Zombie.getAllZombies().getCard("Zombie"));
        RailMode game = RailMode.createRailMode(map , pc , zc);
        Profile profile = new Profile("ali" , "123");
        View view = new View();
        view.run(game , profile , false);

        primaryStage.setTitle("Boogie Boo");

        //Zombie.putZombie(Zombie.getZombie() , map.getByCoordination(1 , 3));

        Scene scene = new Scene(map.getMgi().getPane() , 1007 , 600);

        primaryStage.setScene(scene);
        primaryStage.show();



        /*AnimationTimer x = new AnimationTimer() {
            int z = 850;
            long prevNanos = 0;

            @Override
            public void handle(long now) {
                // calculate elapsed time
                if (prevNanos == 0) {
                    prevNanos = now;
                    return;
                }

                if (now - prevNanos > 1e8 && z > 0)
                {
                    prevNanos = now;

                    ImageView zombie = new ImageView("GraphicalInterface/TheAdvancing_zombie.gif");
                    zombie.setX(z);
                    zombie.setY(40);
                    pane.getChildren().add(zombie);

                    z -= 40;
                }
            }
        };

        x.start();*/
    }
}

class Operation
{

}
