package com.amazon.datastructures;

import java.util.HashMap;import javax.crypto.SealedObject;

class TrieNode<T>{
	
	// Data for our TrieNode
	T ch;
	// Children
	HashMap<T, TrieNode<T>> children = new HashMap<T, TrieNode<T>>();
	// End of Word to be know for when to stop
	boolean isEndOfWord;
	
	// Whenever we create a TrieNode we will put data
	TrieNode(T ch){
		this.ch = ch;
	}
}

// Shall Represent Trie Data Structure
class Trie{
	
	// Have a Root Node
	TrieNode<Character> rootNode;
	
	Trie(){
		rootNode = new TrieNode<Character>('0'); // Root of our Tree :)
	}
	
	void insert(String word) {
		
		// We shall begin with rootNode
		TrieNode<Character> currentNode = rootNode;
		
		// Create Nodes out of Characters
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			TrieNode<Character> node = new TrieNode<Character>(ch);
			System.out.println(">> Node Created for "+ch);
			currentNode.children.putIfAbsent(ch, node); // we will add a character into children if not absent
			currentNode = node;
		}
		// Out of Loop means our word is finished
		currentNode.isEndOfWord = true;
		
		System.out.println("==Word "+word+" inserted in Trie==");
		System.out.println();
	}
	
	boolean search(String word) {
		
		TrieNode<Character> currentNode = rootNode;
		
		for(int i=0;i<word.length();i++) {
			if(currentNode.children.get(word.charAt(i)) == null) {
				return false;
			}
			
			currentNode = currentNode.children.get(word.charAt(i));
		}
		
		return currentNode.isEndOfWord;
	}
	
}


public class TrieApp {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		trie.insert("amazon");
		trie.insert("amazing");
		trie.insert("maze");
		trie.insert("magazine");
		
		System.out.println(">> is amazon in trie: "+trie.search("amazon"));
		System.out.println(">> is awesome in trie: "+trie.search("awesome"));
		System.out.println(">> is ama in trie: "+trie.search("ama"));

	}

}
