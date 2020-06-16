(ns word-count
  (:require [clojure.string :as str]))

(defn word-count [s]
  (->> s
       (str/lower-case)
       (re-seq #"\w+")
       (reduce #(update % %2 (fnil inc 0)) {})))

; (defn word-count [s]
;   (->> (str/lower-case s)
;        (re-seq #"\w+")
;        (frequencies)))
