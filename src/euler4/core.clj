(ns euler4.core
  (:require [clojure.core :as core]))

(defn palindrome? "Returns true if word is a palindrome"
  [word]
  (if (= (str word) (apply str (clojure.core/reverse (str word)))) true false))


(defn palindrome-sub-array
  "returns an array of palindromes from a sub-range of "
  [n iteration]
  (let [high-end (int (Math/pow 10 n))
        low-end (- (int (Math/pow 10 n)) (* iteration (int (Math/pow 10 (- n 1)))))
        rangevec (rseq (vec (to-array (range low-end  high-end))))]
    (for [x rangevec
          y rangevec
          :let [z (* x y)]
          :when (palindrome? z)]
      [z x y])))

(defn large-palindrome
  "returns a sorted list of arrays with information about the largest palindromes that are a product of two n digit numbers"
  [n]
  (reduce (fn [max-pal [x i]]
            (palindrome-sub-array n i))
          0
          (for [ x (range 9) i (range 2)]
            [x i])))

(defn largest-palindrome
  "returns the first palindrome found which our algorithm claims will be the largest"
  [n]
  (if (and (> n 0) (<= n 7))
    (first (large-palindrome n))
    (println "Please enter a digit in (2 3 4 5 6 7)"))
  )


