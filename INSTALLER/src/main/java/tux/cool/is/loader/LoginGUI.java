package tux.cool.is.loader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class LoginGUI implements ActionListener {

    private static JTextField userText;
    private static JTextField pathtext;
    private static JPasswordField passwordtext;
    private static JLabel success;



    public LoginGUI() {
    }

    public static void main(String[] args) {
        // GUI stuffs
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        //username button
        panel.setLayout(null);
        JLabel userlabel = new JLabel("Username: ");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);
        //path button
        panel.setLayout(null);
        JLabel pathlabel = new JLabel("Path: ");
        pathlabel.setBounds(10, 80, 80, 25);
        panel.add(pathlabel);
        pathtext = new JTextField(20);
        pathtext.setBounds(100, 80, 165, 25);
        panel.add(pathtext);
        //password button
        panel.setLayout(null);
        JLabel passlabel = new JLabel("Password: ");
        passlabel.setBounds(10, 50, 80, 25);
        panel.add(passlabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        //makes passwords hidden (********)
        passwordtext = new JPasswordField();
        passwordtext.setBounds(100, 50, 165, 25);
        panel.add(passwordtext);

        JButton button = new JButton("INSTALL");
        button.setBounds(100, 130, 120, 25);
        button.addActionListener(new LoginGUI());
        panel.add(button);


        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

    //event handler
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String user = userText.getText();
        String password = String.valueOf(passwordtext.getPassword());
        System.out.println("USERNAME: " + user + " / " + "PASSWORD: " + password);



        if (user.equals("put user name here") && password.equals("put password here")) {  // login details, username "USERNAME", password "PASSWORD"
            success.setText("Install successful!");

            InputStream cool = null;
            OutputStream tux = null;
            String fileUrl = "https://media.discordapp.net/attachments/855052290154823711/855946345759899698/unknown.png"; //website that you're installing file from, EXAMPLE https://media.discordapp.net/attachments/855052290154823711/855946345759899698/unknown.png
            String outputPath = pathtext.getText(); //fle desination + name // EXAMPLE C:\\Users\\" + username + "\\AppData\\Roaming\\.minecraft\\mods\\tuxhack-1.6-release.jar"
            try {
                URL url = new URL(fileUrl);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
                cool = connection.getInputStream();
                tux = new FileOutputStream(outputPath);
                final byte[] b = new byte[2048];
                int length;
                while ((length = cool.read(b)) != -1) {
                    tux.write(b, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (tux != null) {
                    try {
                        tux.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (cool != null) {
                    try {
                        cool.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else success.setText("Login FAILED :(");
        System.out.println("Login FAILED :(");
            }
        }
