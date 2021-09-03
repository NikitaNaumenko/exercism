(ns accumulate)

(defn accumulate [f list]
  (if (empty? list) []
      (loop [arr list
             acc []]
        (let [result (f (first arr))
              new-arr (rest arr)
              new-acc (conj acc result)]
          (if (empty? new-arr)
            new-acc
            (recur new-arr new-acc))))))
