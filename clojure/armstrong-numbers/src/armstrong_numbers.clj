(ns armstrong-numbers)

(defn num-to-digits [num]
  (->> num str (map (comp read-string str))))

(defn expt [base pow]
  (reduce * 1 (repeat pow base)))

(defn armstrong? [num]
  (let [pow (count (str num))
        digits (num-to-digits num)
        sum (reduce + (map #(expt % pow) digits))]
    (= sum num)))

