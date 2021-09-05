public class ArrayDeque<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size = 0;

    public  ArrayDeque() {
        items  = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;

    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;

    }

    private int addOnePos(int a) {
        return (a + 1 ) % items.length;
    }
    private int subOnePos(int a) {
        return (a-1+items.length) % items.length;
    }

    private void resize(int length) {
        T[] a = (T[]) new Object[length];

        for(int i=0; i<size; i++) {
            a[i] = items[addOnePos(nextFirst)];
            nextFirst=addOnePos(nextFirst);
        }
        items = a;
        nextFirst = items.length-1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size== items.length){
            resize(items.length*2);
        }
        items[nextFirst]= item;
        nextFirst = subOnePos(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (size== items.length){
            resize(items.length*2);
        }
        items[nextLast]= item;
        nextLast = addOnePos(nextLast);
        size++;
    }


    public void printDeque() {
        int i = addOnePos(nextFirst);
        for (int j=0; j<size; j++){
            System.out.println(items[i]);
            i = addOnePos(i);
        }
    }

    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        T a = items[addOnePos(nextFirst)];

        nextFirst = addOnePos(nextFirst);
        size --;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }

        return a;

    }
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T a = items[subOnePos(nextLast)];

        nextLast= subOnePos(nextLast);
        size--;
        if ( items.length>= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a ;

    }

    public T get(int index){
        if(index>size)
            return null;
        return items[addOnePos((index+addOnePos(nextFirst)) % items.length)];
    }
}