(ns say
  (:require [clojure.string :as str]
            [clojure.pprint :as pretyprint])
  )


(defn number [num] ;; <- arglist goes here
  (if
   (or (< num 0) (> num 999999999999))
    (throw (IllegalArgumentException. "Out of range"))
    (str/replace (pretyprint/cl-format nil "~R" num) #"," "")))

