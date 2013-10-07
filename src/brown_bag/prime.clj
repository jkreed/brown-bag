(ns brown-bag.prime)

(defn prime? 
  "Return true if i is prime."
  [i]
  {:pre [(pos? i)]}
  (if (= 1 i)
    false
    (let [evenly-divisible (map #(zero? (mod i %)) (range 2 (Math/sqrt (inc i))))]
      (every? false? evenly-divisible))))


