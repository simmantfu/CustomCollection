
public class CustomBinaryTree<V> {

	private static boolean entryFlag = true;

	private static int count = 0;

	BinaryEntryNode<V> root = null;

	public void put(V value) {

		if (this.root == null) {

			this.root = new BinaryEntryNode<V>(value);
		} else {

			this.root.put(value);
		}

	}

	public void print() {
		this.root.print();
	}

	public boolean search(V data) {
		return this.root.search(data);
	}

	
	public void maxHeap(){
		this.root.maxHeap();
	}
	
	
	private class BinaryEntryNode<V> {

		BinaryEntryNode<V> right;
		BinaryEntryNode<V> left;

		V value;
		int count;

		private BinaryEntryNode(V value) {
			CustomBinaryTree.count++;
			this.value = value;
			this.count = CustomBinaryTree.count;
		}

		private void put(V value) {

			if (CustomBinaryTree.entryFlag) {

				CustomBinaryTree.entryFlag = false;
				if (this.left == null) {
					this.left = new BinaryEntryNode<V>(value);
				} else {
					this.left.put(value);
				}

			} else {
				CustomBinaryTree.entryFlag = true;
				if (this.right == null) {
					this.right = new BinaryEntryNode<V>(value);
				} else {
					this.right.put(value);
				}

			}

		}

		private void print() {
			System.out.println(this.value + " count : " + this.count);

			if (this.left != null) {

				this.left.print();

			}

			if (this.right != null) {
				this.right.print();
			}

		}

		private void maxHeap() {

			if (this.left != null) {
				if ((int)this.value < (int)this.left.value) {
					V data = this.value;
					this.value = this.left.value;
					this.left.value = data;
				}
				
				
				this.left.maxHeap();
			} 

			if (this.right != null) {
				if ((int)this.value < (int)this.right.value) {
					V data = this.value;
					this.value = this.right.value;
					this.right.value = data;
				}
				
				this.right.maxHeap();
			} 

		}

		
		
		
		private boolean search(V data) {

			if (this.value.equals(data)) {

				return true;
			}

			if (this.left != null) {

				if (this.left.value.equals(data)) {

					return true;
				} else {
					this.left.search(data);
				}

			}

			if (this.right != null) {

				if (this.right.value.equals(data)) {

					return true;
				} else {
					this.right.search(data);
				}

			}

			return false;

		}

	}

	public static void main(String... strings) {

		CustomBinaryTree<Integer> cbt = new CustomBinaryTree<>();
		cbt.put(1);
		cbt.put(2);
		cbt.put(3);
		cbt.put(4);
		cbt.put(5);
		cbt.put(6);
		cbt.put(7);
		cbt.put(8);
		cbt.put(9);

		
		// cbt.search(2);

		cbt.maxHeap();
		cbt.maxHeap();
		cbt.maxHeap();
		cbt.maxHeap();
		cbt.maxHeap();
		cbt.print();
		
		System.out.println("" + cbt.search(2) + "");
	}

}
