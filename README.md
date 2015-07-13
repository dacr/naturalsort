# NaturalSort API

Natural (human) sorting algorithm : ["a1", "a3", "a10", "a2", "a21"] will be sorted as ["a1", "a2", "a3", "a10", "a21"] and not ["a1", "a10", "a2", "a21", "a3"]. It merges alphabetical and numeric sorting.

Usage examples coming from test cases :

```
  import fr.janalyse.tools.NaturalSort._
  
  test("monkey tests") {
    val t0 = new TreeSet[String]() ++ List("")
    t0.toList should equal (List(""))
    
    val t1 = new TreeSet[String]() ++ List("", "A", "0")
    t1.toList should equal (List("", "0", "A"))
  }
  

  test("basic tests") {
    val t0 = new TreeSet[String]() ++ List("10", "5", "1")
    t0.toList should equal (List("1", "5", "10"))
  
    val t1 = new TreeSet[String]() ++ List("a-100","a-10", "a-5", "a-1")
    t1.toList should equal (List("a-1", "a-5", "a-10", "a-100"))
  }
	
	
  test("advanced tests") {
    val t2 = new TreeSet[String]() ++ List("1.10.1","02.1.2","a100","1.100.2","2.0","","a10","a1","a5","1.9.1")
    t2.toList should equal (List("","1.9.1","1.10.1","1.100.2","2.0","02.1.2","a1","a5","a10","a100"))
		
    val t3 = new TreeSet[String]() ++ List("a20", "a0","a1","a1b","a1a","a10","a","a2")
    t3.toList should equal (List("a", "a0", "a1", "a1a", "a1b", "a2", "a10", "a20"))
		
    val t4 = new TreeSet[String]() ++ List("x2-g8",  "x2-y7" , "x2-y08" , "x8-y8")
    t4.toList should equal (List("x2-g8", "x2-y7", "x2-y08", "x8-y8"))
  }
```
