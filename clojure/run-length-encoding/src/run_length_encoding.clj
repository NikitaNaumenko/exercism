(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (apply str
    (for [x (partition-by identity plain-text)]
      (str
        (when-not (= 1 (count x)) (count x)) (first x)))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
    (re-seq #"[0-9]+.|[a-zA-Z\s]")
    (map #(if (= (count %) 1) (str "1" %) %))
    (map #(list (Integer. (reduce str "" (butlast %))) (str (last %))))
    (map #(apply str (repeat (first %) (second %))))
    (apply str)))

