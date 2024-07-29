let puzzle = require('fs').readFileSync(0, 'utf-8').match(/\d/g).map(Number);
if (puzzle.length !== 81) {
  console.log('Puzzle must be 81 digits long');
  process.exit(1);
}
console.log(puzzle);