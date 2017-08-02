(ns euler4.core
  (:require [clojure.core :as core]))

(defn palindrome? "Returns true if word is a palindrome"
  [word]
  (if (= (str word) (apply str (clojure.core/reverse (str word)))) true false))


(defn palindrome-sub-array
  "returns an array of palindromes from the largest sub-range n digit multipliers "
  [n]
  (let [high-end (int (Math/pow 10 n))
        low-end (- (int (Math/pow 10 n)) (int (Math/pow 10 (- n 1))))
        rangevec (rseq (vec (to-array (range low-end  high-end))))]
    (for [x rangevec
          y rangevec
          :let [z (* x y)]
          :when (palindrome? z)]
      [z x y])))


(defn largest-palindrome
  "returns the first palindrome found which our algorithm claims will be the largest"
  [n]
  (if (and (> n 0) (<= n 7))
    (first (palindrome-sub-array n))
    (println "Please enter a digit in (2 3 4 5 6 7)"))
  )