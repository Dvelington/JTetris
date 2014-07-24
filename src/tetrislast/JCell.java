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
public class JCell {
    
    public STATE _state;
    
    public JCell(STATE state)
    {
        _state = state;
    }
    
    public enum STATE
    {
        FLOOR,FIGURE,EMPTY,WALL;
    }
    
    public boolean equals(JCell c)
    {
        return true;
    }
}
