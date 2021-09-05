(ns collatz-conjecture)

(defn collatz [num]
  (when (or (zero? num) (neg? num)) (throw Throwable))
  (loop [acc 0
         new-num num]
    (if (= new-num 1)
      acc
      (recur (+ acc 1) (if (even? new-num) (/ new-num 2) (+ (* new-num 3) 1)) ))))
