import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

class LaunchCraft {
  public static void main(String[] args) {
    // init
    System.out.println("Hello World!");
    JFrame frame = new JFrame("LaunchCraft");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setIconImage(ImageIO.read(new File("assets/icon64.png")));
    frame.setSize(500, 300);

    // components
    
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
        if (vers == "Manage Accounts") {
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
    menu.add(account_b);
    menu.add(version_b);
    menu.add(hack_b);
    menu.add(web_b);
    menu.add(setting_b);
    frame.add(BorderLayout.EAST, menu);
    
    play.add(user);
    play.add(version);
    play.add(button);
    frame.add(BorderLayout.SOUTH, play);

    // run
    frame.setVisible(true);
    System.out.println("Done");
  }
}