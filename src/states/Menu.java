/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import game.Display;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author Rogerio
 */
public class Menu implements State{
    
    BufferedImage imgTitle;
    
    int index = 0;
    String[] txt = {"Singleplayer","Multiplayer","Exit"};
    public Menu() {        
        try {
//            imgTitle = ImageIO.read(getClass().
//                    getResourceAsStream("/res/titleMenu.PNG"));
//            im = ImageIO.read(getClass().getResourceAsStream("/res/personagem.PNG"));
//            ss = new SpiteSheet(im);
        } catch (Exception e) {
            new Throwable("Erro ao carregar Imagem");
        }
//        ArrayList array = new ArrayList<BufferedImage>();
//        array.add(ss.crop(0, 0, 22, 25));
//        array.add(ss.crop(1, 0, 22, 25));
//        array.add(ss.crop(3, 0, 22, 25));
//        array.add(ss.crop(4, 0, 22, 25));
        
        //Ajustar Velocidade aqui
//        animator = new Animator(array, 200);
//        animator.play();     
//        tp = new TypeWriter("123456789123456789123456789123456789123456789123456789123456789123456789", 300);
//        tp.play();
    }
    
    @Override
    public void init() {
        
    }

    @Override
    public void update() {
//        animator.update(System.currentTimeMillis());
//        tp.update(System.currentTimeMillis());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Display.WIDTH, Display.HEIGHT);
            
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN, 20);
        g.setFont(font);
        
//        g.drawImage(imgTitle, Display.WIDTH/2 - imgTitle.getWidth()/2,
//                Display.HEIGHT/3 - imgTitle.getHeight()/2, null);
        for (int i = 0; i < txt.length; i++) {
                if(index == i){
                g.setColor(Color.YELLOW);
            }else{
                g.setColor(Color.WHITE);
            }
            g.drawString(txt[i], Display.WIDTH/2
                    - (g.getFontMetrics(font).stringWidth(txt[i]))/2,
                Display.HEIGHT/3*2- g.getFontMetrics(font).getHeight() + 30*i);
        }
    }

    @Override
    public void keyPressed(int code) {
        if(code == 10){
            if(index == 0){
                GameStateManager.nextState();
            }else if(index == 2){
                System.exit(0);
            }
        }
    }

    @Override
    public void keyRelesed(int code) {
        if(code == 38){
            index--;
            if(index < 0){
                index = 2;
            }
        }
        if(code == 40){
             index++;
             if(index > 2){
                 index = 0;
             }
        }
    }

    @Override
    public void keyTyped(int code) {}
}
