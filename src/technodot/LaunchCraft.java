package src.technodot;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.imageio.*;

public class LaunchCraft {
  public static void main(String[] args) {
    // init
    System.out.println("Hello World!\nInitializing");
    JFrame frame = new JFrame("LaunchCraft");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    try {
      frame.setIconImage(ImageIO.read(new File("src/technodot/assets/icon64.png")));
    } catch(IOException e) {
      System.out.println("Warning: asset not found: icon64.png");
      e.printStackTrace();
    }
    frame.setSize(500, 300);
    
    try {
      BufferedImage dirt = ImageIO.read(new File("src/technodot/assets/dirt.png"));
      TiledImage dirt_bg = new TiledImage(dirt);
      frame.setContentPane(dirt_bg);
    } catch(IOException e) {
      System.out.println("Warning: asset not found: dirt.png");
    }
    
    // components
    
    // north
    JPanel title = new JPanel();
    title.setBackground(Color.black);
    JLabel text = new JLabel("LaunchCraft v0.0a");
    text.setForeground(Color.white);
    ImageIcon icon = new ImageIcon("src/assets/icon64.png");
    JLabel logo = new JLabel(icon);
    
    // west
    JPanel menu = new JPanel(new GridLayout(5, 1));
    JButton account_b = new JButton("Accounts");
    JButton version_b = new JButton("Versions");
    JButton hack_b = new JButton("Hacks");
    JButton web_b = new JButton("Website");
    JButton setting_b = new JButton("Settings");
    
    // south
    JPanel play = new JPanel();
    String[] users = {"TechnoDot", "Cadyn_06", "Manage Accounts"};
    JComboBox<String> user = new JComboBox<String>(users);
    String[] versions = {"1.18.2", "1.17.2", "1.16.5", "Manage Installations"};
    JComboBox<String> version = new JComboBox<String>(versions);
    JButton button = new JButton("Play");
    
    // events
    user.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        String auth = user.getSelectedItem().toString();
        if (auth == "Manage Accounts") {
          button.setEnabled(false);
          // open accounts tab
        } else {
          button.setEnabled(true);
        }
      }
    });

    version.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        String vers = version.getSelectedItem().toString();
        if (vers == "Manage Installations") {
          button.setEnabled(false);
          // open version tab
        } else {
          button.setEnabled(true);
        }
      }
    });
    
    button.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        String auth = user.getSelectedItem().toString();
        if (auth == "Manage Accounts") {
          System.out.println("Invalid Account");
          return;
        }
        String vers = version.getSelectedItem().toString();
        System.out.println("Launching Minecraft " + vers + " as " + auth);
      }
    });

    // show
    title.add(text);
    title.add(logo);
    title.setOpaque(false);
    frame.add(BorderLayout.NORTH, title);
    
    menu.add(account_b);
    menu.add(version_b);
    menu.add(hack_b);
    menu.add(web_b);
    menu.add(setting_b);
    menu.setOpaque(false);
    frame.add(BorderLayout.EAST, menu);
    
    play.add(user);
    play.add(version);
    play.add(button);
    play.setOpaque(false);
    frame.add(BorderLayout.SOUTH, play);

    // run
    frame.setVisible(true);
    System.out.println("Done");
  }
}

// https://stackoverflow.com/questions/24746354/java-jpanel-tiled-background-image
public class TiledImage extends JPanel {
  BufferedImage tile;
  public TiledImage(BufferedImage image) {
    tile = image;
  }
  protected void paintComponent(Graphics g) {
    int w = getWidth();
    int h = getHeight();
    int tw = tile.getWidth();
    int th = tile.getHeight();
    for (int x=0;x<w;x+=tw) {
      for (int y=0;y<h;y+=th) {
        g.drawImage(tile, x, y, this);
      }
    }
  }
  /*
  public static void main(String[] args) {
    // do nothing
  }
  */
}