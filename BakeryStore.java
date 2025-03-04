import javax.swing.*;
import java.awt.*;

public class BakeryStore {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bakery Production");
        frame.getContentPane().setBackground(Color.PINK);
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("<Bakery>");
        label.setBounds(110, 20, 200, 50);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        frame.add(label);

        JButton labelIng = new JButton("INGREDIENTS");
        labelIng.setBackground(Color.MAGENTA);
        labelIng.setForeground(Color.WHITE);
        labelIng.setBounds(100, 80, 200, 50);
        labelIng.setFont(new Font("Arial", Font.ITALIC, 20));
        frame.add(labelIng);

        JButton labelBread = new JButton("MAKE BREAD");
        labelBread.setBackground(Color.MAGENTA);
        labelBread.setForeground(Color.WHITE);
        labelBread.setBounds(100, 150, 200, 50);
        labelBread.setFont(new Font("Arial", Font.ITALIC, 20));
        frame.add(labelBread);

        JButton labelCounter = new JButton("COUNTER");
        labelCounter.setBackground(Color.MAGENTA);
        labelCounter.setForeground(Color.WHITE);
        labelCounter.setBounds(100, 220, 200, 50);
        labelCounter.setFont(new Font("Arial", Font.ITALIC, 20));
        frame.add(labelCounter);

        labelIng.addActionListener(e -> {
            JDialog dialog = new JDialog(frame, "Ingredients", true);
            dialog.getContentPane().setBackground(Color.YELLOW);
            dialog.setSize(500, 200);
            dialog.setLayout(null);
            dialog.setLocationRelativeTo(frame);
            JLabel label2 = new JLabel("INGREDIENTS");
            label2.setBounds(170, 10, 300, 50);
            label2.setFont(new Font("Arial", Font.BOLD, 20));
            dialog.add(label2);
            JButton buttonInv = new JButton("CHECK INVENTORY");
            buttonInv.setBackground(Color.MAGENTA);
            buttonInv.setForeground(Color.WHITE);
            buttonInv.setFont(new Font("Arial", Font.ITALIC, 15));
            buttonInv.setBounds(30, 70, 200, 60);
            dialog.add(buttonInv);
            JButton buttonAdd = new JButton("ADD INVENTORY");
            buttonAdd .setBackground(Color.MAGENTA);
            buttonAdd .setForeground(Color.WHITE);
            buttonAdd .setFont(new Font("Arial", Font.ITALIC, 15));
            buttonAdd .setBounds(250, 70, 200, 60);
            dialog.add(buttonAdd);
            
            dialog.setVisible(true);
        });

        labelBread.addActionListener(e -> {
            JDialog dialog2 = new JDialog(frame, "Breads", true);
            dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog2.setSize(500, 350);
            dialog2.getContentPane().setBackground(Color.ORANGE);
            dialog2.setLayout(null);
            dialog2.setLocationRelativeTo(frame);
            JLabel label1 = new JLabel("BREADS");
            label1.setBounds(170, 10, 200, 50);
            label1.setFont(new Font("Arial", Font.BOLD, 40));
            dialog2.add(label1);
            JButton bread1 = new JButton("PANDESAL");
            bread1.setBackground(Color.MAGENTA);
            bread1.setForeground(Color.WHITE);
            bread1.setFont(new Font("Arial", Font.ITALIC, 20));
            bread1.setBounds(30, 70, 200, 60);
            dialog2.add(bread1);
        
            JButton bread2 = new JButton("MAMON");
            bread2.setBackground(Color.MAGENTA);
            bread2.setForeground(Color.WHITE);
            bread2.setFont(new Font("Arial", Font.ITALIC, 20));
            bread2.setBounds(260, 70, 200, 60);
            dialog2.add(bread2);
        
            JButton bread3 = new JButton("LOAF");
            bread3.setBackground(Color.MAGENTA);
            bread3.setForeground(Color.WHITE);
            bread3.setFont(new Font("Arial", Font.ITALIC, 20));
            bread3.setBounds(30, 150, 200, 60);
            dialog2.add(bread3);
        
            JButton bread4 = new JButton("ENSAYMADA");
            bread4.setBackground(Color.MAGENTA);
            bread4.setForeground(Color.WHITE);
            bread4.setFont(new Font("Arial", Font.ITALIC, 20));
            bread4.setBounds(260, 150, 200, 60);
            dialog2.add(bread4);
        
            JButton bread5 = new JButton("SPANISH ROLL");
            bread5.setBackground(Color.MAGENTA);
            bread5.setForeground(Color.WHITE);
            bread5.setFont(new Font("Arial", Font.ITALIC, 20));
            bread5.setBounds(140, 230, 200, 60);
            dialog2.add(bread5);
        
            dialog2.setVisible(true);
        });

        labelCounter.addActionListener(e -> {
            JDialog dialog2 = new JDialog(frame, "Counter", true);
            dialog2.getContentPane().setBackground(Color.LIGHT_GRAY);
            dialog2.setSize(350, 350);
            dialog2.setLocationRelativeTo(frame);
            dialog2.setLayout(null); 
        
            JLabel counter = new JLabel("COUNTER");
            counter.setBounds(90, 10, 200, 50); 
            counter.setFont(new Font("Arial", Font.BOLD, 30));
            counter.setForeground(Color.BLACK);
            dialog2.add(counter);
        
            JButton buttonDiscount = new JButton("DISCOUNT");
            buttonDiscount.setBackground(Color.MAGENTA);
            buttonDiscount.setForeground(Color.WHITE);
            buttonDiscount.setFont(new Font("Arial", Font.ITALIC, 20));
            buttonDiscount.setBounds(75, 80, 200, 50);
            dialog2.add(buttonDiscount);
        
            JButton buttonRegular = new JButton("REGULAR");
            buttonRegular.setBackground(Color.GREEN);
            buttonRegular.setForeground(Color.WHITE);
            buttonRegular.setFont(new Font("Arial", Font.ITALIC, 20));
            buttonRegular.setBounds(75, 140, 200, 50);
            dialog2.add(buttonRegular);
        
            JButton buttonVoid = new JButton("VOID");
            buttonVoid.setBackground(Color.RED);
            buttonVoid.setForeground(Color.WHITE);
            buttonVoid.setFont(new Font("Arial", Font.ITALIC, 20));
            buttonVoid.setBounds(75, 200, 200, 50);
            dialog2.add(buttonVoid);
        
            dialog2.setVisible(true);
        });
        frame.setVisible(true);
    }
}