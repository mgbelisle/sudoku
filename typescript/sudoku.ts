function stringToPuzzle(s: string): number[] {
    const puzzle = s.match(/\d/g).map(Number);
    if (puzzle.length !== 81) {
        process.exit('Puzzle must be 81 digits long');
    }
    return puzzle;
}

const puzzle = stringToPuzzle(require('fs').readFileSync(0, 'utf-8'));