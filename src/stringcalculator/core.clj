(ns stringcalculator.core
  (:require [clojure.string :as str]))

(defn add
  [s]
  (if (= s "")
    0
    (reduce + 0 (map #(Integer/parseInt %) (str/split s #",")))))
