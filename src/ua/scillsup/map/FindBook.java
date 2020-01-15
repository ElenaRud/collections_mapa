package ua.scillsup.map;

public class FindBook<K, Val> implements Books<K, Val> {
    private Node<K, Val>[] hashTable;
    private int size = 0;
    private float threshold;

    public FindBook() {
        hashTable = new Node[16];
        threshold = hashTable.length * 0, 75f;
    }

    public boolean insert(final K key, final Val value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K, Val> newNode = new Node<>(key, value);
        int index = newNode.hash();

        if (hashTable[index] == null) {
            return simleAdd(index, newNode);
        }

        List<Node<K, Val>> nodeList = hashTable[index].getNodes();

        for (Node<K, Val> node : nodeList) {
            if (keyExistAnotherVal(node, newNode, value) ||
                    collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;
    }

    private boolean simpleAdd(int index, Node<K, Val> newNode) {
        hashTable[index] = new Node<>(null, null);
        hashTable[index].getNodes().add(newNode);
        size++;
        return true;
    }

            return false;
    }

    private boolean keyExistAnotherVal(
            final Node<K, Val> nodeFromList,
            final Node<K, Val> newNode,
            final V value){
    if (newNode.getKey().equals(nodeFromList.getKey()) &&
            (!newNode.getValue().equals(nodeFromList.getValue())
            ){
        nodeFromList.setValue(value);
        return true;
        }
    return false;
    }

    private boolean colissionProcessing(
            final Node<K, Val> nodeFromList,
            final Node<K, Val> newNode,
            final List<Node<K, Val>> nodes) {

    }
}



