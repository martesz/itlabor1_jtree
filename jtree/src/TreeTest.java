import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class TreeTest implements  ActionListener{
    JTextField tf;
    BinTreeModel btm;
    public void actionPerformed(ActionEvent ae) {
	double d = Double.parseDouble(tf.getText());
	btm.insert(d);
	tf.setText("");
    }
    static public void main(String args[]) {
	(new TreeTest()).run();
    }
    public void run() {
	JFrame f = new JFrame("JTree Example");
	tf = new JTextField("", 20);

	btm = new BinTreeModel();

	JTree tree = new JTree(btm);
	ToolTipManager.sharedInstance().registerComponent(tree);
	tree.setCellRenderer(new BinTreeRenderer());
	JScrollPane scrollPane = new JScrollPane(tree);
	tf.addActionListener(this);
	f.add(tf, BorderLayout.SOUTH);
	f.add(scrollPane, BorderLayout.CENTER);
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	f.pack();
	f.show();
    }
}
