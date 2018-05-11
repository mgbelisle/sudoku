# Running

```sh
kotlinc kotlin/Sudoku.kt -include-runtime -d /tmp/sudoku.jar
java -jar /tmp/sudoku.jar data/easy.txt
```

# Thoughts

Writing this in Kotlin was great, really easy since I already knew java.

# Speed

Solved `data/easy.txt` in 53ms.