(defproject sudoku "0.1.0-SNAPSHOT"
  :description "Simple sudoku solver"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot sudoku.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
