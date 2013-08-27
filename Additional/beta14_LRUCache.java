package Additional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 用LinkedHashMap实现，重写removeEldestEntry(Map.Entry<K, V>)方法。
public class beta14_LRUCache<K, V> {
	int capacity = 1024;
	float factor = 0.75f;
	LinkedHashMap<K, V> map;

	beta14_LRUCache(int capacity) {
		this.capacity = capacity;
		map = new LinkedHashMap<K, V>(capacity, this.factor, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > beta14_LRUCache.this.capacity;
			}
		};
	}

	public synchronized void put(K key, V val) {
		map.put(key, val);
	}

	public synchronized V get(K key) {
		return map.get(key);
	}

	public synchronized void remove(K key) {
		map.remove(key);
	}

	public synchronized void clear() {
		map.clear();
	}

	public synchronized int size() {
		return map.size();
	}
}

// 从底层实现。利用HashMap和单向链表来维护，查找时若找到则把Node从表中移到表头。
class MyLRUCache<K, V> {
	class Node<P, Q> {
		P key;
		Q val;
		Node<P, Q> prev;
		Node<P, Q> next;

		Node(P key, Q val) {
			this.key = key;
			this.val = val;
			prev = null;
			next = null;
		}
	}

	int capacity = 1024;
	HashMap<K, Node<K, V>> map;
	Node<K, V> head;
	Node<K, V> tail;

	public MyLRUCache(int capa) {
		capacity = capa;
		map = new HashMap<K, Node<K, V>>();
		head = new Node<K, V>(null, null);
		tail = new Node<K, V>(null, null);
		head.next = tail;
		tail.prev = head;
	}

	public V get(K key) {
		Node<K, V> tmp = map.get(key);
		if (tmp == null)
			return null;
		if (size() > 1) { // fresh the order
			detach(tmp);
			attach(head, tmp);
		}
		return tmp.val;
	}

	public void put(K key, V val) {
		Node<K, V> tmp = map.get(key);
		if (tmp == null) { // new data
			tmp = new Node<K, V>(key, val);
			map.put(key, tmp);
			if (map.size() > capacity) { // remove eldest
				map.remove(tail.prev.key);
				detach(tail.prev);
			}
		} else {
			tmp.val = val;
			detach(tmp);
		}
		attach(head, tmp); // newest accessing
	}

	public void remove(K key) {
		Node<K, V> tmp = map.get(key);
		if (tmp != null) {
			map.remove(key);
			detach(tmp);
		}
	}

	public int size() {
		return map.size();
	}

	public void clear() {
		map.clear();
		head.next = tail;
		tail.prev = head;
	}

	private void detach(Node<K, V> node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void attach(Node<K, V> first, Node<K, V> second) {
		second.next = first.next;
		second.prev = first;
		first.next.prev = second;
		first.next = second;
	}
}