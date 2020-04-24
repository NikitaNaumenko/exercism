(ns reverse-string)

(defn reverse-string [s]
  (loop [firstItem (first s)
         restItems (rest s)
         result '()]
    (if (= (count result) (count s))
      (apply str result)
      (recur (first restItems)
             (rest restItems)
             (conj result firstItem)))))
