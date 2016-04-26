import java.util.ArrayList;

class BinTree {

	double value;
	BinTree left;
	BinTree right;

	public BinTree() {
		value = 0;
		left = null;
		right = null;
	}

	public BinTree(double d) {
		value = d;
		left = new BinTree();
		right = new BinTree();
	}

	public ArrayList<BinTree> insert(double d) {
		ArrayList<BinTree> path;
		if (isNull()) {
			value = d;
			left = new BinTree();
			right = new BinTree();
			path = new ArrayList<BinTree>();
			path.add(left);
		} else {
			if (d < value) {
				path = left.insert(d);
			} else {
				path = right.insert(d);
			}
		}
		path.add(0, this);
		return path;
	}

	public String toString() {
		if (isNull()) {
			return "[null]";
		}
		return "[" + value + "]";
	}

	public boolean isNull() {
		return (left == null);
	}

	public int getDepth() {
		if (isNull()) {
			return 1;
		}
		int l = left.getDepth();
		int r = right.getDepth();
		int m = (l > r) ? l : r;
		return m + 1;
	}
}
