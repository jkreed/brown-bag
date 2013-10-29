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
  (let [31-days-hath (constantly 31)
        30-days-hath (constantly 30)]
    {1 31-days-hath
     2 days-in-february
     3 31-days-hath
     4 30-days-hath
     5 31-days-hath
     6 30-days-hath
     7 31-days-hath
     8 31-days-hath
     9 30-days-hath
     10 31-days-hath
     11 30-days-hath
     12 31-days-hath}))

(def epoch [3 17 1997])

(defn get-day-number [^java.util.Date date]
  )

(defn- days-from-epoch [epoch coll])

