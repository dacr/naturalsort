/*
 * Copyright 2011-2014 David Crosson, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package fr.janalyse.tools

import org.scalatest.FunSuite
import org.scalatest.ShouldMatchers
import scala.collection.immutable.TreeSet


class NaturalSortTest extends FunSuite with ShouldMatchers {
  
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
	

  test("others") {
    val t0 = new TreeSet[String]() ++ List("G1R3", "G0R1C1","G1R2C1")
    t0.toList should equal (List("G0R1C1","G1R2C1","G1R3"))
  }

  test("big number") {
    val t0 = new TreeSet[String]() ++ List("specs2-3.2-20150329233502-0653950.jar", "specs2-3.2-20150328050811-d146044.jar")
    t0.toList should equal (List("specs2-3.2-20150328050811-d146044.jar", "specs2-3.2-20150329233502-0653950.jar"))    
  }
  
	
  ignore("special cases tests") {
    // floating number natural sorting is not yet supported, 1.001 mean 1.1, 00 are ignored...
    val t5 = new TreeSet[String]() ++ List("1.3","1.001","1.010","1.02","1.1","1.002")
    t5.toList should equal (List("1.001" , "1.002" , "1.010", "1.02" , "1.1" , "1.3"))
  } 

}

