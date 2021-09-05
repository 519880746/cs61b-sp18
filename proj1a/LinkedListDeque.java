public class LinkedListDeque<T>{
    private TNode sentinel;
    private int size;


    private class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque(){
        sentinel = new TNode (null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size =0;

        }


    public void addFirst(T x){
        TNode newNode = new TNode(sentinel, x, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T x){
        TNode newNode =new TNode(sentinel.prev, x, sentinel);
            sentinel.prev.next = newNode;
            sentinel.prev = newNode;
            size++;
        
    }

    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;

    }
    
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return res;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size --;
        return res;
    }

    public T get(int x){
        if (size< x){
            return null;
        }
        TNode P = sentinel.next;
        while (x>0){
            P= P.next;
            x--;
        }
        return P.item;
    }

    public T getRecursive(int index){
        if (size< index){
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(TNode node, int i){
        if (i==0){
            return node.item;
        }
        return getRecursive(node.next, i-1);
    }
    public void printDeque() {
        TNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item);
            p = p.next;
        }
    }


}