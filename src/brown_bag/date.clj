(ns brown-bag.date)

; date without time
; operations 
; create from various formats
; iterop with other types
; formatting

(defn- leap-year? [year] 
  {:pre [(> year 0)]}
  (or (= 0 (mod year 400))
      (and (not= 0 (mod year 100))
           (= 0 (mod year 4)))))

(defn- days-in-february [year]
  (if (leap-year? year) 29 28))

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

(def epoch [3 17 1997])

(defn get-day-number [^java.util.Date date]
  )

(defn- days-from-epoch [epoch coll])

