(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for [word prospect-list]
  (let [lower-case-word (str/lower-case word)]
    (vec
       (filter #(and (= (frequencies (str/lower-case %)) (frequencies lower-case-word))
                     (not= (str/lower-case %) lower-case-word))
                prospect-list))))
