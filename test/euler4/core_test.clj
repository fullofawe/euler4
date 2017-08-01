(ns euler4.core-test
  (:require [clojure.spec.alpha :as s]
            [clojure.core :as core]
            ))

(defn palindrome? "Returns true if word is a palindrome"
  [word]
  (if (= (str word) (apply str (clojure.core/reverse (str word)))) true false))

(s/def ::palindrome palindrome?)

(defn palindrome-array
  "constructs an array of all possible pallidromes that are a product
  of two 'n' digit numbers"
  [n]
  (let [rangevec (rseq (vec (to-array (range (int (Math/pow 10 (dec n))) (int (Math/pow 10 n))))))]
    (for [x rangevec
              y rangevec
              :let [z (* x y)]
              :when (palindrome? z)]
          [z x y]
          )))

(defn largest-palindrome?
  "returns true if z is the largest n digit palendrome"
  [n z]
  (= z (ffirst (rseq (into (sorted-set) (palindrome-array n))))))


(s/def ::n-digits (s/and int? #(< % 7)))
(s/def ::big-palindrome (s/and int? palindrome?))
(s/def ::can-find-largest-palindrome (s/keys :req [::n-digits ::big-palindrome]))

(s/def ::x int?)
(s/def ::y int?)
(s/def ::z palindrome?)

(s/def ::palindrome-info (s/keys :req [::x ::y ::z]))


(commment
  (s/valid? ::palindrome 232)
  (s/valid? ::largest-palindrome 906609)


  (s/valid? ::can-find-largest-palindrome
            {::n-digits 3
             ::big-palindrome 73937})


  (s/valid? ::palindrome-info
            {::x 101
             ::y 111
             ::z 11211})

  (s/valid? ::palindrome-info
            {::x 993
             ::y 913
             ::z 906609})

  (s/valid? ::palindrome-info
            {::x 913
             ::y 993
             ::z 906609})

  (largest-palindrome? 3 11211)
  (largest-palindrome? 3 906609)


  (defn palindrome-array
    "constructs an array of all possible pallidromes that are a product
    of two '3' digit numbers"
    []
    (let [rangevec (rseq (vec (to-array (range 100 1000))))]
      (for [x rangevec
            y rangevec
            :let [z (* x y)]
            :when (palindrome? z)]
        [z x y]
        )))


  )