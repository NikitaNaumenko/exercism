(ns rna-transcription)

(def transcription-map
  {\C \G
   \G \C
   \A \U
   \T \A})

(defn find-n [n]
  (or (get transcription-map n)
      (throw (AssertionError. "Error wrong nucleotid"))))

(defn to-rna [dna]
  (->> dna
        (map #(find-n %))
        (apply str)))


