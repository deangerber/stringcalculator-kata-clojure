(ns stringcalculator.core
  (:require [clojure.string :as str]))

(defn add
  [s]
  (cond
    (str/blank? s) 0
    (str/starts-with? s "//") (reduce + 0 (map #(Integer/parseInt %) (str/split (second (str/split-lines s)) (re-pattern (subs (first (str/split-lines s)) 2)))))
    :else (reduce + 0 (map #(Integer/parseInt %) (str/split s #",|\n")))))
