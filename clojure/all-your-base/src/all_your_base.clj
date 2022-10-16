(ns all-your-base)

(defn convert-to-10 [num base]
  (int (reduce +
               (map #(* (second %) (Math/pow base (first %)))
                    (reverse (map-indexed vector
                                          (reverse num)))))))

(defn convert-to-base [num base]
  (loop [result num
         acc []]
    (if (< result base)
      (reverse (conj acc result))
      (recur (unchecked-divide-int result base) (conj acc (mod result base))))))


(defn convert [base num o-base]
  (cond
    (or (neg? o-base) (zero? o-base) (neg? base)) nil
    (empty? num) nil
    ; (= base 10) (convert-to-base num o-base)
    :else (convert-to-base (convert-to-10 num base) o-base)))

(convert 10 '(5) 2)
