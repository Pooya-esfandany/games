package view.attack;

import Data.Player;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CloseStage {
    Stage stage;
    Player player;
    public void close() {
        Platform.runLater(() -> {
            stage.close();
            Result.stage(player,Attack.totalBuilds,Attack.locations.size()).show();
        });
    }
    CloseStage(Player player,Stage stage)
    {
        this.player=player;
        this.stage=stage;
    }
}
