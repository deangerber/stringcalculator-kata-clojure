(ns stringcalculator.core
  (:require [clojure.string :as str]))

(defn- string->vector
  [[d s]]
  (str/split s (re-pattern d)))

(defn- sum
  [v]
  (let [numbers (map #(Integer/parseInt %) v)
        negative-numbers (filterv neg? numbers)]
    (if (empty? negative-numbers)
      (reduce + 0 numbers)
      (throw (Exception. (str "negatives not allowed: " negative-numbers))))))

(defn add
  [s]
  (cond
    (str/blank? s) 0
    (str/starts-with? s "//") (sum (string->vector [(subs (first (str/split-lines s)) 2) (second (str/split-lines s))]))
    :else (sum (string->vector [",|\n" s]))))
