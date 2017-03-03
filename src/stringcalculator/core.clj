(ns stringcalculator.core
  (:require [clojure.string :as str]))

(defn- string->vector
  [[d s]]
  (map #(Integer/parseInt %) (str/split s (re-pattern d))))

(defn- sum
  [v]
  (reduce + 0 v))

(defn add
  [s]
  (cond
    (str/blank? s) 0
    (str/starts-with? s "//") (sum (string->vector [(subs (first (str/split-lines s)) 2) (second (str/split-lines s))]))
    :else (sum (string->vector [",|\n" s]))))
