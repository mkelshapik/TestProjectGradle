# TestProjectGradle
Hello! 
I create this project for studying goal. I want to master working with git, gitHub, JUnit, Gradle, Jacoco and to get a main principles "how do collections work".
Below I leave a list of collections that i`ve implemented with time and space complexity with bigO notation.
- ArrayList
	The ArrayList is backed by an array. It means next:
		- add() – takes O(1) time. However, worst-case scenario, when a new array has to be created and all the elements copied to it, is O(n);
		- add(index, element) – it runs in O(n) time
		- get() – is always a constant time O(1) operation;
		- remove() – runs in linear O(n) time. We have to iterate the entire array to find the element qualifying for removal;
		- indexOf()  – also runs in linear time. It iterates through the internal array and checking each element one by one. So the time complexity for this operation always requires O(n) time;
		- contains() – implementation is based on indexOf(). So it will also run in O(n) time;
- LinkedList
	LinkedList is a linear data structure that consists of nodes holding a data field and a reference to another node.
		- add() – appends an element to the end of the list. So it only updates a tail, therefore O(1) constant-time complexity;
		- add(index, element) – it runs in O(n) time; 
		- get() – searching for an element takes O(n) time;
		- remove(element) - to remove an element, we first need to find it, it runs in O(n) time; 
		- remove(index) - time complexity is equals to remove(element) method. It is O(n); 
		- contains() – also has O(n) time complexity;
- HashMap
	A map is a key-value mapping, which means that every key is mapped to exactly one value and that we can use the key to retrieve the corresponding value from a map.
		- put(key, value) - the method has O(1) time complexity, but if we need increase size or we a few object with same hash code, time compexity is O(n);
		- get(key) - has same complexity with put(), in better case it O(1), worst case O(n);
		- remove(key), containsKey(key), containsValue(value) - have same complexity with put(), in better case it O(1), worst case O(n);
- HashSet
	HashSet stores the elements by using a hashMap mechanism. HashSet contains unique elements only.
		- add(element), remove(element) - it have O(n) time because, at first we have to check if we have same element in our collection, and then we can add/remove our element; 
		- contains(element) - in better case it O(1), worst case O(n);
- Heap
	A max-heap/min is a complete binary tree in which the value in each internal node is greater/less than or equal to the values in the children of that node. Mapping the elements of a heap into an array is trivial: if a node is stored an index k, then its left child is stored at index 2k+1 and its right child at index 2k+2.
		- add(element) - takes O(1) time. However, worst-case scenario, when a new array has to be created and all the elements copied to it, is O(n);
		- poll() - it has O(log n) time;
		- peek() - it has O(1) time;
- Queue
	The Queue used to hold the elements about to be processed in FIFO(First In First Out) order. My collection consists of nodes holding a data field and a reference to another node.
		- offer(value) – appends an element to the end of the list. So it only updates a tail, therefore O(1) constant-time complexity;
		- peek() - it runs O(1) time;
		- poll() - delete an element from the end of the list. Time complexity is O(1);
- Stack
	The Stack used to hold the elements about to be processed in LIFO(Last In First Out) order. My collection consists of nodes holding a data field and a reference to another node. 
		- push(value) - appends an element at start of the list > time complexity is O(1);
		- peek() - return head. It runs O(1) time;
		- poll() - delete an element from the head of the list. Time complexity is O(1);
