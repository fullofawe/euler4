# euler4

A Clojure library designed to produce numeric palindromes from the product of two n-digit itegers

## Usage

-- Clone this project and cd into the euler4 directory
-- fire up a REPL
-- switch to namespace  euler4.core
-- find out (largest-palindrome multiplier1 multiplier2) about the largest palindrome which can be created from the product 
   of two n-digit numbers by entering:

(largest-palindrome n) where n is a digit between 2 and 7 -  be prepared to wait if you enter 7.

(e.g: 
  (largest-palindrome 2)=> [9009 99 91]
                 
  (largest-palindrome 3) => [906609 993 913]
  
  (largest-palindrome 4)=> [99000099 9999 9901]
  
  (largest-palindrome 5) => [9966006699 99979 99681]
  
  (largest-palindrome 6) => [999000000999 999999 999001]
  
  (largest-palindrome 7) => [94677111177649 9999979 9467731]           

## License

Copyright © 2017 FYIT

Distributed under the Eclipse Public License either version 1.0