package example2;

public class MySetImple<T> implements HomeworksMethods<T> {
    private MyArrayList<T> elements;

    public void MySetImpl() {
        elements = new MyArrayList<>();
    }

    @Override
    public boolean put(T element) {
        if(contains(element)) {
            return false;
        }
        elements.add(element);
        return true;
    }

    @Override
    public boolean remove(T element) {
        return elements.remove(element);
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < elements.size(); i++) {
            T currentElement = elements.findByIndex(i);
            if (currentElement.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void printMySet() {
        System.out.println("MySet");
        elements.printList();
    }
}
