import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main {

    public static void main(String[] args) {
        //new Main();
        Resolution [] res = new Resolution[4];

        res[0] = new Resolution("640x480", 640, 480);
        res[1] = new Resolution("800x600", 800, 600);
        res[2] = new Resolution("1024x768", 1024, 768);
        res[3] = new Resolution("1200x700", 1200, 700);


        ImageIcon icon = new ImageIcon("src/иконка.png");

        JFrame frame = new JFrame("Пробел");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.setLocation(400,300);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                UIManager.put("OptionPane.yesButtonText", "Да");
                UIManager.put("OptionPane.noButtonText", "Нет");
                if (e.getKeyCode()==KeyEvent.VK_SPACE) {
                    Resolution r = (Resolution) JOptionPane.showInputDialog(null, "Выберите разрешение:", "Выбор разрешения нового окна", JOptionPane.QUESTION_MESSAGE, icon, res, res[2]);
                    JFrame x = new JFrame(r.name);
                    x.setSize(r.width, r.height);
                    x.setLocation(50,10);
                    x.setVisible(true);
                }
            }
        });
        frame.setVisible(true);
    }
}

class Resolution {
    String name;
    int width;
    int height;
    Resolution (String s, int w, int h) {
        this.width = w;
        this.name = s;
        this.height = h;
    }

    @Override
    public String toString() {
        return name;
    }
}