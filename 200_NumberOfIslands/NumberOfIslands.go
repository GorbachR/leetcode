package NumberOfIslands

type position struct {
	i, j int
}

// First solution, not ideal since it mutates the input
func numIslands2(grid [][]byte) int {

	count := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == '1' {
				traverseIsland(grid, position{i, j})
				count++
			}
		}
	}
	return count
}

func traverseIsland(grid [][]byte, pos position) {

	if pos.i < 0 || pos.i >= len(grid) || pos.j < 0 || pos.j >= len(grid[pos.i]) || grid[pos.i][pos.j] == '0' {
		return
	}

	grid[pos.i][pos.j] = '0'

	traverseIsland(grid, position{pos.i + 1, pos.j})
	traverseIsland(grid, position{pos.i - 1, pos.j})
	traverseIsland(grid, position{pos.i, pos.j + 1})
	traverseIsland(grid, position{pos.i, pos.j - 1})
}

// ---------------------

// Implementation with queue and BFT, very slow and memory intensive!
func numIslands(grid [][]byte) int {
	count := 0
	queue := make([]position, 0)
	memo := map[position]bool{}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {

			if grid[i][j] == '1' && memo[position{i, j}] == false {

				queue = append(queue, position{i, j})

				for len(queue) > 0 {

					if memo[position{queue[0].i, queue[0].j}] == false && queue[0].i >= 0 && queue[0].i < len(grid) && queue[0].j >= 0 && queue[0].j < len(grid[0]) && grid[queue[0].i][queue[0].j] == '1' {

						memo[position{queue[0].i, queue[0].j}] = true
						queue = append(queue, position{queue[0].i + 1, queue[0].j}, position{queue[0].i - 1, queue[0].j},
							position{queue[0].i, queue[0].j + 1}, position{queue[0].i, queue[0].j - 1})
					}

					queue = queue[1:]
				}

				count++
			}
		}
	}

	return count
}
