<<<<<<< HEAD
(ns bob)

(defn response-for [s] ;; <- arglist goes here
  ;; your code goes here
)
=======
(ns bob
  (:require [clojure.string :refer [ends-with? blank? upper-case]]))

(defn- has-alpha?  [s] (some #(Character/isLetter (int %)) s))

(defn- upper-case? [s] (= s (upper-case s)))

(defn- shouting?   [s] (and (upper-case? s)
                            (has-alpha? s)))

(defn- shouting-question?   [s] (and (upper-case? s)
                                     (ends-with? s "?")
                                     (has-alpha? s)))


(defn- question?   [s] (and (ends-with? s "?")
                            (not (shouting? s))))

(defn- silence?    [s] (blank? s))

(defn response-for [s]
  (let [st (clojure.string/trim s)]
   (condp apply [st]
    silence?  "Fine. Be that way!"
    shouting-question? "Calm down, I know what I'm doing!"
    shouting? "Whoa, chill out!"
    question? "Sure."
              "Whatever.") 
    )
  )
>>>>>>> add bob cloj
