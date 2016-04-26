import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ToolTipManager;

public class TreeTest implements ActionListener {
	JTextField tf;
	FileTreeModel btm;

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

		btm = new FileTreeModel();

		File[] drives = File.listRoots();
		JComboBox<File> box = new JComboBox<>(drives);
		
		JTree tree = new JTree(btm);
		ToolTipManager.sharedInstance().registerComponent(tree);
		tree.setCellRenderer(new FileTreeRenderer());
		JScrollPane scrollPane = new JScrollPane(tree);
		tf.addActionListener(this);
		f.add(box, BorderLayout.NORTH);
		f.add(tf, BorderLayout.SOUTH);
		f.add(scrollPane, BorderLayout.CENTER);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.pack();
		f.show();
	}
}
