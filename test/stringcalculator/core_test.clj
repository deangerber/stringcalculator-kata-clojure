(ns stringcalculator.core-test
  (:require [clojure.test :refer :all]
            [stringcalculator.core :refer :all]))

(deftest strincalculator-test
  (is (= 0 (add "")) "should return 0 when given ''")
  (is (= 1 (add "1")) "should return 1 when given '1'"))
