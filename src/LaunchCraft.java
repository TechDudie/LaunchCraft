import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LaunchCraft {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    
    JFrame frame = new JFrame("LaunchCraft");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    
    JPanel panel = new JPanel();
    String[] users = {"TechnoDot", "Cadyn_06", "Manage Accounts"};
    JComboBox<String> user = new JComboBox<String>(users);
    user.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        String auth = user.getSelectedItem().toString();
        if (auth == "Manage Accounts") {
          System.out.println("Starting Microsoft Login");

          // login
        }
      }
    });
    String[] versions = {"1.18.2", "1.17.2", "1.16.5"};
    JComboBox<String> version = new JComboBox<String>(versions);
    JButton button = new JButton("Play");
    button.addActionListener(new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        String auth = user.getSelectedItem().toString();
        if (auth == "Manage Accounts") {
          System.out.println("Invalid Account");
        }
        String vers = version.getSelectedItem().toString();
        System.out.println("Launching Minecraft " + vers + " as " + auth);
      }
    });
    
    panel.add(user);
    panel.add(version);
    panel.add(button);
    frame.add(BorderLayout.SOUTH, panel);
    
    frame.setVisible(true);
  }
}