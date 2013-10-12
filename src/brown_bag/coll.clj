(ns brown-bag.coll)

;;;; lists
(def my-list (list  1 2 4))
(def my-list2 '(1 2 4))
(conj my-list \a)

;;;; vectors
(map #(* % 2) [-2 3 7])
(mapv #(* % 2) [-2 3 7])

;;;; maps


;;;; sets


;;;; general
(def v [1 2 4])
(conj v v)
(def vv (conj v v))

(def vv (conj v 'v))
(def v [4 5 6])
