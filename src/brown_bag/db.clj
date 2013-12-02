(ns brown-bag.db
  (:require [clojure.java.jdbc :as sql]))

(def spec {:user "liquibase"
           :password "l1qu1b$e"
           :subname "//test-recondb/lm"
           :classname "net.sourceforge.jtds.jdbc.Driver"
           :subprotocol "jtds:sqlserver"})

(defn query [sql]
  (sql/with-connection spec
    (sql/with-query-results result [sql] (into [] result))))
