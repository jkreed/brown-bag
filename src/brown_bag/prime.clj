(ns brown-bag.prime)

(defn prime? 
  "Return true if i is prime."
  [i]
  {:pre [(pos? i)]}
  (if (= 1 i)
    false
    (let [evenly-divisible (map #(zero? (mod i %)) (range 2 (Math/sqrt (inc i))))]
      (every? false? evenly-divisible))))

(defn prime?2 
  "Return true if i is prime."
  [i]
  {:pre [(pos? i)]}
  (if (= 1 i)
    false
    (let [coll (range 2 (Math/sqrt (inc i)))
          evenly-divisible (map mapper coll)]
      (every? false? evenly-divisible))))


