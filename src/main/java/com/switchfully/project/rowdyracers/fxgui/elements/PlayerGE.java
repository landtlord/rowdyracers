package com.switchfully.project.rowdyracers.fxgui.elements;

import com.switchfully.project.rowdyracers.domain.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.switchfully.project.rowdyracers.domain.Square.WIDTH_HEIGHT_IN_PX;
import static com.switchfully.project.rowdyracers.fxgui.elements.utility.SquareUtility.fromColumnIndexToXCoordinate;
import static com.switchfully.project.rowdyracers.fxgui.elements.utility.SquareUtility.fromRowIndexToYCoordinate;

public class PlayerGE implements Drawable {

    private static final String IMG_EXTENSION = ".png";
    private static final String RESOURCES_BASE_PATH = "/";

    private final Player player;

    public PlayerGE(Player player) {
        this.player = player;
    }

    private Image createImage() {
        return new Image(getClass().getResourceAsStream(RESOURCES_BASE_PATH + player.getPlayerImgNameWithoutExtension() + IMG_EXTENSION),
                WIDTH_HEIGHT_IN_PX, WIDTH_HEIGHT_IN_PX, true, true);
    }

    @Override
    public void paint(GraphicsContext context) {
        context.drawImage(
                createImage(),
                fromColumnIndexToXCoordinate(player.getGridPosition().getColumnIndex()),
                fromRowIndexToYCoordinate(player.getGridPosition().getRowIndex()));
    }
}
