(ns bob
  (:require [clojure.string :as string]))


(defn- shouting?   [s] (re-matches #"[^a-z]*[A-Z][^a-z]*" s))
(defn- question?   [s] (string/ends-with? (string/trimr s) "?"))
(defn- shouting-question?   [s] (and (shouting? s)
                                     (question? s)))

(defn response-for [s]
  (let [st (clojure.string/trim s)]
   (condp apply [st]
    string/blank? "Fine. Be that way!"
    shouting-question? "Calm down, I know what I'm doing!"
    shouting? "Whoa, chill out!"
    question? "Sure."
              "Whatever.") 
    )
)
