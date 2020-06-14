(ns isbn-verifier)

(defn isbn-chars [s]
  (filter #(contains? #{\0 \1 \2 \3 \4 \5 \6 \7 \8 \9 \X} %) s))

(defn checksum? [num]
  (-> num
      (mod 11)
      (zero?)))

(defn isbn? [isbn]
  (let [chars (isbn-chars isbn)
        nums (map #(if (= \X %) 10 (Character/digit ^Character % 10)) chars)]
    (and (or (re-matches #"(?:\d-?){9}[\dX]" isbn) false)
         (->> nums
           (map * (range 10 0 -1))
           (reduce +)
           (checksum?)))))

