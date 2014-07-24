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
public class JField {
    
    public final int SIZEX = 12;
    public final int SIZEY = 21;
    
    
    private JCell[][] _field;
    private JFigure _curFigure;
    
    private int _playerPoints;
    private int _gameSpeed;
    private boolean _isGame;
    
    public JField()
    {
        _field = new JCell[SIZEY][SIZEX];
        _curFigure = null;
        _playerPoints = 0;
        _gameSpeed = 1500;
        _isGame = true;
        
        for(int i=0;i<SIZEY;i++)
            for(int j=0;j<SIZEX;j++)
            {
                if(i==0 || j ==0 || j== SIZEX-1)
                    _field[i][j] = new JCell(JCell.STATE.WALL);
                else _field[i][j] = new JCell(JCell.STATE.EMPTY);
            }
        
    }
    
    
    
    public void rowCheck()
    {
        int count = 0;
        for(int i=1;i<SIZEY-1;i++){
            for(int j=1;j<SIZEX-1;j++)
            {
                if(_field[i][j]._state == JCell.STATE.FIGURE)
                {
                    count++;
                }
            }
            if(count == SIZEX-2)
            {
                _playerPoints+=10;
                for(int k=i;k<SIZEY-2;k++)
                    for(int h=1;h<SIZEX-1;h++)
                    {
                        _field[k][h] = _field[k+1][h];
                    }
                i--;
            }
            count =0;
        }
    }
    
    public JFigure getFigure()
    {
        return _curFigure;
    }
    
    public boolean isGameOver()
    {
        for(int i=0;i<SIZEX;i++)
            if(_field[SIZEY-1][i]._state == JCell.STATE.FLOOR)
            {
                _isGame = false;
                return true;
            }
        return false;
    }
    
    public boolean getIsGame()
    {
        return _isGame;
    }
    
    public void setGameSpeed(int k)
    {
        _gameSpeed -= k;
    }
    
    public void setFigure(JFigure fig)
    {
        _curFigure = fig;
    }
    
    public JCell[][] getField()
    {
        return _field;
    }

    public void setIsGame(boolean _isGame) {
        this._isGame = _isGame;
    }
    
}
