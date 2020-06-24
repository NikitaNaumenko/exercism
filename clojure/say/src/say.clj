(ns say
  (:require [clojure.string :as str])
  )

(def special-nums {0 "zero"
                   1 "one"
                   2 "two"
                   3 "three"
                   4 "four"
                   5 "five"
                   6 "six"
                   7 "seven"
                   8 "eight"
                   9 "nine"
                   10 "ten"
                   11 "eleven"
                   12 "twelve"
                   13 "thirteen"
                   14 "fourteen"
                   15 "fifteen"
                   16 "sixteen"
                   17 "seventeen"
                   18 "eighteen"
                   19 "nineteen"
                   20 "twenty"
                   30 "thirty"
                   40 "fourty"
                   50 "fifty"
                   60 "sixty"
                   70 "seventy"
                   80 "eighty"
                   90 "ninety"})

(def small-numbers ["zero", "one", "two", "three", "four", "five", "six",
                    "seven", "eight", "nine", "ten", "eleven", "twelve",
                    "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                    "eighteen", "nineteen"])

(def tens ["twenty", "thirty", "forty", "fifty", "sixty",
           "seventy", "eighty", "ninety"])

(defn split-by-numbers [num]
  (loop [x num
         acc []]
    (if (zero? x)
      (reverse acc)
      (recur (quot x 1000)
           (conj acc (rem x 1000))))))

(defn detect-number [number-by-array]
  (cond
    (>= (count number-by-array) 10) "billion"
    (>= (count number-by-array) 6) "million"
    (>= (count number-by-array) 4) "thousand"
    (>= (count number-by-array) 3) "hundred"
    (>= (count number-by-array) 2) "decimal"
    (>= (count number-by-array) 1) "prime"
    )
  )

(defn build-ast-node [cur-n digit-place]
  (if (< cur-n 100)
    { :hundred nil :num cur-n })
  (let [[first second third] (map #(Long/valueOf %) (str/split (str cur-n) #""))]
    {:hundred first
     :num (if (> second 0) (+ (* second 10) third) third)
     }
   
    )
  )


(build-ast-node 123 3)
(defn build-ast-num [num]
  (loop [n num
         acc []]
    (if (empty? n)
      acc
      (recur (rest n)
             (conj acc (build-ast-node (first n) (count n)))
             ))))



(defn build-less-than-100 [num]
  ( let  [base (get tens (- (quot num 10) 2))
                      remainder (mod num 10)
                      ones  (get small-numbers remainder)]
                  (if (zero? remainder) base (str base "-" ones))))

(defn render-ast [ast]
  (println :jopa)
  (reduce (fn [acc val]
            (println val)
            (conj acc (build-less-than-100 (:num val))
   )) [] ast))
 
(render-ast (build-ast-num [23]))
(render-ast (build-ast-num [93]))
(render-ast (build-ast-num [53]))
(render-ast (build-ast-num [43]))
(defn transform-numbers [cur-digit num]
  
  )

(defn convert-numbers-to-words [numbers]
  (loop [x numbers
         acc []]
    (if (empty? numbers)
      (apply str acc)
      (recur (rest x)
             (conj acc (transform-numbers (first x) x)))))

  ; (rest [1 2 3 4])

  ; (let [[first second] numbers]
  ;   (cond
  ;     (= (count numbers) 1) (get special-nums first)
  ;     (= first 1) (get special-nums (+ 10 second))
  ;     (zero? second) (get special-nums (* first 10))
  ;     :else (str (get special-nums (* first 10) ) "-" (get special-nums second))
  ;     )
  ;   )
  )
(defn number [number]
  (when-not (< -1 number 1000000000000)
    (throw (IllegalArgumentException. "number out of bounds")))
  (if (zero? number)
    "zero"
    (->> number
         (split-by-numbers)
         (convert-numbers-to-words)
         )))
; (split-by-numbers 1234567890)
; (1 111 234 567 890)

; (count (str 1000000000000))
