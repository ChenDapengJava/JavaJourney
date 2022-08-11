package cn.chendapeng.dp.observer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 行百里者
 */
public class MyFrame extends Frame {
    public void launch() {
        Button b = new Button("press me");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        this.setLocation(400, 400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame().launch();
    }

    //Observer
    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ((Button) e.getSource()).setLabel("press me again!");
            System.out.println("button pressed!");
        }

    }

    private class MyActionListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button pressed 2!");
        }

    }
}
