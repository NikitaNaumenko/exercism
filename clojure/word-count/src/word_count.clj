(ns word-count
  (:require [clojure.string :as str]))

(defn word-count [s]
  (let [words (map str/lower-case (re-seq #"\w+|\d" s))]
    (reduce (fn [acc word]
              (assoc acc word (if (contains? acc word)
                                (+ 1 (get acc word))
                                1))
              ) {} words)))
