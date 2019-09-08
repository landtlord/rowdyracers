package com.switchfully.project.rowdyracers.views;

import com.switchfully.project.rowdyracers.GameCanvas;
import com.switchfully.project.rowdyracers.GameFrame;
import com.switchfully.project.rowdyracers.domain.*;
import com.switchfully.project.rowdyracers.views.graphicelements.PlayerGE;
import com.switchfully.project.rowdyracers.views.graphicelements.SquareGE;

import java.awt.*;

public class GridView extends View {

    private static final int AMOUNT_OF_GRID_ROWS = 10;
    private static final int AMOUNT_OF_GRID_COLUMNS = 10;
    private static final int SPACING_SIZE = 5;

    public GridView(GameCanvas canvas) {
        super(canvas);
        createSquareShapes();
        createPlayers();
    }

    private void createPlayers() {
        getCanvas().addComponent(
                new PlayerGE(
                        new Player(
                                new Coordinates(
                                        fromColumnToXCoordinate(0),
                                        fromRowToYCoordinate(0)),
                                new Size(getSquareWidth(), getSquareHeight()),
                                "player-red"
                        )));
        getCanvas().addComponent(
                new PlayerGE(
                        new Player(
                                new Coordinates(
                                        fromColumnToXCoordinate(AMOUNT_OF_GRID_COLUMNS - 1),
                                        fromRowToYCoordinate(AMOUNT_OF_GRID_ROWS - 1)),
                                new Size(getSquareWidth(), getSquareHeight()),
                                "player-blue"
                        )));
    }

    private void createSquareShapes() {
        for (int row = 0; row < AMOUNT_OF_GRID_ROWS; row++) {
            for (int column = 0; column < AMOUNT_OF_GRID_COLUMNS; column++) {
                SquareGE square = new SquareGE(
                        new Square(
                                new Coordinates(
                                        fromColumnToXCoordinate(column),
                                        fromRowToYCoordinate(row)),
                                new Size(getSquareWidth(), getSquareHeight()),
                                FillColor.GREY));
                getCanvas().addComponent(square);
            }
        }
    }

    private static int fromRowToYCoordinate(int row) {
        return row * getSquareHeight() + SPACING_SIZE * row;
    }

    private static int fromColumnToXCoordinate(int column) {
        return column * getSquareWidth() + SPACING_SIZE * column;
    }

    private static int getSquareHeight() {
        return (GameFrame.CANVAS_PANEL_HEIGHT - SPACING_SIZE * AMOUNT_OF_GRID_ROWS) / AMOUNT_OF_GRID_ROWS;
    }

    private static int getSquareWidth() {
        return (GameFrame.CANVAS_PANEL_WIDTH - SPACING_SIZE * AMOUNT_OF_GRID_COLUMNS) / AMOUNT_OF_GRID_COLUMNS;
    }


}
