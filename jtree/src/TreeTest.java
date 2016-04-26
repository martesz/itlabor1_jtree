import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ToolTipManager;

public class TreeTest implements ActionListener {

	FileTreeModel ftm;
	JComboBox<File> box;

	public void actionPerformed(ActionEvent ae) {
		int selected = box.getSelectedIndex();
		ftm.setRoot(box.getItemAt(selected));
	}

	static public void main(String args[]) {
		(new TreeTest()).run();
	}

	public void run() {
		JFrame f = new JFrame("JTree Example");

		File[] drives = File.listRoots();
		box = new JComboBox<File>(drives);
		box.addActionListener(this);

		ftm = new FileTreeModel(box.getItemAt(0));

		JTree tree = new JTree(ftm);
		ToolTipManager.sharedInstance().registerComponent(tree);
		tree.setCellRenderer(new FileTreeRenderer());
		JScrollPane scrollPane = new JScrollPane(tree);
		
		f.add(box, BorderLayout.NORTH);
		f.add(scrollPane, BorderLayout.CENTER);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.pack();
		f.show();
	}
}
