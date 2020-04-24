(ns reverse-string)
(defn reduce [f init coll]
  (loop [coll (seq coll)
         result init]
      (if (empty? coll)
        result
        (recur (rest coll)
               (f result (first coll))))))

(defn reverse-string [s]
  (apply str (reduce conj '() s)))
