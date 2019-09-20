/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import java.awt.Graphics;

/**
 *
 * @author Rogerio
 */
public interface State {
    void init();
    void update();
    void render(Graphics g);
    void keyPressed(int code);
    void keyRelesed(int code);
    void keyTyped(int code);
    void dispose();
}
