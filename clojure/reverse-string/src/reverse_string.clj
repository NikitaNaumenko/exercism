(ns reverse-string)

(defn reverse-string [s]
  (loop [lastIndex (- (count s) 1)
         result ""]
    (if (= (count result) (count s))
      result
      (recur (- lastIndex 1)
             (str result (get s lastIndex))))))
