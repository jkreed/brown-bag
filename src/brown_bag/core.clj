(ns brown-bag.core
  (:require [clojure.string :as jerek]))

(defn foo
  "I don't do a whole lot."
  [x y z & all-the-others]
  (println x y z "Hello, World!"))

(defn reverse-string 
  "Reverse a string using clojure.string/reverse."
  [s]
  (jerek/reverse s))

(defn reverse-string2
  "Reverse a string using standard recursion."
  [[f & r]]
  (if (nil? f)
    ""
    (str (reverse-string2 r) f)))

(defn reverse-string2point5 
  "Reverse a string using standard recursion."
  [[f & r]]
  (when f
    (str (reverse-string2 r) f)))

(defn reverse-string3 
  "Reverse a string with loop/recur."
  [s]
  (loop [old-s s new-s ""]
    (if (empty? old-s)
      (apply str new-s)
      (recur (rest old-s) (cons (first old-s) new-s)))))

(defn reverse-string3point5 
  "Reverse a string with loop/recur."
  [s]
  (loop [[f & r :as old-s] s new-s ""]
    (if (empty? old-s)
      (apply str new-s)
      (recur r (cons f new-s)))))

(defn reverse-string4 
  "Reverse a string using for."
  [s]
  (apply str
    (for [i (range (count s))]
      (get s (- (count s) i)))))
 
(defn reverse-string4point5 
  "Reverse a string using map."
  [s]
  (apply str (map #(get s %) (doall (range (dec (count s)) -1 -1)))))
    
(defn reverse-string5
  "Reverse a string using collection reverse, and 'apply'ing str."
  [s]
  (apply str (reverse s)))

(defn my-zipmap [keys vals]
  (loop [map {}
         [kh & kr] (seq keys)
         [vh & vr] (seq vals)]
    (if (and kh vh)
      (recur (assoc map kh vh)
             kr
             vr)
      map)))
    
