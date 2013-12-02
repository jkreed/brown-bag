(ns brown-bag.date2)

; date without time
; operations 
; create from various formats
; iterop with other types
; formatting

(defrecord Date [month day year])

(declare days-diff)

(defn- leap-year? [year] 
  {:pre [(> year 0)]}
  (or (= 0 (mod year 400))
      (and (not= 0 (mod year 100))
           (= 0 (mod year 4)))))

(defn- days-in-february [year]
  (if (leap-year? year) 29 28))

(defn- days-in-year [year]
  (if (leap-year? year) 366 365))

(def months
  (let [has-31-days (constantly 31)
        has-30-days (constantly 30)]
    {1 has-31-days
     2 days-in-february
     3 has-31-days
     4 has-30-days
     5 has-31-days
     6 has-30-days
     7 has-31-days
     8 has-31-days
     9 has-30-days
     10 has-31-days
     11 has-30-days
     12 has-31-days}))

;(def epoch [3 17 1997]) ; day zero
(def epoch (Date. 3 17 1997))

(defn from-java [^java.util.Date date]
  (Date. (inc (.getMonth date)) (.getDate date) (+ 1900 (.getYear date)))) 

(defn- get-day-number 
  ([month day year] (get-day-number (Date. month day year)))
  ([d] (days-diff epoch d)))

(defn- day-of-year [date]
  (let [f (fn [month] ((get months month) (:year date)))
        d (map f (range 1 (:month date)))  
        t (reduce + d)]
   (+ t (:day date)))) 

(defn- remaining-days-of-year [date]
  (let [year (:year date)]
    (- (days-in-year year) (day-of-year date))))

(defn- days-diff [left right]
  (let [r (range (:year left) (inc (:year right)))
        d (map days-in-year r)
        t (reduce + d)]
    (- t (remaining-days-of-year right) (day-of-year left))))
  
(defmulti day-number class)
(defmethod day-number java.util.Date [d] (get-day-number (from-java d)))
(defmethod day-number brown_bag.date2.Date [d] (get-day-number d))
(defmethod day-number clojure.lang.PersistentVector [d] (apply get-day-number d))
