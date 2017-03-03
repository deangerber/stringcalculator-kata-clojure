(ns stringcalculator.core)

(defn add
  [s]
  (if (= s "")
    0
    (Integer/parseInt s)))
