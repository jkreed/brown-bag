(ns brown-bag.proto)

(defprotocol Speaker
  (speak [arg] "Say something!"))

(defrecord Person [name age awesome?])

(extend-type String
  Speaker
    (speak [arg] (str "Strings rule: " arg)))

(extend-type nil
  Speaker
    (speak [arg] arg))

(extend-type Person
  Speaker
    (speak [arg] (str "I'm " (when-not (get arg :awesome?) "not ") " awesome!")))
(extend-type Person
  Speaker
    (speak [arg] (str "FAIL!")))

(extend-type Object
  Speaker
    (speak [arg] (str arg)))

