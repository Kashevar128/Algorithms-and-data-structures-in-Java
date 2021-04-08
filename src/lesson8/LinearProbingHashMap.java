package lesson8;

public class LinearProbingHashMap<Key, Value> {
    private int capacity;
    private int size;
    private final double LOAD_FACTOR = 0.75;
    private final Object DELETED;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        DELETED = new Object();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(Key key) {
        return 7 - Math.abs(key.hashCode() % 7);
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void checkLoadFactor() {
        double loadFactor = (double) size / capacity;
        if (loadFactor > LOAD_FACTOR) {
            capacity = (int) (capacity * 2);
            int count = 0;
            while (count > 2) {
                for (int j = 1; j <= capacity; j++) {
                    if(capacity % j == 0) {
                        count++;
                    }
                }
                if (count != 2) capacity++;
            }
            Key[] newKeys = (Key[]) new Object[capacity];
            Value[] newValues = (Value[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                int h = hash(keys[i]);
                int step = 1;
                while (newKeys[h] != null){
                    h = (h+step) % capacity;
                }
                newKeys[h] = keys[i];
                newValues[h] = values[i];
            }
        }
    }

    public void put(Key key, Value value){
        // проверка на прввышение лоад фактора. Либо просаем эксепшн либо
        // перехиширование на массив размером больше, но простое число
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;
        while (keys[i] != null){
            if(keys[i].equals(key)){
                values[i]= value;
                return;
            }
            i = (i+step) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;

        while (keys[i] != null){
            if(keys[i].equals(key)){
                return values[i];
            }
            i = (i+step) % capacity;
        }
        return null;
    }
}
