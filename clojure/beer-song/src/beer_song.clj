(ns beer-song
  (:require [clojure.string :as str]))

(defn many [n] (format "%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottles of beer on the wall.\n" n n (dec n)))

(def two "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n")
(def one "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n")
(def zero "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")


(defn verse
  "Returns the nth verse of the song."
  [num]
  (case num
        0 zero
        1 one
        2 two
        (many num)))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))

  ([start end]
    (->> (range start (dec end) -1)
         (map verse)
         (str/join "\n"))))
