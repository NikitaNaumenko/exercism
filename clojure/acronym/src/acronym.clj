(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [text]
  (->> text
       (#(str/split % #" "))
       (mapcat #(str/split % #"(?<=[a-z])(?=[A-Z])"))
       (mapcat #(str/split % #"-"))
       (map first)
       (map #(when ((complement nil?) %) (Character/toUpperCase %)))
       (apply str)))
