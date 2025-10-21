public class HashMapTest {

    public static void main(String args[]) {

        HashMap<Integer, Integer> map = new HashMap();

        map.put(1, 1);
        map.put(2, 3);
        map.put(1, 3);
        map.put(3, 4);

        map.get(1);
        map.get(3);
    }

    static class HashMap<K, V> {

        class Entry<K, V> {
            private K key;
            private V value;

            private Entry<K, V> next;

            public Entry(K _key, V _value) {
                key = _key;
                value = _value;
            }
        }

        private int size;
        private Entry<K, V>[] tab;

        public HashMap() {
            size = 16;
            tab = new Entry[size];
        }

        public HashMap(int _size) {
            size = ((_size / 16) + 1) * 16;
            tab = new Entry[size];
        }

        public void put(K _key, V _value) {
            int pos = getKeyPos(_key);
            appendToTab(pos, _key, _value);
        }

        public V get(K _key) {
            int pos = getKeyPos(_key);
            Entry<K,V> entry = tab[pos];
            if (entry == null) return null;

            while (entry != null) {
                if(entry.key.equals(_key)) return entry.value;
                entry = entry.next;
            }
            return null;
        }

        private void appendToTab(int pos, K _key, V _value) {
            Entry entry = tab[pos];
            if (entry == null) {
                tab[pos] = new Entry<>(_key, _value);
                return;
            }
            Entry prev = entry;
            while (entry != null) {
                if (entry.key.equals(_key)) {
                    entry.value = _value;
                    return;
                }
                prev = entry;
                entry = entry.next;
            }
            prev.next = new Entry<>(_key, _value);
        }

        private int getKeyPos(K key) {
            return  Math.abs(key.hashCode() % size);
        }

        public int getSize() {
            return size;
        }
    }
}
