(ns isbn-verifier)

(defn- isbn->nums [isbn]
  (let [ch->int (fn [^Character c]
                  (cond (= c \X) 10
                        (Character/isDigit c) (Character/digit c 10)))]
    (keep ch->int isbn)))

(defn- checksum? [nums]
  (let [divisible-by? #(zero? (mod %2 %))]
    (->> (map * nums (range 10 0 -1))
         (reduce +)
         (divisible-by? 11))))

(defn isbn? [s]
  (and (some? (re-matches #"(?:\d-?){9}[\dX]" s))
       (checksum? (isbn->nums s))))
