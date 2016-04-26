import java.io.File;
import java.util.ArrayList;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

class FileTreeModel implements TreeModel {
	ArrayList<TreeModelListener> listeners;
	FileWrap root;

	public FileTreeModel(File file) {
		listeners = new ArrayList<TreeModelListener>();
		root = new FileWrap(file);
	}

	public void addTreeModelListener(TreeModelListener l) {
		listeners.add(l);
	}

	public void removeTreeModelListener(TreeModelListener l) {
		listeners.remove(l);
	}

	public Object getChild(Object parent, int index) {
		FileWrap fw = (FileWrap) parent;
		if (fw == null) {
			return null;
		}
		String[] members = fw.list();
		return new File(fw.getValue(), members[index]);
	}

	public int getChildCount(Object parent) {
		FileWrap fw = (FileWrap) parent;
		if (fw == null)
			return 0;

		if (fw.isDirectory()) {
			return fw.list().length;
		} else {
			return 0;
		}
	}

	public int getIndexOfChild(Object parent, Object child) {
		FileWrap dir = (FileWrap) parent;
		FileWrap file = (FileWrap) child;
		String[] members = dir.list();
		int n = -1;

		for (int i = 0; i < members.length; i++) {
			if (file.getName().equals(members[i])) {
				return i;
			}
		}

		return n;

	}

	public Object getRoot() {
		return root;
	}

	public void setRoot(File f) {
		root = new FileWrap(f);
	}

	public boolean isLeaf(Object node) {
		return ((FileWrap) node).isFile();
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
	}

	public void insert(double d) {
		ArrayList<BinTree> path = root.insert(d);
		Object[] opath = path.toArray();
		TreeModelEvent e = new TreeModelEvent(this, opath);
		for (TreeModelListener tml : listeners) {
			tml.treeNodesInserted(e);
		}
	}
}
