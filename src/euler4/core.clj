(ns euler4.core
  (:require [clojure.core :as core]))

(defn palindrome? "Returns true if word is a palindrome"
  [word]
  (if (= (str word) (apply str (clojure.core/reverse (str word)))) true false))


(defn palindrome-sub-array
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
  "returns a sorted array of the largest palindrmes that are a product of two n digit numbers"
  [n]
  (reduce (fn [max-pal [x i]]
            (if (zero? (mod x i))
                 (palindrome-sub-array x i)
                 (palindrome-sub-array x (inc i))))
          0
          (for [x (range 2 (inc n)) i (range 1 n)]
            [n i])))

(defn largest-palindrome
  [n]
  (if (and (> n 1) (<= n 7))
    (first (large-palindrome n))
    (println "Please enter a digit in (2 3 4 5 6 7)"))
  )