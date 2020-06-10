(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (let [parts (partition-by identity plain-text)]
    (->> parts
     (map #(str (when-not (= 1 (count %)) (count %)) (first %)))
     (apply str))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
   (->> cipher-text
    (re-seq #"(\d+)?(\D)")
    (map (fn [[_ number character :as arg]]
           (if-not number [(str "1" character) "1" character] arg)))
    (map (fn ([[_ number character]]
              [(Long/valueOf number) character])))
    (map (fn [[number character]]
           (apply str (repeat number character))))
    (apply str)))
