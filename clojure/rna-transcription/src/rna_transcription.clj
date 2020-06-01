(ns rna-transcription)

; (def transcription-map
;   {\C \G
;    \G \C
;    \A \U
;    \T \A})

; (defn find-n [n]
;   (or (get transcription-map n)
;       (throw (AssertionError. "Error wrong nucleotid"))))

; (defn to-rna [dna]
;   (->> dna
;         (map #(find-n %))
;         (apply str)))


(def ^:private ^:const transcriptions
  {\A \U
   \C \G
   \G \C
   \T \A})

;; `defn-` is the same as `defn ^:private`. Unfortunately, there's no `def-`.
(defn- transcribe [nucleotide]
  (or (transcriptions nucleotide)
      (throw (AssertionError. (str "Invalid nucleotide: " nucleotide)))))

(defn to-rna [dna]
  (apply str (map transcribe dna)))
