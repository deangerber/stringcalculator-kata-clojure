(ns stringcalculator.core-test
  (:require [clojure.test :refer :all]
            [stringcalculator.core :refer :all]))

(deftest stringcalculator-test
  (is (= 0 (add "")) "should return 0 when given ''")
  (is (= 1 (add "1")) "should return 1 when given '1'")
  (is (= 3 (add "1,2")) "should return 3 when given '1,2'")
  (is (= 10 (add "1,2,3,4")) "should return 10 when given '1,2,3,4'")
  (is (= 6 (add "1\n2,3")) "should return 6 when given '1\\n2,3'")
  (is (= 3 (add "//;\n1;2")) "should return 3 when given '//;\\n1;2'")
  (is (thrown-with-msg? Exception #"negatives not allowed: \[-2 -4\]" (add "//;\n1;-2;3;-4")) "should throw exception when given '//;\\n1;-2;3;-4'")
  (is (= 2 (add "//;\n2;1001")) "should return 2 when given '//;\\n2;1001'")
  (is (= 6 (add "//[***]\n1***2***3")) "should return 6 given '//[***]\\n1***2***3'")
  (is (= 6 (add "//[*][%]\n1*2%3")) "should return 6 given '//[*][%]\\n1*2%3'")
  (is (= 6 (add "//[**][%%]\n1**2%%3")) "should return 6 given '//[**][%%]\\n1**2%%3'"))
