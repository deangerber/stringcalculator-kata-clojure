(ns stringcalculator.core
  (:require [clojure.string :as str]))

(def string->integer #(Integer/parseInt %))

(defn- string->vector
  [[d s]]
  (str/split (reduce #(str/replace %1 %2 "\000") s (re-seq #"(?<=\[)[^\]]+|(?<=//)[^\[]" d)) #"\000"))

(defn- sum
  [v]
  (let [numbers (filter #(<= % 1000) (map string->integer v))
        negative-numbers (filterv neg? numbers)]
    (if (empty? negative-numbers)
      (reduce + 0 numbers)
      (throw (Exception. (str "negatives not allowed: " negative-numbers))))))

(defn add
  [s]
  (cond
    (str/blank? s) 0
    (str/starts-with? s "//") (sum (string->vector (str/split-lines s)))
    :else (sum (string->vector ["[,][\n]" s]))))
