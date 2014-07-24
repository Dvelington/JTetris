/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetrislast;

import java.awt.Color;
import java.awt.Graphics;


import java.util.Timer;
import javax.swing.JFrame;

/**
 *
 * @author jane
 */
public class JGame extends JFrame {

    JField field;
    JFigGenerator gen;
    Timer time;
    int i=0;
    
    public JGame(){
        super("Game");
        setSize(320,480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.field = new JField();
        gen = new JFigGenerator(field);
        time = new Timer();
        time.schedule(gen, 10, 100);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.repaint();
        int[][] mas = gen._controll.sumFieldFigure();
        for(int ii=1;ii<field.SIZEY;ii++)
            for(int j=1;j<field.SIZEX-1;j++)
            {
                if(mas[ii-1][j-1]==0)
                {
                    g.setColor(Color.red);
                    g.fillRect(200 - j * 15, 300 - ii * 15, 14, 14);
                }
                if(mas[ii-1][j-1]==1)
                {
                    g.setColor(Color.green);
                    g.fillRect(200 - j * 15, 300 - ii * 15, 14, 14);
                }
                if(mas[ii-1][j-1]==2)
                {
                    g.setColor(Color.black);
                    g.fillRect(200 - j * 15, 300 - ii * 15, 14, 14);
                }
            }
    }
}
