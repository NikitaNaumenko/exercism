(ns rna-transcription
  (:require [clojure.string :as str]))

(def transcription-map
  {"C" "G"
   "G" "C"
   "A" "U"
   "T" "A"})

(defn find-n [n]
  (let [trans-n (get transcription-map n)]
    (if-not trans-n
      (throw (AssertionError. "Error wrong nucleotid"))
      trans-n)))

(defn to-rna [dna]
  (let [list-n (str/split dna #"")]
    (->> list-n
      (map #(find-n %))
      (str/join ""))))


