(ns sudoku.solve-test
  (:use clojure.test
        sudoku.core
        sudoku.samples))

(deftest sudoku-test
  (testing "buddies"
    (is (= (set (buddies 0)) (set '(0 1 2 3 4 5 6 7 8 ;; Row
                                      0 9 18 27 36 45 54 63 72 ;; Column
                                      0 1 2 9 10 11 18 19 20)))) ;; Block
    (is (= (set (buddies 75)) (set '(72 73 74 75 76 77 78 79 80 ;; Row
                                        3 12 21 30 39 48 57 66 75 ;; Column
                                        57 58 59 66 67 68 75 76 77))))) ;; Block
  (testing "solve"
    (is (= (solve sample1) [4 9 5  2 8 1  7 3 6
                            1 2 3  7 9 6  5 8 4
                            6 8 7  3 4 5  9 2 1
                            
                            5 1 4  8 6 2  3 9 7
                            3 6 2  4 7 9  1 5 8
                            9 7 8  5 1 3  6 4 2
                            
                            8 3 6  1 5 4  2 7 9
                            2 4 1  9 3 7  8 6 5
                            7 5 9  6 2 8  4 1 3]))))
