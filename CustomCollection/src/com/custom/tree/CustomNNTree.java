
public class CustomNNTree<V> {

	static int count = 0;

	CustomNNTreeNode<V> customNNTreeNode;

	public void put(V data) {

		if (this.customNNTreeNode == null) {
			this.customNNTreeNode = new CustomNNTreeNode<V>(data);
		} else {
			this.customNNTreeNode.put(data);
		}

	}
	
	
	public void print(){
		if(this.customNNTreeNode!=null){
		this.customNNTreeNode.print();
		}else{
			System.out.println("Node is Emty!!!");
		}
	}
	

	private class CustomNNTreeNode<V> {

		CustomNNTreeNode<V> firstNode;
		CustomNNTreeNode<V> secondNode;
		CustomNNTreeNode<V> thridNode;
		CustomNNTreeNode<V> forthNode;
		CustomNNTreeNode<V> fifthNode;
		CustomNNTreeNode<V> sixthNode;

		V data;

		protected CustomNNTreeNode(V data) {
			this.data = data;
		}

		protected void put(V data) {

			switch (CustomNNTree.count) {

			case 0: {
				CustomNNTree.count++;
				if (this.firstNode == null) {
					this.firstNode = new CustomNNTreeNode<V>(data);
				} else {
					this.firstNode.put(data);
				}
				break;
			}

			case 1: {
				CustomNNTree.count++;
				if (this.secondNode == null) {
					this.secondNode = new CustomNNTreeNode<V>(data);
				} else {
					this.secondNode.put(data);
				}
				break;

			}

			case 2: {

				CustomNNTree.count++;
				if (this.thridNode == null) {
					this.thridNode = new CustomNNTreeNode<V>(data);
				} else {
					this.thridNode.put(data);
				}
				break;

			}

			case 3: {

				CustomNNTree.count++;
				if (this.forthNode == null) {
					this.forthNode = new CustomNNTreeNode<V>(data);
				} else {
					this.forthNode.put(data);
				}
				break;
			}

			case 4: {

				CustomNNTree.count++;
				if (this.fifthNode == null) {
					this.fifthNode = new CustomNNTreeNode<V>(data);
				} else {
					this.fifthNode.put(data);
				}
				break;

			}

			case 5: {

				CustomNNTree.count = 0;
				if (this.sixthNode == null) {
					this.sixthNode = new CustomNNTreeNode<V>(data);
				} else {
					this.sixthNode.put(data);
				}
				break;

			}

			}

		}

		protected void print() {

			System.out.println(this.data);
			if (this.firstNode != null) {
				this.firstNode.print();
			}

			if (this.secondNode != null) {
				this.secondNode.print();
			}

			if (this.thridNode != null) {
				this.thridNode.print();
			}

			if (this.forthNode != null) {
				this.forthNode.print();
			}

			if (this.fifthNode != null) {
				this.fifthNode.print();
			}

			if (this.sixthNode != null) {
				this.sixthNode.print();
			}

		}

	}

}
