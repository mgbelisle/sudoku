function stringToPuzzle(s: string): number[] {
    const puzzle = s.match(/\d/g)!.map(Number);
    if (puzzle.length !== 81) {
        throw new Error('Puzzle must be 81 digits long');
    }
    return puzzle;
}

function puzzleToString(puzzle: number[]): string {
    return Array.from({ length: 9 }, (_, i) => puzzle.slice(i * 9, i * 9 + 9).join(' ')).join('\n');
}

function buddies(idx: number): number[] {
    const row = Math.floor(idx / 9);
    const col = idx % 9;
    const box = 3 * Math.floor(row / 3) + Math.floor(col / 3);

    return Array.from({ length: 81 }, (_, idx2) => idx2).filter(idx2 => {
        const row2 = Math.floor(idx2 / 9);
        const col2 = idx2 % 9;
        const box2 = 3 * Math.floor(row2 / 3) + Math.floor(col2 / 3);
        return idx2 !== idx && (row === row2 || col === col2 || box === box2);
    });
}

function solve(puzzle: number[]): number[] {
    let possible = puzzle.map(value => value === 0 ? new Set(Array.from({ length: 9 }, (_, i) => i + 1)) : new Set([value]));

    while (true) {
        const next = possible.map(set => new Set(set));

        for (let i = 0; i < 81; i++) {
            if (next[i].size === 1) {
                const value = Array.from(next[i])[0];
                for (const buddy of buddies(i)) {
                    next[buddy].delete(value);
                }
            }
        }

        if (next.every((set, idx) => set.size === possible[idx].size && Array.from(set).every(value => possible[idx].has(value)))) {
            break;
        }

        possible = next;
    }

    return possible.map(set => set.size === 1 ? set.values().next().value : 0);
}

console.log(puzzleToString(solve(stringToPuzzle(require('fs').readFileSync(0, 'utf-8')))));