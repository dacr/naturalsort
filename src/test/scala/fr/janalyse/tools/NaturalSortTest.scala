/*
 * Copyright 2011-2020 David Crosson, Inc.
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

import org.scalatest.flatspec._
import org.scalatest.matchers._
import scala.collection.immutable.TreeSet // Using  this collection with natural sort ordering


class NaturalSortTest extends AnyFlatSpec with should.Matchers {

  import fr.janalyse.tools.NaturalSort._ // Set a new "default" sorting which will be used by TreeSet

  "natural sort" should "sort basic lists in the classic way" in {
    val t0 = new TreeSet[String]() ++ List("a")
    t0.toList should equal(List("a"))
    val t1 = new TreeSet[String]() ++ List("c", "b", "a")
    t1.toList should equal(List("a", "b", "c"))
  }

  it should "place the empty string on the head" in {
    val t0 = new TreeSet[String]() ++ List("A", "", "0")
    t0.toList should equal(List("", "0", "A"))
  }

  it should "sort integer numbers list in natural fashion" in {
    val t0 = new TreeSet[String]() ++ List("10", "5", "1")
    t0.toList should equal(List("1", "5", "10"))
  }

  it should "sort composed string/integer list in natural way" in {
    val t0 = new TreeSet[String]() ++ List("a-100", "a-10", "a-5", "a-1")
    t0.toList should equal(List("a-1", "a-5", "a-10", "a-100"))
  }

  it should "sort mixed strings correctly" in {
    val t0 = new TreeSet[String]() ++ List("1.10.1", "02.1.2", "a100", "1.100.2", "2.0", "", "a10", "a1", "a5", "1.9.1")
    t0.toList should equal(List("", "1.9.1", "1.10.1", "1.100.2", "2.0", "02.1.2", "a1", "a5", "a10", "a100"))

    val t1 = new TreeSet[String]() ++ List("a20", "a0", "a1", "a1b", "a1a", "a10", "a", "a2")
    t1.toList should equal(List("a", "a0", "a1", "a1a", "a1b", "a2", "a10", "a20"))

    val t2 = new TreeSet[String]() ++ List("x2-g8", "x2-y7", "x2-y08", "x8-y8")
    t2.toList should equal(List("x2-g8", "x2-y7", "x2-y08", "x8-y8"))
  }

  it should "sort special release numbering" in {
    val t0 = new TreeSet[String]() ++ List("h1q3", "h0q1r1", "h1q2r1")
    t0.toList should equal(List("h0q1r1", "h1q2r1", "h1q3"))
  }

  it should "be able to sort big numbers in a natural way" in {
    val t0 = new TreeSet[String]() ++ List("specs2-3.2-20150329233502-0653950.jar", "specs2-3.2-20150328050811-d146044.jar")
    t0.toList should equal(List("specs2-3.2-20150328050811-d146044.jar", "specs2-3.2-20150329233502-0653950.jar"))
  }

  it should "take into account floating numbers ???" ignore {
    // floating number natural sorting is not yet supported, 1.001 mean 1.1, 00 are ignored...
    val t5 = new TreeSet[String]() ++ List("1.3", "1.001", "1.010", "1.02", "1.1", "1.002")
    t5.toList should equal(List("1.001", "1.002", "1.010", "1.02", "1.1", "1.3"))
  }

}

