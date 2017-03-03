(ns stringcalculator.core-test
  (:require [clojure.test :refer :all]
            [stringcalculator.core :refer :all]))

(deftest strincalculator-test
  (is (= 0 (add "")) "should return 0 when given ''")
  (is (= 1 (add "1")) "should return 1 when given '1'")
  (is (= 3 (add "1,2")) "should return 3 when given '1,2'")
  (is (= 10 (add "1,2,3,4")) "should return 10 when given '1,2,3,4'")
  (is (= 6 (add "1\n2,3")) "should return 6 when given '1\\n2,3'"))
