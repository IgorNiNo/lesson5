package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;
    private int offSet;


    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.GREEN);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });
    }

    private void clickBattleField(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(!Logic.isFinished){
            Logic.humanTurn(cellX, cellY);
        }

        repaint();

    }


    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;
        offSet = cellWidth / 10;

        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawX(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
//        g.drawLine(cellWidth * x + 10, cellHeight * y + 10, cellWidth * (x + 1) - 10, cellHeight * (y + 1) - 10 );
//        g.drawLine(cellWidth * x + 10, cellHeight * (y + 1) - 10, cellWidth * (x + 1) - 10, cellHeight * y + 10 );
        g.drawLine(cellWidth * x + offSet, cellHeight * y + offSet, cellWidth * (x + 1) - offSet, cellHeight * (y + 1) - offSet );
        g.drawLine(cellWidth * x + offSet, cellHeight * (y + 1) - offSet, cellWidth * (x + 1) - offSet, cellHeight * y + offSet );
    }

    private void drawO(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
//        g.drawOval( cellWidth * x + offSet, cellHeight * y + offSet, cellWidth - offSet * 2, cellHeight - offSet * 2 );
        g.fillOval( cellWidth * x + offSet, cellHeight * y + offSet, cellWidth - offSet * 2, cellHeight - offSet * 2 );
    }
}
