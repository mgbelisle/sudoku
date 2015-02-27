(ns sudoku.core
  (:use clojure.set))

(defn buddies
  "Returns indices that are buddies of the given index (row, column, and block)"
  [i]
  (let [row-col-block #(let [row (quot % 9)
                             col (mod % 9)
                             block (+ (* 3 (quot row 3)) (quot col 3))]
                         [row col block])
        [row1 col1 block1] (row-col-block i)]
    (filter #(let [[row2 col2 block2] (row-col-block %)]
               (or (= row1 row2)
                   (= col1 col2)
                   (= block1 block2)))
            (range 81))))

(defn- cell-solved? [cell] (= (count cell) 1))

(defn solve
  "Solves a sudoku grid.  Param grid is vector[81] with 0 for unknown values."
  [grid]

  ;; Turn the grid array into an array of sets, each set representing the options for that cell
  (loop [cells (mapv #(if (zero? %) (set (range 1 10)) #{%}) grid)]

    (if (every? cell-solved? cells)
      ;; If every cell is solved then return the solution
      (mapv first cells)

      ;; Otherwise identify the known cells and clean out their buddies' sets
      (let [next-cells (mapv (fn [i cell]
                               (if (cell-solved? cell)
                                 cell
                                 (let [taken (apply union (filter cell-solved? (map #(get cells %) (buddies i))))]
                                   (difference cell taken))))
                             (range 81) cells)]

        ;; If we've made progress then keep going
        (if (= next-cells cells)
          cells ;; No progress, give up
          (recur next-cells))))))
