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
public abstract class JFigure {
    
    protected JCell[][] _figure;
    protected TYPE _type;
    protected CONFIGURATION _conf;
    protected int _xSize;
    protected int _ySize;
    
    public JFigure(TYPE type)
    {
        _type = type;
        _conf = CONFIGURATION.a0;
    }
    
    protected enum CONFIGURATION
    {
        a90,a180,a270,a0;
    }

    protected enum TYPE {

        LFIGURE_L, LFIGURE_R, TFIGURE, SQUAREFIGURE, LINEFIGURE, FLASHFIGURE_L, FLASHFIGURE_R;
    }
    
    public JCell[][] getFigure()
    {
        return _figure;
    }
    
    public int getXSize(){return _xSize;}
    public int getYSize(){return _ySize;}
}
