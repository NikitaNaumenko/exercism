(ns armstrong-numbers)

; (defn num-to-digits [num]
;   (->> num str (map (comp read-string str))))

; (defn expt [base pow]
;   (reduce * 1 (repeat pow base)))

; (defn armstrong? [num]
;   (let [pow (count (str num))
;         digits (num-to-digits num)
;         sum (reduce + (map #(expt % pow) digits))]
;     (= sum num)))

(defn- num->digits [n]
  (mapv #(Character/digit ^Character % 10) (str n)))

(defn- expt [base pow]
  (reduce * 1 (repeat pow base)))

(defn armstrong? [num]
  (let [digits (num->digits num)
        pow    (count digits)]
    (->> (map #(expt % pow) digits)
         (apply +) ;; apply works too.
         (= num))))
