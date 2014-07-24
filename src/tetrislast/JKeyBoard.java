/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetrislast;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author qwerty
 */
public class JKeyBoard extends KeyAdapter {
    
    JControll con;
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        int keycode = e.getKeyCode();
        if(keycode == KeyEvent.VK_LEFT)
        {
            con.moveL();
        }
        if(keycode == KeyEvent.VK_RIGHT)
        {
            con.moveR();
        }
        if(keycode == KeyEvent.VK_DOWN)
        {
            con.moveD();
        }
        if(keycode == KeyEvent.VK_UP)
        {
            con.rotate();
        }
    }
    
}
