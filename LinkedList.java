public class LinkedList {
    Node headNode;

    public void addNode(int x, int y) {
        Node newNode = new Node();
        newNode.xPosition = x;
        newNode.yPosition = y;
        newNode.nextNode = headNode;
        headNode = newNode;
    }

//    It needs to change the current head node to the node that is in the head node's
//nextNode variable; and it needs to return that previous head node to the method
//caller.
//2. Essentially, you're taking the head node out of the linked list and returning it and
//setting the next node in line as the new head node.
    public Node removeNode() {
        Node eliminateNode = headNode;
        if(headNode != null) {
            headNode = headNode.nextNode;
        }
        return eliminateNode;
    }

    public Node getHeadNode() { return headNode; }
}
