/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetrislast;


public class JFigureSquare extends JFigure {


    public JFigureSquare(TYPE type) {
        super(type);
        _xSize = 2;
        _ySize = 2;
        _figure = new JCell[_xSize][_ySize];
        for(int i=0;i<_xSize;i++)
            for(int j=0;j<_ySize;j++)
                _figure[i][j] = new JCell(JCell.STATE.FIGURE);
    }
    
}
