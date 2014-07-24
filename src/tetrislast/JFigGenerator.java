/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetrislast;

import java.util.Random;
import java.util.TimerTask;

/**
 *
 * @author jane
 */
public class JFigGenerator extends TimerTask {
    
    private JField _field;
    public JControll _controll;
    
    public JFigure[] _figures;
    
    public JFigGenerator(JField field)
    {
        _field = field;
        _controll = new JControll(field);
        _figures = new JFigure[4];
        for(int i=0;i<4;i++)
            _figures[i] = new JFigureSquare(JFigure.TYPE.SQUAREFIGURE);
    }
    
    public void getNextFigure()
    {
        Random rnd = new Random();
        int k = rnd.nextInt(4);
        _field.setFigure(_figures[k]);
        _controll.setPivot(_field.SIZEX/2 - 1,_field.SIZEY - 1 - _figures[k].getYSize());
    }

    @Override
    public void run() {
        System.out.println("hh");
        if (_field.getIsGame()) {
            if (_field.getFigure() == null) {
                getNextFigure();
            } else {
                _controll.moveD();
            }
        }
    }
    
}
