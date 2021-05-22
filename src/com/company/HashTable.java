package com.company;

import java.util.ArrayList;

public class HashTable<K,V> {
    private class HashNode<K, V> {
        public K Key;
        public V Value;
        public HashNode<K, V> next;
    }

    ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
    int numBuckets = 10,size;

    public HashTable() {
        for (int i = 0; i < numBuckets; i++) {
            bucket.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        int hashCod = key.hashCode();
        return Math.abs(hashCod % numBuckets);
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(index);
        while (head != null) {
            if (head.Key.equals(key)) {
                return head.Value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(index);
        if (head == null) {
            return null;
        }
        if (head.Key.equals(key)) {
            V val = head.Value;
            head = head.next;
            bucket.set(index, head);
            size--;
            return val;
        } else {
            HashNode<K, V> prev = null;
            while (head != null) {

                if (head.Key.equals(key)) {
                    prev.next = head.next;
                    size--;
                    return head.Value;
                }
                prev = head;
                head = head.next;
            }
            return null;
        }
    }

    public void put(K key, V value) {

        int index = getBucketIndex(key);
        System.out.println(index);
        HashNode<K, V> head = bucket.get(index);
        HashNode<K, V> toAdd = new HashNode<>();
        toAdd.Key = key;
        toAdd.Value = value;
        if (head == null) {
            bucket.set(index, toAdd);
            size++;

        } else {
            while (head != null) {
                if (head.Key.equals(key)) {
                    head.Value = value;
                    size++;
                    break;
                }
                head = head.next;
            }
            if (head == null) {
                head = bucket.get(index);
                toAdd.next = head;
                bucket.set(index, toAdd);
                size++;
            }
        }
        if ((1.0 * size) / numBuckets > 0.7) {

            ArrayList<HashNode<K, V>> tmp = bucket;
            bucket = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            for (int i = 0; i < numBuckets; i++) {
                bucket.add(null);
            }
            for (HashNode<K, V> headNode : tmp) {
                while (headNode != null) {
                    put(headNode.Key, headNode.Value);
                    headNode = headNode.next;
                }
            }


        }

    }
}
