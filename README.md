# Util

A collection of classes and static functions with the purpose to simplify the work with java objects and data strcutures including List, Set, Map and convenience functions to cast an Object to a specific type including int, float, double, long, boolean, List, Map, and others.

The following is work-in-progress and uses [processing](http://www.processing.org) based code samples.

## sojamo.util.Common
Some usage examples of the static functions from the sojamo.util.Common class.


### Common.i()

An example of how to use the i() function to convert a Object into a primitive int. Furhtermore there are implementations available for float, double, long, char, boolean, etc.

```java

	import sojamo.util.*;
	import static sojamo.util.Common.*;
	
	Object o = new Integer(100);
	int i = i(o);
	println(i);
	
```	

### Common.toMap()

An example of how to use the toMap() function to convert a sequence of object into key-value pairs stored inside a Map. The Map returned by toMap() is a LinkedHashMap().

```java

	import java.util.*;
	import sojamo.util.*;
	import static sojamo.util.Common.*;
	
	// create and fill Map m
	Map m = toMap( "a", 1, "b", 2, "c", "three", "d", 4.2);
	
	// request and cast values from Map m
	int v0 = i(m,"a");
	int v1 = i(m,"b");	
	String v2 = s(m,"c");	
	float v3 = f(m,"d");	
	println(v0,v1,v2,v3); 
	
```

### Common.toList()

A convenience function to convert a sequence of parameters into a List.

```java

	import java.util.*;
	import sojamo.util.*;
	import static sojamo.util.Common.*;
	
	List l = toList(1,"two",3.3,5,6);
	int v0 = i(l,0);
	String v1 = s(l,1);
	println(v0,v1);
	
```

### Common.setValuesFor()

With setValuesFor() you can use the key-value pairs of a Map to set and change the state of Object variables.

```java

	import java.util.*;
	import java.util.Map.Entry;
	import sojamo.util.*;
	import static sojamo.util.Common.*;

	void setup() {
	  // create and fill Map m
	  Map m = toMap( "a", 1, "b", 2, "c", "three", "d", 4.2);
	  println(m);
	  
	  // instantiate a new Test Object
	  Test t = new Test();
	  // set variables based on Map m's entrySet
	  setValuesFor(t,m);
	  println(t);
	  
	  Map m1 = toMap();
	  setValuesFor(m1,m);
	  println(m1);
	  
	}

	class Test {
	  float a;
	  float b;
	  String c;
	  float d;
	  String toString() {
	    return "Test: "+a+" "+b+" "+c+" "+d;
	  }
	}

```
