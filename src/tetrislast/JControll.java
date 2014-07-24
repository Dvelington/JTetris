/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetrislast;

/**
 *
 * @author jane
 */
public class JControll {
    
    private JField _field;
    private int _xPivot;
    private int _yPivot;
    
    public int[][] sumFieldFigure() {
        JFigure _figure = _field.getFigure();
        int[][] mas = new int[_field.SIZEY - 1][_field.SIZEX - 2];
        try{
        for (int i = 1; i < _field.SIZEY - 1; i++) {
            for (int j = 1; j < _field.SIZEX - 1; j++) {
                if (_field.getField()[i][j]._state == JCell.STATE.EMPTY) {
                    mas[i - 1][j - 1] = 0;
                }
                if (_field.getField()[i][j]._state == JCell.STATE.FIGURE) {
                    mas[i - 1][j - 1] = 1;
                }
                if (_field.getField()[i][j]._state == JCell.STATE.FLOOR) {
                    mas[i - 1][j - 1] = 2;
                }
            }
        }
        for(int i=0;i<_figure._xSize;i++)
            for(int j=0;j<_figure._ySize;j++)
                mas[j+_yPivot][i+_xPivot] = 1;
        }
        catch(NullPointerException e)
        {
            for (int i = 1; i < _field.SIZEY - 1; i++) {
                for (int j = 1; j < _field.SIZEX - 1; j++) {
                    if (_field.getField()[i][j]._state == JCell.STATE.EMPTY) {
                        mas[i - 1][j - 1] = 0;
                    }
                    if (_field.getField()[i][j]._state == JCell.STATE.FIGURE) {
                        mas[i - 1][j - 1] = 1;
                    }
                    if (_field.getField()[i][j]._state == JCell.STATE.FLOOR) {
                        mas[i - 1][j - 1] = 2;
                    }
                }
            }
            return mas;
        }
        return mas;
    }
    
    public JControll(JField field)
    {
        _field = field;
    }
    
    private void attach()
    {
        JFigure _figure = _field.getFigure();
        _figure = _field.getFigure();
        for (int i = 0; i < _figure._xSize; i++) {
            for (int j = 0; j < _figure._ySize; j++) {
                _field.getField()[i + _yPivot][j + _xPivot]._state = JCell.STATE.FLOOR;
            }
        }
        _field.rowCheck();
        if(_field.isGameOver())
        {
            _field.setIsGame(false);
        }
        _field.setFigure(null);
    }
    
    public void moveL()
    {
        if(checkL())
            _xPivot-=1;
    }
    
    public void moveR()
    {
        if(checkR())
            _xPivot+=1;
    }
    
    public void moveD()
    {
        if(checkD())
            _yPivot-=1;
        else
        {
            attach();
            _field.setFigure(null);
        }
    }
    
    private boolean checkR()
    {
        JFigure _figure = _field.getFigure();
        JCell[][] field = _field.getField();
        int ysize = _figure._ySize;
        int xsize = _figure._xSize;
        try {
            for (int i = 0; i < xsize; i++) {
                for (int j = 0; j < ysize; j++) {
                    if (field[_xPivot + j][_yPivot + i + 1]._state == JCell.STATE.WALL || field[_xPivot + j][_yPivot + i + 1]._state == JCell.STATE.FLOOR) {
                        return false;
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
    
    private boolean checkL()
    {
        JFigure _figure = _field.getFigure();
        JCell[][] field = _field.getField();
        int ysize = _figure._ySize;
        int xsize = _figure._xSize;
        try {
            for (int i = 0; i < xsize; i++) {
                for (int j = 0; j < ysize; j++) {
                    if (field[_xPivot + j][_yPivot + i - 1]._state == JCell.STATE.WALL || field[_xPivot + j][_yPivot + i - 1]._state == JCell.STATE.FLOOR) {
                        return false;
                    }
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
    
    private boolean checkD() 
    {
        JFigure _figure = _field.getFigure();
        JCell[][] field = _field.getField();
        int ysize = _figure._ySize;
        int xsize = _figure._xSize;
        try {
            for (int i = 0; i < xsize; i++) {
                for (int j = 0; j < ysize; j++) {
                    if (field[_yPivot + j - 1][_xPivot + i]._state == JCell.STATE.WALL || field[_yPivot + j - 1][_xPivot + i]._state == JCell.STATE.FLOOR) {
                        return false;
                    }
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
        return true;
    }
    
    public void setPivot(int a, int b)
    {
        _xPivot=a;
        _yPivot=b;
    }
    
    public void rotate()
    {
        
    }
    
}
