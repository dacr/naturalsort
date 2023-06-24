/*
 * Copyright 2011-2023 David Crosson, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.janalyse.tools

import scala.annotation.tailrec

object NaturalSort {

  implicit val ord: Ordering[String] = new Ordering[String] {
    //def groupIt(str:String) = if (str.nonEmpty && str.head.isDigit) str.takeWhile(_.isDigit) else str.takeWhile(!_.isDigit)
    def groupIt(str: String): String = if (str.nonEmpty && str.head.isDigit) str.takeWhile(_.isDigit) else str.substring(0, if (str.nonEmpty) 1 else 0)

    private val dec = """(\d+)""".r

    @tailrec
    def compare(str1: String, str2: String): Int = {
      (groupIt(str1), groupIt(str2)) match {
        case ("", "") => 0
        case (dec(x), dec(y)) if x.toLong == y.toLong => compare(str1.substring(x.length), str2.substring(y.length))
        case (dec(x), dec(y)) => x.toLong - y.toLong match {
          case 0L => 0
          case x if x < 0 => -1
          case _ => 1
        }
        case (x, y) if x == y => compare(str1.substring(x.length), str2.substring(y.length))
        case (x, y) => x compareTo y
      }
    }
  }
}
